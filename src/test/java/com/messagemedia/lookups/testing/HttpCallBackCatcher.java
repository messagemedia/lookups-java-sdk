/*
 * MessageMediaLookups
 */
package com.messagemedia.lookups.testing;

import com.messagemedia.lookups.controllers.syncwrapper.SynchronousBase;
import com.messagemedia.lookups.http.client.HttpCallBack;
import com.messagemedia.lookups.http.client.HttpContext;
import com.messagemedia.lookups.http.request.HttpRequest;
import com.messagemedia.lookups.http.response.HttpResponse;

/**
 * An HTTPCallBack that captures the request and response for use later
 */
public class HttpCallBackCatcher extends SynchronousBase implements HttpCallBack {

    private HttpRequest request;
    private HttpResponse response;

    /**
     * Call back executed before the HTTP request is sent
     */
    public void OnBeforeRequest(HttpRequest request) {
        // Nothing to do here
    }

    /**
     * Call back executed after the HTTP response is received
     * but before the APICallBack's handler is called
     */
    public void OnAfterResponse(HttpContext context) {
        setRequest(context.getRequest());
        setResponse(context.getResponse());
        this.markAsDone();
    }

    /**
     * Get the HTTP Request object associated with this API call
     * @return
     */
    public HttpRequest getRequest() {
        return request;
    }

    /**
     * Set the HTTP Request object associated with this API call
     * @param request
     */
    private void setRequest(HttpRequest prequest) {
        this.request = prequest;
    }

    /**
     * Get the HTTP Response object associated with this API call
     * @return
     */
    public HttpResponse getResponse() {
        return response;
    }

    /**
     * Get the HTTP Response object associated with this API call
     * @param httpResponse
     */
    private void setResponse(HttpResponse httpResponse) {
        this.response = httpResponse;
    }
}
