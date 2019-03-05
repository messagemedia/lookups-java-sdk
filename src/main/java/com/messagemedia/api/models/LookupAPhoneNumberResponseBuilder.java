package com.messagemedia.api.models;

import java.util.*;

public class LookupAPhoneNumberResponseBuilder {
    //the instance to build
    private LookupAPhoneNumberResponse lookupAPhoneNumberResponse;

 
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

    public LookupAPhoneNumberResponseBuilder result(String result) {
        lookupAPhoneNumberResponse.setResult(result);
        return this;
    }


    public LookupAPhoneNumberResponseBuilder imsi(long imsi) {
        lookupAPhoneNumberResponse.setImsi(imsi);
        return this;
    }


    public LookupAPhoneNumberResponseBuilder location(int location) {
        lookupAPhoneNumberResponse.setLocation(location);
        return this;
    }

    public LookupAPhoneNumberResponse build() {
        return lookupAPhoneNumberResponse;
    }
}