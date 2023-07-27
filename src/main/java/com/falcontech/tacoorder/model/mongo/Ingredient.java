package com.falcontech.tacoorder.model.mongo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Accessors(chain = true)
@Document("TacoOrders")
public class Ingredient {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Indexed(unique = true)
    private String name;
    @Indexed
    @Field(targetType = FieldType.STRING)
    private IngredientType type;
    @Indexed
    private String hash;

}
