package com.falcontech.tacoorder.model.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("TacoOrderAddress")
public class Address {
    @Id
    private String id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    @Indexed
    private String hash;

    public com.falcontech.tacoorder.model.dto.Address toDTO() {
        var dto = new com.falcontech.tacoorder.model.dto.Address();
        dto.setId(this.id);
        dto.setHash(this.hash);
        dto.setStreet(this.street);
        dto.setCity(this.city);
        dto.setState(this.state);
        dto.setZip(this.zip);
        dto.setCountry(this.country);
        return dto;
    }
}
