package com.alorma.aquiles;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.matching.UrlPathPattern;

import java.util.Map;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

public class Stub {
    protected final WireMockServer server;

    public Stub(WireMockServer server) {
        this.server = server;
    }

    protected void stub(StubOptions options) {
        UrlPathPattern urlPathPattern = urlPathEqualTo(options.getPath());
        MappingBuilder request = get(urlPathPattern);

        if (options.getQueryMap() != null) {
            for (Map.Entry<String, String> queryParam : options.getQueryMap().entrySet()) {
                request = request.withQueryParam(queryParam.getKey(), equalTo(queryParam.getValue()));
            }
        }

        StubResponse stubResponse = options.getResponse();

        ResponseDefinitionBuilder response;

        if (stubResponse.getResponsePath() != null) {
            response = getResponseFromFile(stubResponse.getResponsePath());
        } else if (stubResponse.getResponseBody() != null) {
            response = aResponse().withBody(stubResponse.getResponseBody());
        } else {
            throw new RuntimeException("Need response");
        }

        stubFor(request.willReturn(response));
    }

    protected ResponseDefinitionBuilder getResponseFromFile(String filename) {
        String responseString = JsonReaderUtil.getStringFromFile(getInstrumentation().getContext(), filename);
        return aResponse().withBody(responseString);
    }
}