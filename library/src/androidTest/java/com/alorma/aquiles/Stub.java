package com.alorma.aquiles;

import com.alorma.aquiles.request.Request;
import com.alorma.aquiles.response.EmptyResponse;
import com.alorma.aquiles.response.Response;
import com.github.tomakehurst.wiremock.WireMockServer;

public class Stub {
    private final WireMockServer server;

    public Stub(WireMockServer server) {
        this.server = server;
    }

    public void stub(Request request) {
        stub(request, new EmptyResponse());
    }

    public void stub(Request request, Response response) {
        server.stubFor(request.build().willReturn(response.build()));
    }
}
