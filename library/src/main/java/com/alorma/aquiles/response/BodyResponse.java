package com.alorma.aquiles.response;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class BodyResponse extends Response {
  private final String body;

  public BodyResponse(String body) {
    this.body = body;
  }

  @Override
  public ResponseDefinitionBuilder buildResponse() {
    return aResponse().withBody(body);
  }
}
