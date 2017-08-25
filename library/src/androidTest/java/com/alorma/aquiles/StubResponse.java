package com.alorma.aquiles;

class StubResponse {
    private final String responsePath;
    private final String responseBody;

    StubResponse(String responsePath, String responseBody) {
        this.responsePath = responsePath;
        this.responseBody = responseBody;
    }

    public String getResponsePath() {
        return responsePath;
    }

    public String getResponseBody() {
        return responseBody;
    }
}