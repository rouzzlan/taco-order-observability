package com.falcontech.tacoorder.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;
import lombok.Data;

@Data
public class Order {
  @NotBlank String name;

  @Email(message = "not valid email")
  String email;

  @Valid Address address;

  public com.falcontech.tacoorder.model.mongo.Order toMongoOrder() {
    var mongoOrder = new com.falcontech.tacoorder.model.mongo.Order();
    mongoOrder.setUuid(UUID.randomUUID());
    mongoOrder.setName(this.name);
    mongoOrder.setEmail(this.email);
    mongoOrder.setAddress(this.address.toMongoAddress());
    return mongoOrder;
  }
}
