package com.falcontech.tacoorder.model.dto;

import lombok.Data;

@Data
public class Order {
    private String id;
    private String name;
    private String email;
    private String UUID;
    private Address address;

    public com.falcontech.tacoorder.model.mongo.Order toMongoOrder() {
        var mongoOrder = new com.falcontech.tacoorder.model.mongo.Order();
        mongoOrder.setUuid(java.util.UUID.randomUUID());
        mongoOrder.setName(this.name);
        mongoOrder.setEmail(this.email);
        return mongoOrder;
    }
}
