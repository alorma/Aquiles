package com.alorma.aquiles.request;

import android.support.annotation.NonNull;

import com.github.tomakehurst.wiremock.client.MappingBuilder;

import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;

public abstract class Request {
    private Path path;
    private Map<String, String> headersMap;
    private Map<String, String> queryMap;


    public static Request get() {
        return new GetRequest();
    }

    public static Request post() {
        return new PostRequest();
    }

    public static Request patch() {
        return new PatchRequest();
    }

    public static Request put() {
        return new PutRequest();
    }

    public static Request delete() {
        return new DeleteRequest();
    }

    public Request setPath(Path path) {
        this.path = path;
        return this;
    }

    public Request withQuery(String key, String value) {
        if (this.queryMap == null) {
            this.queryMap = new HashMap<>();
        }
        this.queryMap.put(key, value);
        return this;
    }

    public Request withHeader(String key, String value) {
        if (this.headersMap == null) {
            this.headersMap = new HashMap<>();
        }
        this.headersMap.put(key, value);
        return this;
    }

    public MappingBuilder build() {
        MappingBuilder request = createMappingBuilder(path);
        request = addHeaderParams(request);
        request = addQueryParams(request);
        return request;
    }

    @NonNull
    protected abstract MappingBuilder createMappingBuilder(Path path);

    private MappingBuilder addHeaderParams(MappingBuilder request) {
        if (headersMap != null) {
            for (Map.Entry<String, String> queryParam : headersMap.entrySet()) {
                request = addHeaderParam(request, queryParam);
            }
        }
        return request;
    }

    private MappingBuilder addHeaderParam(MappingBuilder request, Map.Entry<String, String> queryParam) {
        return request.withHeader(queryParam.getKey(), equalTo(queryParam.getValue()));
    }

    private MappingBuilder addQueryParams(MappingBuilder request) {
        if (queryMap != null) {
            for (Map.Entry<String, String> queryParam : queryMap.entrySet()) {
                request = addQueryParam(request, queryParam);
            }
        }
        return request;
    }

    private MappingBuilder addQueryParam(MappingBuilder request, Map.Entry<String, String> queryParam) {
        return request.withQueryParam(queryParam.getKey(), equalTo(queryParam.getValue()));
    }

}
