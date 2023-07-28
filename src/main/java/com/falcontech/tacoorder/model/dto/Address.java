package com.falcontech.tacoorder.model.dto;

import com.google.common.hash.Hashing;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.nio.charset.StandardCharsets;

@Data
public class Address {
  @NotBlank private String street;
  @NotBlank private String city;
  @NotBlank private String state;
  @NotBlank private String zip;
  @NotBlank private String country;
  private String hash;

  public com.falcontech.tacoorder.model.mongo.Address toMongoAddress() {
    var mongoAddress = new com.falcontech.tacoorder.model.mongo.Address();
    mongoAddress.setStreet(this.street);
    mongoAddress.setCity(this.city);
    mongoAddress.setState(this.state);
    mongoAddress.setZip(this.zip);
    mongoAddress.setCountry(this.country);
    mongoAddress.setHash(this.hash);
    return mongoAddress;
  }

  public Address() {
    setHash();
  }

  private void setHash() {
    String originalString = street + city + state + zip + country;
    this.hash = Hashing.sha256().hashString(originalString, StandardCharsets.UTF_8).toString();
  }
}
