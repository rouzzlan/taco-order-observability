package com.falcontech.tacoorder.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Address {
  @NotBlank String street;
  @NotBlank String city;
  @NotBlank String state;
  @NotBlank String zip;
  @NotBlank String country;

  public com.falcontech.tacoorder.model.mongo.Address toMongoAddress() {
    var mongoAddress = new com.falcontech.tacoorder.model.mongo.Address();
    mongoAddress.setStreet(this.street);
    mongoAddress.setCity(this.city);
    mongoAddress.setState(this.state);
    mongoAddress.setZip(this.zip);
    mongoAddress.setCountry(this.country);
    return mongoAddress;
  }
}
