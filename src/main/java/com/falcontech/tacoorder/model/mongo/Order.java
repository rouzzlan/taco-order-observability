package com.falcontech.tacoorder.model.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.UUID;

@Data
@Document("Order")
public class Order {
    @Id
    private String id;
    private UUID uuid;
    private String name;
    private String email;
    @Field(targetType = FieldType.OBJECT_ID)
    private String address;

    public com.falcontech.tacoorder.model.dto.Order toDTO() {
        var dto = new com.falcontech.tacoorder.model.dto.Order();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setUUID(this.uuid.toString());
        dto.setEmail(this.email);
        return dto;
    }
}
