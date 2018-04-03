/*
 * MessageMediaLookups
 */
package com.messagemedia.lookups.models;

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

    /**
     * The number that you wish to lookup
     */
    public LookupAPhoneNumberResponseBuilder phoneNumber(String phoneNumber) {
        lookupAPhoneNumberResponse.setPhoneNumber(phoneNumber);
        return this;
    }

    /**
     * The type of number. This can be mobile or landline
     */
    public LookupAPhoneNumberResponseBuilder type(String type) {
        lookupAPhoneNumberResponse.setType(type);
        return this;
    }

    /**
     * Carrier's name as reported by the network
     */
    public LookupAPhoneNumberResponseBuilder carrier(Object carrier) {
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
