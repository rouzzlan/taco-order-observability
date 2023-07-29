package com.falcontech.tacoorder.model.mongo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@Document("Order")
public class Order {
  @Id private String id;
  private UUID uuid;
  private String name;
  private String email;
  @DocumentReference private Address address;
  //  @DocumentReference private Set<Ingredient> ingredients;

  //  public Order() {
  //    this.ingredients = new HashSet<>();
  //  }
  public com.falcontech.tacoorder.model.dto.OrderR toDTO() {
    var dto = new com.falcontech.tacoorder.model.dto.OrderR();
    dto.setId(this.id);
    dto.setName(this.name);
    dto.setUUID(this.uuid.toString());
    dto.setEmail(this.email);
    dto.setAddress(this.address.toDTO());
    return dto;
  }
}
