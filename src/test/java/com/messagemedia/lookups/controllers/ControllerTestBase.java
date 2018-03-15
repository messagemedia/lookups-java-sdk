/*
 * MessageMediaLookups
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.lookups.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;

import com.messagemedia.lookups.Configuration;
import com.messagemedia.lookups.MessageMediaLookupsClient;
import com.messagemedia.lookups.testing.HttpCallBackCatcher;

/**
 * Base class for all test cases
 */
public class ControllerTestBase {
    /**
     * Test configuration
     */
    public final static int REQUEST_TIMEOUT = 30;

    public final static double ASSERT_PRECISION = 0.01;
    
    /**
     * Global rules for tests
     */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(REQUEST_TIMEOUT);
    
    /**
     * Test fixtures
     */
    
    // Used to serve as HttpCallBack and to capture request & response
    protected HttpCallBackCatcher httpResponse = new HttpCallBackCatcher();
    
    /**
     * Setup test
     */
    @Before
    public void setUp() throws Exception {
        httpResponse = new HttpCallBackCatcher(); 
        Configuration.basicAuthUserName = System.getenv("MessageMediaApiTestsKey");
        Configuration.basicAuthPassword = System.getenv("MessageMediaApiTestsSecret");
    }

    /**
     * Tear down test
     */
    @After
    public void tearDown() throws Exception {
        if(httpResponse.getResponse() != null)
            httpResponse.getResponse().shutdown();
        httpResponse = null;
    }
    
    // Singleton instance of client for all test classes
    private static MessageMediaLookupsClient client;
    private static Object clientSync = new Object();
    
    /**
     * Get client instance
     * @return
     */
    protected static MessageMediaLookupsClient getClient() {
        if(client == null)
            synchronized (clientSync) {
                client = new MessageMediaLookupsClient();
            }
        return client;
    }
}