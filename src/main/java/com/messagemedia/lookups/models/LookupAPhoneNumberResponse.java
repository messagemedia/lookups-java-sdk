/*
 * MessageMediaLookups
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.lookups.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class LookupAPhoneNumberResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5123364479240536658L;
    private String countryCode;
    private String phoneNumber;
    private String type;
    private Object carrier;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("country_code")
    public String getCountryCode ( ) { 
        return this.countryCode;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("country_code")
    public void setCountryCode (String value) { 
        this.countryCode = value;
    }
 
    /** GETTER
     * The number that you wish to lookup
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber ( ) { 
        return this.phoneNumber;
    }
    
    /** SETTER
     * The number that you wish to lookup
     */
    @JsonSetter("phone_number")
    public void setPhoneNumber (String value) { 
        this.phoneNumber = value;
    }
 
    /** GETTER
     * The type of number. This can be mobile or landline
     */
    @JsonGetter("type")
    public String getType ( ) { 
        return this.type;
    }
    
    /** SETTER
     * The type of number. This can be mobile or landline
     */
    @JsonSetter("type")
    public void setType (String value) { 
        this.type = value;
    }
 
    /** GETTER
     * Carrier's name as reported by the network
     */
    @JsonGetter("carrier")
    public Object getCarrier ( ) { 
        return this.carrier;
    }
    
    /** SETTER
     * Carrier's name as reported by the network
     */
    @JsonSetter("carrier")
    public void setCarrier (Object value) { 
        this.carrier = value;
    }
 
}
 