package com.falcontech.tacoorder.model.dto;

import lombok.Data;

@Data
public class OrderR {
    private String id;
    private String name;
    private String email;
    private String UUID;
    private AddressR address;
}
