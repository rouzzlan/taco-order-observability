package com.falcontech.tacoorder.model.dto;

import lombok.Data;

@Data
public class AddressR {
    private String id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String hash;
}
