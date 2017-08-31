package com.alorma.aquiles;

import com.github.tomakehurst.wiremock.WireMockServer;

public interface Verb {
  void stub(WireMockServer server);
}
