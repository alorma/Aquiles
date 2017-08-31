package com.alorma.aquiles.request;

import android.support.annotation.NonNull;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

class PostRequest extends Request {
  @NonNull
  @Override
  protected MappingBuilder createMappingBuilder(Path path) {
    return WireMock.post(path.build());
  }
}
