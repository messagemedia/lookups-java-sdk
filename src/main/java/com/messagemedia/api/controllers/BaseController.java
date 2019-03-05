package com.messagemedia.api.controllers;

import com.messagemedia.api.exceptions.*;
import com.messagemedia.api.http.client.HttpClient;
import com.messagemedia.api.http.client.HttpContext;
import com.messagemedia.api.http.client.HttpCallBack;
import com.messagemedia.api.http.client.OkClient;
import com.messagemedia.api.http.response.HttpResponse;

public abstract class BaseController {
  
    private static HttpClient clientInstance = null;
    private static final Object syncObject = new Object();
    protected static final String userAgent = "APIMATIC 2.0";

 
    protected HttpCallBack httpCallBack = null;
    
 
    public HttpCallBack getHttpCallBack() {
        return httpCallBack;
    }
    
 
    public void setHttpCallBack(HttpCallBack httpCallBack) {
        this.httpCallBack = httpCallBack;
    }

  
    public static HttpClient getClientInstance() {
        if (null == clientInstance) {
            synchronized (syncObject) {
                if (null == clientInstance) {
                    clientInstance = OkClient.getSharedInstance();
                }
            }
        }
        return clientInstance;
    }


    public static void setClientInstance(HttpClient client) {
        if (null != client) {
            synchronized (syncObject) {
                if (null != client) {
                    clientInstance = client;
                }
            }
        }
    }


    protected void validateResponse(HttpResponse response, HttpContext context) 
            throws APIException {
        //get response status code to validate
        int responseCode = response.getStatusCode();
        if ((responseCode < 200) || (responseCode > 208)) //[200,208] = HTTP OK
            throw new APIException("HTTP Response Not OK", context);
    }
}
