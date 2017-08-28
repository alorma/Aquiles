package com.alorma.aquiles.request;

import com.github.tomakehurst.wiremock.matching.UrlPathPattern;

import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;

public class Path {
    private final String path;
    private final boolean exactPath;

    private Path(String path, boolean exactPath) {
        this.path = path;
        this.exactPath = exactPath;
    }

    public UrlPathPattern build() {
        return exactPath ? urlPathEqualTo(path) : urlPathMatching(path);
    }

    public static class Builder {
        private String path;
        private boolean exactPath = true;

        public Builder setExactPath(boolean exactPath) {
            this.exactPath = exactPath;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Path build() {
            return new Path(path, exactPath);
        }
    }
}
