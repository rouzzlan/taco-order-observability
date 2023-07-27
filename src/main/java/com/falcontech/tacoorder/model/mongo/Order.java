package com.falcontech.tacoorder.model.mongo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("TacoOrders")
@Accessors(chain = true)
public class Order {
  @MongoId(FieldType.OBJECT_ID)
  private String id;
  private UUID uuid;
  private String name;
  private String email;
  @DBRef private Address address;
  @DBRef private Set<Ingredient> ingredients;

  public Order() {
    this.ingredients = new HashSet<>();
  }
}
