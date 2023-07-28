package com.falcontech.tacoorder.model.mongo;

import com.falcontech.tacoorder.model.IngredientType;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Accessors(chain = true)
@Document("Ingredient")
public class Ingredient {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    @Indexed
    @Field(targetType = FieldType.STRING)
    private IngredientType type;
    @Indexed(unique = true)
    private String hash;

}
