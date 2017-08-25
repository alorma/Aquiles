package com.alorma.aquiles;

import java.util.HashMap;
import java.util.Map;

public class Builder {

    private String path;
    private StubResponse response;
    private Map<String, String> queryMap;

    public Builder setPath(String path) {
        this.path = path;
        return this;
    }

    public Builder setResponsePath(String responsePath) {
        this.response = new StubResponse(responsePath, null);
        return this;
    }

    public Builder setResponseBody(String responseBody) {
        this.response = new StubResponse(null, responseBody);
        return this;
    }

    public Builder setQueryParam(String key, String value) {
        if (this.queryMap == null) {
            this.queryMap = new HashMap<>();
        }
        this.queryMap.put(key, value);
        return this;
    }

    public StubOptions build() {
        return new StubOptions(path, response, queryMap);
    }
}