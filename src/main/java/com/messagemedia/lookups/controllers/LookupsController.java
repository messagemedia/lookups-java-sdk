/*
 * MessageMediaLookups
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.lookups.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.type.TypeReference;

import com.messagemedia.lookups.*;
import com.messagemedia.lookups.models.*;
import com.messagemedia.lookups.exceptions.*;
import com.messagemedia.lookups.http.client.HttpClient;
import com.messagemedia.lookups.http.client.HttpContext;
import com.messagemedia.lookups.http.request.HttpRequest;
import com.messagemedia.lookups.http.response.HttpResponse;
import com.messagemedia.lookups.http.response.HttpStringResponse;
import com.messagemedia.lookups.http.client.APICallBack;
import com.messagemedia.lookups.controllers.syncwrapper.APICallBackCatcher;

public class LookupsController extends BaseController {    
    //private static variables for the singleton pattern
    private static Object syncObject = new Object();
    private static LookupsController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the LookupsController class 
     */
    public static LookupsController getInstance() {
        synchronized (syncObject) {
            if (null == instance) {
                instance = new LookupsController();
            }
        }
        return instance;
    }

    /**
     * Use the Lookups API to find information about a phone number.
     * A request to the lookups API has the following format:
     * ```/v1/lookups/phone/{phone_number}?options={carrier,type}```
     * The `{phone_number}` parameter is a required field and should be set to the phone number to be looked up.
     * The options query parameter can also be used to request additional information about the phone number.
     * By default, a request will only return the `country_code` and `phone_number` properties in the response.
     * To request details about the the carrier, include `carrier` as a value of the options parameter.
     * To request details about the type, include `type` as a value of the options parameter. To pass multiple values
     * to the options parameter, use a comma separated list, i.e. `carrier,type`.
     * A successful request to the lookups endpoint will return a response body as follows:
     * ```json
     * {
     *   "country_code": "AU",
     *   "phone_number": "+61491570156",
     *   "type": "mobile",
     *   "carrier": {
     *     "name": "Telstra"
     *   }
     * }
     * ```
     * Each property in the response body is defined as follows:
     * - ```country_code``` ISO ALPHA 2 country code of the phone number
     * - ```phone_number``` E.164 formatted phone number
     * - ```type``` The type of number. This can be ```"mobile"``` or ```"landline"```
     * - ```carrier``` Holds information about the specific carrier (if available)
     *   - ```name``` The carrier's name as reported by the network
     * @param    phoneNumber    Required parameter: The phone number to be looked up
     * @param    options    Optional parameter: Example: 
     * @return    Returns the LookupAPhoneNumberResponse response from the API call 
     */
    public LookupAPhoneNumberResponse getLookupAPhoneNumber(
                final String phoneNumber,
                final String options
    ) throws Throwable {
        APICallBackCatcher<LookupAPhoneNumberResponse> callback = new APICallBackCatcher<LookupAPhoneNumberResponse>();
        getLookupAPhoneNumberAsync(phoneNumber, options, callback);
        if(!callback.isSuccess())
            throw callback.getError();
        return callback.getResult();
    }

    /**
     * Use the Lookups API to find information about a phone number.
     * A request to the lookups API has the following format:
     * ```/v1/lookups/phone/{phone_number}?options={carrier,type}```
     * The `{phone_number}` parameter is a required field and should be set to the phone number to be looked up.
     * The options query parameter can also be used to request additional information about the phone number.
     * By default, a request will only return the `country_code` and `phone_number` properties in the response.
     * To request details about the the carrier, include `carrier` as a value of the options parameter.
     * To request details about the type, include `type` as a value of the options parameter. To pass multiple values
     * to the options parameter, use a comma separated list, i.e. `carrier,type`.
     * A successful request to the lookups endpoint will return a response body as follows:
     * ```json
     * {
     *   "country_code": "AU",
     *   "phone_number": "+61491570156",
     *   "type": "mobile",
     *   "carrier": {
     *     "name": "Telstra"
     *   }
     * }
     * ```
     * Each property in the response body is defined as follows:
     * - ```country_code``` ISO ALPHA 2 country code of the phone number
     * - ```phone_number``` E.164 formatted phone number
     * - ```type``` The type of number. This can be ```"mobile"``` or ```"landline"```
     * - ```carrier``` Holds information about the specific carrier (if available)
     *   - ```name``` The carrier's name as reported by the network
     * @param    phoneNumber    Required parameter: The phone number to be looked up
     * @param    options    Optional parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void getLookupAPhoneNumberAsync(
                final String phoneNumber,
                final String options,
                final APICallBack<LookupAPhoneNumberResponse> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;
        
        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/v1/lookups/phone/{phone_number}");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5168836180889932873L;
            {
                    put( "phone_number", phoneNumber );
            }});

        //process query parameters
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 4922967359263086600L;
            {
                    put( "options", options );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4671008517157046201L;
            {
                    put( "user-agent", "messagemedia-lookups-java-sdk-1.0.0" );
                    put( "accept", "application/json" );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null,
                                        Configuration.basicAuthUserName, Configuration.basicAuthPassword);

        //invoke the callback before request if its not null
        if (getHttpCallBack() != null)
        {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();
                            if (_responseCode == 404)
                                throw new APIException("Number was invalid", _context);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            LookupAPhoneNumberResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<LookupAPhoneNumberResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

}