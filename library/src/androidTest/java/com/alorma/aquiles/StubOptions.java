package com.alorma.aquiles;

import java.util.Map;

class StubOptions {
    private final String path;
    private final StubResponse response;
    private final Map<String, String> queryMap;

    StubOptions(String path, StubResponse response, Map<String, String> queryMap) {
        this.path = path;
        this.response = response;
        this.queryMap = queryMap;
    }

    public String getPath() {
        return path;
    }

    public StubResponse getResponse() {
        return response;
    }

    public Map<String, String> getQueryMap() {
        return queryMap;
    }

}