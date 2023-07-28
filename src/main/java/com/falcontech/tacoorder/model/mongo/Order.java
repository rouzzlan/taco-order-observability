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
@Accessors(chain = true)
public class Order {
  @Id
  private String id;
  private UUID uuid;
  private String name;
  private String email;
  @DocumentReference
  private Address address;
//  @DocumentReference private Set<Ingredient> ingredients;

//  public Order() {
//    this.ingredients = new HashSet<>();
//  }
}
