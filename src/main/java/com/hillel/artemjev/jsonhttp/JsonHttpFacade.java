package com.hillel.artemjev.jsonhttp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.hillel.artemjev.jsonhttp.httprequest.HttpRequestFactory;
import com.hillel.artemjev.jsonhttp.httprequest.JsonHttpRequestFactory;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class JsonHttpFacade {
    private final HttpRequestFactory httpRequestFactory;
    private final ObjectMapper mapper;
    private final HttpClient httpClient;

    public JsonHttpFacade() {
        this.mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        this.httpRequestFactory = new JsonHttpRequestFactory(mapper);
        this.httpClient = HttpClient.newBuilder().build();
    }

    public <T> T get(String uri, Class<T> tClass) {
        HttpRequest request = httpRequestFactory.createGetRequest(uri);
        return getHttpResponse(tClass, request);
    }

    public <T> T getAuth(String uri, Class<T> tClass, String token) {
        HttpRequest request = httpRequestFactory.createAuthorizedGetRequest(uri, token);
        return getHttpResponse(tClass, request);
    }

    public <T> T post(String uri, Object objRequest, Class<T> tClass) {
        HttpRequest request = httpRequestFactory.createPostRequest(
                uri,
                objRequest
        );
        return getHttpResponse(tClass, request);
    }

    public <T> T postAuth(String uri, Object objRequest, Class<T> tClass, String token) {
        HttpRequest request = httpRequestFactory.createAuthorizedPostRequest(
                uri,
                objRequest,
                token
        );
        return getHttpResponse(tClass, request);
    }

    //-----------------------------------------------------------------------------------------------
    private <T> T getHttpResponse(Class<T> tClass, HttpRequest request) {
        T result = null;
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            result = mapper.readValue(response.body(), tClass);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
