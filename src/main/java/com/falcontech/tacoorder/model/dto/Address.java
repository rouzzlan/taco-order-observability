package com.falcontech.tacoorder.model.dto;

import com.google.common.hash.Hashing;
import lombok.Data;

import java.nio.charset.StandardCharsets;

@Data
public class Address {
    private String id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String hash;

    public com.falcontech.tacoorder.model.mongo.Address toMongoAddress() {
        setHash();
        var mongoAddress = new com.falcontech.tacoorder.model.mongo.Address();
        mongoAddress.setStreet(this.street);
        mongoAddress.setCity(this.city);
        mongoAddress.setState(this.state);
        mongoAddress.setZip(this.zip);
        mongoAddress.setCountry(this.country);
        mongoAddress.setHash(this.hash);
        return mongoAddress;
    }

    public void setHash() {
        String originalString = street + city + state + zip + country;
        this.hash = Hashing.sha256().hashString(originalString, StandardCharsets.UTF_8).toString();
    }
}
