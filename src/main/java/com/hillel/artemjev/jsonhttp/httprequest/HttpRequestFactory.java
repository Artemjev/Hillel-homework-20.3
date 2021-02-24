package com.hillel.artemjev.jsonhttp.httprequest;

import java.net.http.HttpRequest;

public interface HttpRequestFactory {
    HttpRequest createGetRequest(String url);

    HttpRequest createPostRequest(String url, Object obj);

    HttpRequest createAuthorizedGetRequest(String url, String token);

    HttpRequest createAuthorizedPostRequest(String url, Object obj, String token);
}
