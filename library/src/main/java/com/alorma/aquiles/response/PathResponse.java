package com.alorma.aquiles.response;

import com.alorma.aquiles.util.JsonReaderUtil;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class PathResponse extends Response {

  private String fileName;

  public PathResponse(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public ResponseDefinitionBuilder buildResponse() {
    String responseString = JsonReaderUtil.getStringFromFile(getInstrumentation().getContext(), fileName);
    return aResponse().withBody(responseString);
  }
}
