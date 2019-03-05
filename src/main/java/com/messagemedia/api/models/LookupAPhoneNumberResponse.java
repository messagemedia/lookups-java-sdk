package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class LookupAPhoneNumberResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -3282649719022236652L;
    private String countryCode;
    private String phoneNumber;
    private String type;
    private Carrier carrier;
    private String result;
    private long imsi;
    private int location;

    @JsonGetter("country_code")
    public String getCountryCode ( ) { 
        return this.countryCode;
    }
    
 
    @JsonSetter("country_code")
    public void setCountryCode (String value) { 
        this.countryCode = value;
    }
 
  
    @JsonGetter("phone_number")
    public String getPhoneNumber ( ) { 
        return this.phoneNumber;
    }
    
  
    @JsonSetter("phone_number")
    public void setPhoneNumber (String value) { 
        this.phoneNumber = value;
    }
 
 
    @JsonGetter("type")
    public String getType ( ) { 
        return this.type;
    }
    
  
    @JsonSetter("type")
    public void setType (String value) { 
        this.type = value;
    }
 

    @JsonGetter("carrier")
    public Carrier getCarrier ( ) { 
        return this.carrier;
    }
    

    @JsonSetter("carrier")
    public void setCarrier (Carrier value) { 
        this.carrier = value;
    }
 

    @JsonGetter("result")
    public String getResult ( ) { 
        return this.result;
    }
    

    @JsonSetter("result")
    public void setResult (String value) { 
        this.result = value;
    }
 

    @JsonGetter("imsi")
    public long getImsi ( ) { 
        return this.imsi;
    }
    

    @JsonSetter("imsi")
    public void setImsi (long value) { 
        this.imsi = value;
    }
 
 
    @JsonGetter("location")
    public int getLocation ( ) { 
        return this.location;
    }
    

    @JsonSetter("location")
    public void setLocation (int value) { 
        this.location = value;
    }
 
}
