package com.alorma.aquiles.response;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;

public abstract class Response {

  private int statusCode = 200;

  public Response setStatusCode(int statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  public ResponseDefinitionBuilder build() {
    return buildResponse().withStatus(statusCode);
  }

  protected abstract ResponseDefinitionBuilder buildResponse();
}
