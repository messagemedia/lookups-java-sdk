package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Carrier 
        implements java.io.Serializable {
    private static final long serialVersionUID = -78903481635549854L;
    private String name;
  
    @JsonGetter("name")
    public String getName ( ) { 
        return this.name;
    }
    

    @JsonSetter("name")
    public void setName (String value) { 
        this.name = value;
    }
 
}
