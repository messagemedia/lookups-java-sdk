package com.messagemedia.api.exceptions;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.messagemedia.api.http.client.HttpContext;

public class LookupAPhoneNumber404ResponseException 
        extends APIException
        implements java.io.Serializable {
    private static final long serialVersionUID = -106802515514044657L;
    private String message;
   

    @JsonGetter("message")
    public String getMessage ( ) { 
        return this.message;
    }
    

    @JsonSetter("message")
    private void setMessage (String value) { 
        this.message = value;
    }
 
    /**
     * Initialization constructor
     * @param   reason  The reason for throwing exception
     * @param   context The http context of the API exception
     */
    public LookupAPhoneNumber404ResponseException(String reason, HttpContext context) {
        super(reason, context);
    }
}
