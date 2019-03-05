package com.messagemedia.api.http.client;

import com.messagemedia.api.exceptions.APIException;
import com.messagemedia.api.http.request.HttpBodyRequest;
import com.messagemedia.api.http.request.HttpRequest;
import com.messagemedia.api.http.response.HttpResponse;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public interface HttpClient {

     /**
     * Sets a timeout for HTTP requests
     * @param   timeout    The timeout in seconds
     */
    public void setTimeout(long timeout);

    /**
     * Execute a given HttpRequest to get string response back
     * @param   request     The given HttpRequest to execute
     * @param   callBack    Callback after execution
     */
    public void executeAsStringAsync(final HttpRequest request, final APICallBack<HttpResponse> callBack);

    /**
     * Execute a given HttpRequest to get binary response back
     * @param   request     The given HttpRequest to execute
     * @param   callBack    Callback after execution
     */
    public void executeAsBinaryAsync(final HttpRequest request, final APICallBack<HttpResponse> callBack);


    public HttpResponse executeAsBinary(final HttpRequest request) throws APIException;


    public HttpResponse executeAsString(final HttpRequest request) throws APIException;


    public HttpRequest get(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                    String _username, String _password);


    public HttpRequest get(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);


    public HttpRequest head(String _queryUrl,
            Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
            String _username, String _password);


    public HttpRequest head(String _queryUrl,
            Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);


    public HttpRequest post(String _queryUrl,
                     Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);



    public HttpRequest post(String _queryUrl,
                     Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                     String _username, String _password);

 
    public HttpBodyRequest postBody(String _queryUrl,
                             Map<String, String> _headers, String _body);

  
    public HttpBodyRequest postBody(String _queryUrl,
                             Map<String, String> _headers, String _body,
                             String _username, String _password);

  
    public HttpRequest put(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

 
    HttpRequest put(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                    String _username, String _password);

  
    HttpBodyRequest putBody(String _queryUrl,
                            Map<String, String> _headers, String _body);

 
    public HttpBodyRequest putBody(String _queryUrl,
                            Map<String, String> _headers, String _body,
                            String _username, String _password);

  
    public HttpRequest patch(String _queryUrl,
                      Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);


    HttpRequest patch(String _queryUrl,
                      Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                      String _username, String _password);


    public HttpBodyRequest patchBody(String _queryUrl,
                              Map<String, String> _headers, String _body);


    public HttpBodyRequest patchBody(String _queryUrl,
                              Map<String, String> _headers, String _body,
                              String _username, String _password);

  
    HttpRequest delete(String _queryUrl,
                       Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

  
    public HttpRequest delete(String _queryUrl,
                       Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                       String _username, String _password);


    public HttpBodyRequest deleteBody(String _queryUrl,
                               Map<String, String> _headers, String _body);

    public HttpBodyRequest deleteBody(String _queryUrl,
                               Map<String, String> _headers, String _body,
                               String _username, String _password);
}