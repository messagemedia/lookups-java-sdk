package com.messagemedia.api.models;

import java.util.*;

public class CarrierBuilder {
    //the instance to build
    private Carrier carrier;

 
    public CarrierBuilder() {
        carrier = new Carrier();
    }

    public CarrierBuilder name(String name) {
        carrier.setName(name);
        return this;
    }

    public Carrier build() {
        return carrier;
    }
}