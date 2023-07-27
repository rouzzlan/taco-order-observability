package com.falcontech.tacoorder.model.mongo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Accessors(chain = true)
@Document("TacoOrderAddress")
public class Address {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    @Indexed
    private String hash;
}
