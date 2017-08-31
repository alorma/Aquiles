package com.alorma.aquiles;

import com.alorma.aquiles.request.Request;
import com.alorma.aquiles.response.EmptyResponse;
import com.alorma.aquiles.response.Response;
import com.alorma.aquiles.response.StatusResponse;
import com.github.tomakehurst.wiremock.WireMockServer;

public class Stub {
  public static void stub(WireMockServer server, Request request, Response response) {
    server.stubFor(request.build().willReturn(response.build()));
  }

  public static void stub(WireMockServer server, Request request) {
    server.stubFor(request.build().willReturn(new EmptyResponse().build()));
  }

  public static void stub(WireMockServer server, Request request, int statusCode) {
    server.stubFor(request.build().willReturn(new StatusResponse(statusCode).build()));
  }
}
