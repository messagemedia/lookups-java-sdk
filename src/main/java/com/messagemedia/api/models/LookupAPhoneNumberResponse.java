package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class LookupAPhoneNumberResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = 1334659501243468399L;
    private String countryCode;
    private String phoneNumber;
    private String type;
    private Carrier carrier;
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
     * TODO: Write general description for this method
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber ( ) { 
        return this.phoneNumber;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("phone_number")
    public void setPhoneNumber (String value) { 
        this.phoneNumber = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("type")
    public String getType ( ) { 
        return this.type;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("type")
    public void setType (String value) { 
        this.type = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("carrier")
    public Carrier getCarrier ( ) { 
        return this.carrier;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("carrier")
    public void setCarrier (Carrier value) { 
        this.carrier = value;
    }
 
}
