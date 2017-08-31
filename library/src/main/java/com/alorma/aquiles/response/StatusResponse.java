package com.alorma.aquiles.response;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class StatusResponse extends Response {

  public StatusResponse(int statusCode) {
    setStatusCode(statusCode);
  }

  @Override
  protected ResponseDefinitionBuilder buildResponse() {
    return aResponse();
  }
}
