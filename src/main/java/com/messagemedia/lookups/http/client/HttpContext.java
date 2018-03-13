/*
 * MessageMediaLookups
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.lookups.http.client;

import com.messagemedia.lookups.http.request.HttpRequest;
import com.messagemedia.lookups.http.response.HttpResponse;

public class HttpContext {
    private HttpRequest _request;
    private HttpResponse _response;

    public HttpContext(HttpRequest request, HttpResponse response) {
        _request = request;
        _response = response;
    }

    /**
     * Getter for the Http Request
     * @return HttpRequest request
     */
    public HttpRequest getRequest() {
        return _request;
    }

    /**
     * Getter for the Http Response
     * @return HttpResponse response
     */
    public HttpResponse getResponse() {
        return _response;
    }
}