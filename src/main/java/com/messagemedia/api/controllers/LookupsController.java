package com.messagemedia.api.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.type.TypeReference;

import com.messagemedia.api.*;
import com.messagemedia.api.models.*;
import com.messagemedia.api.exceptions.*;
import com.messagemedia.api.http.client.HttpClient;
import com.messagemedia.api.http.client.HttpContext;
import com.messagemedia.api.http.request.HttpRequest;
import com.messagemedia.api.http.response.HttpResponse;
import com.messagemedia.api.http.response.HttpStringResponse;
import com.messagemedia.api.http.client.APICallBack;
import com.messagemedia.api.controllers.syncwrapper.APICallBackCatcher;

public class LookupsController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static LookupsController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the LookupsController class 
     */
    public static LookupsController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new LookupsController();
                }
            }
        }
        return instance;
    }

    /**
     * Use the Lookups API to find information about a phone number.
     * A request to the lookups API has the following format:
     * ```/v1/lookups/phone/{phone_number}?options={x}```
     * where `{x}` is an individual value or a combination of values. 
     * The `{phone_number}` parameter is a required field and should be set to the phone number to be looked up.
     * The options query parameter can also be used to request additional information about the phone number.
     * By default, a request will only return the `country_code` and `phone_number` properties in the response.
     * ```json
     * {
     *   "country_code": "AU",
     *   "phone_number": "+61491570156",
     * }
     * ```
     * To request details about the the carrier, include `carrier` as a value of the options parameter and to 
     * request details about the type, include `type` as a value of the options parameter. The `carrier` and
     * and the `type` values can be used together using a comma separated list, i.e. `carrier,type`.
     * To request details about the location, include `hlr` as a value of the options parameter. 
     * NOTE: The `hlr` value CANNOT be used in conjuction with the other values.
     * A successful request to the lookups endpoint with `carrier` and `type` as values will return a response body as follows:
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
     * A successful request to the lookups endpoint with `hlr` as the value will return a response body as follows:
     * ```json
     * {
     *     "result": "OK",
     *     "imsi": 24008,
     *     "location": 46
     * }
     * ```
     * Each property in the response body is defined as follows:
     * - ```country_code``` ISO ALPHA 2 country code of the phone number
     * - ```phone_number``` E.164 formatted phone number
     * - ```type``` The type of number. This can be ```"mobile"``` or ```"landline"```
     * - ```carrier``` Holds information about the specific carrier (if available)
     *   - ```name``` The carrier's name as reported by the network
     * - `imsi` A unique number identifying a GSM subscriber
     * - `location` The location of the mobile number
     * @param    phoneNumber    Required parameter: The phone number to be looked up
     * @param    options    Optional parameter: The options query parameter can also be used to request additional information about the phone number.
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
     * ```/v1/lookups/phone/{phone_number}?options={x}```
     * where `{x}` is an individual value or a combination of values. 
     * The `{phone_number}` parameter is a required field and should be set to the phone number to be looked up.
     * The options query parameter can also be used to request additional information about the phone number.
     * By default, a request will only return the `country_code` and `phone_number` properties in the response.
     * ```json
     * {
     *   "country_code": "AU",
     *   "phone_number": "+61491570156",
     * }
     * ```
     * To request details about the the carrier, include `carrier` as a value of the options parameter and to 
     * request details about the type, include `type` as a value of the options parameter. The `carrier` and
     * and the `type` values can be used together using a comma separated list, i.e. `carrier,type`.
     * To request details about the location, include `hlr` as a value of the options parameter. 
     * NOTE: The `hlr` value CANNOT be used in conjuction with the other values.
     * A successful request to the lookups endpoint with `carrier` and `type` as values will return a response body as follows:
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
     * A successful request to the lookups endpoint with `hlr` as the value will return a response body as follows:
     * ```json
     * {
     *     "result": "OK",
     *     "imsi": 24008,
     *     "location": 46
     * }
     * ```
     * Each property in the response body is defined as follows:
     * - ```country_code``` ISO ALPHA 2 country code of the phone number
     * - ```phone_number``` E.164 formatted phone number
     * - ```type``` The type of number. This can be ```"mobile"``` or ```"landline"```
     * - ```carrier``` Holds information about the specific carrier (if available)
     *   - ```name``` The carrier's name as reported by the network
     * - `imsi` A unique number identifying a GSM subscriber
     * - `location` The location of the mobile number
     * @param    phoneNumber    Required parameter: The phone number to be looked up
     * @param    options    Optional parameter: The options query parameter can also be used to request additional information about the phone number.
     * @return    Returns the void response from the API call 
     */
    public void getLookupAPhoneNumberAsync(
                final String phoneNumber,
                final String options,
                final APICallBack<LookupAPhoneNumberResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //the base uri for api requests
                String _baseUri = Configuration.baseUri;

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder("/v1/lookups/phone/{phone_number}");

                //process template parameters
                Map<String, Object> _templateParameters = new HashMap<String, Object>();
                _templateParameters.put("phone_number", phoneNumber);
                APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

                ///process query parameters
                Map<String, Object> _queryParameters = new HashMap<String, Object>();
                if (options != null) {
                    _queryParameters.put("options", options);
                }
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);

                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>();
                _headers.put("user-agent", BaseController.userAgent);
                _headers.put("accept", "application/json");


                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //apply basic or hmac-based auth
                try {
                    AuthManager.apply(_queryBuilder.toString(), _request.getHeaders());
                } catch (Exception exception) {
                    //let the caller know of the error
                    callBack.onFailure(null, exception);
                    return;
                }

                //invoke request and get response
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
                                throw new LookupAPhoneNumber404ResponseException("Unexpected error in API call. See HTTP response body for details.", _context);

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