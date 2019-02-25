package com.messagemedia.api.models;

import java.util.*;

public class LookupAPhoneNumberResponseBuilder {
    //the instance to build
    private LookupAPhoneNumberResponse lookupAPhoneNumberResponse;

    /**
     * Default constructor to initialize the instance
     */
    public LookupAPhoneNumberResponseBuilder() {
        lookupAPhoneNumberResponse = new LookupAPhoneNumberResponse();
    }

    public LookupAPhoneNumberResponseBuilder countryCode(String countryCode) {
        lookupAPhoneNumberResponse.setCountryCode(countryCode);
        return this;
    }

    public LookupAPhoneNumberResponseBuilder phoneNumber(String phoneNumber) {
        lookupAPhoneNumberResponse.setPhoneNumber(phoneNumber);
        return this;
    }

    public LookupAPhoneNumberResponseBuilder type(String type) {
        lookupAPhoneNumberResponse.setType(type);
        return this;
    }

    public LookupAPhoneNumberResponseBuilder carrier(Carrier carrier) {
        lookupAPhoneNumberResponse.setCarrier(carrier);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public LookupAPhoneNumberResponse build() {
        return lookupAPhoneNumberResponse;
    }
}