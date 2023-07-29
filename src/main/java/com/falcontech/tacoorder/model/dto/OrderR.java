package com.falcontech.tacoorder.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderR {
    private String id;
    private String name;
    private String email;
    private String UUID;
    private AddressR address;

    public com.falcontech.tacoorder.model.mongo.OrderR toMongoOrder() {
        var mongoOrder = new com.falcontech.tacoorder.model.mongo.OrderR();
        mongoOrder.setUuid(java.util.UUID.randomUUID());
        mongoOrder.setName(this.name);
        mongoOrder.setEmail(this.email);
        return mongoOrder;
    }
}
