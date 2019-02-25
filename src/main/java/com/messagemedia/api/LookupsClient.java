package com.messagemedia.api;

import com.messagemedia.api.controllers.*;
import com.messagemedia.api.http.client.HttpClient;

public class LookupsClient {
    /**
     * Singleton access to Lookups controller
     * @return	Returns the LookupsController instance 
     */
    public LookupsController getLookups() {
        return LookupsController.getInstance();
    }

    /**
     * Get the shared http client currently being used for API calls
     * @return The http client instance currently being used
     */
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    
    /**
     * Set a shared http client to be used for API calls
     * @param httpClient The http client to use
     */
    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }

    /**
     * Client initialization constructor
     */
    public LookupsClient(String authUserName, String authPassword, boolean hmacAuth) {
        if(!hmacAuth)
        {
            Configuration.basicAuthUserName = authUserName;
            Configuration.basicAuthPassword = authPassword;
        }
        else
        {
            Configuration.hmacAuthUserName = authUserName;
            Configuration.hmacAuthPassword = authPassword;
        }
    }

}