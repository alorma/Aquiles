package com.alorma.aquiles.response;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class EmptyResponse extends Response {

    @Override
    public ResponseDefinitionBuilder buildResponse() {
        return aResponse();
    }
}
