package com.falcontech.tacoorder.model.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("Order")
public class OrderR {
    @Id
    private String id;
    private UUID uuid;
    private String name;
    private String email;
    private String address;

    public com.falcontech.tacoorder.model.dto.OrderR toDTO() {
        var dto = new com.falcontech.tacoorder.model.dto.OrderR();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setUUID(this.uuid.toString());
        dto.setEmail(this.email);
        return dto;
    }
}
