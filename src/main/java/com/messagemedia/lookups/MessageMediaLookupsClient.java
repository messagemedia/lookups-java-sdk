/*
 * MessageMediaLookups
 */
package com.messagemedia.lookups;

import com.messagemedia.lookups.controllers.*;
import com.messagemedia.lookups.http.client.HttpClient;

public class MessageMediaLookupsClient {
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
     * Default constructor
     */
    public MessageMediaLookupsClient() {
    }

    /**
     * Client initialization constructor
     */
    public MessageMediaLookupsClient(String authUserName, String authPassword, Boolean hmac) {
        this();
        if(hmac) {
        	Configuration.basicAuthUserName = authUserName;
            Configuration.basicAuthPassword = authPassword;
        }else {
        	Configuration.hmacAuthUserName = authUserName;
            Configuration.hmacAuthPassword = authPassword;
        }
    }
}
