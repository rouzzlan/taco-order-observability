package com.falcontech.tacoorder.model.mongo;

import lombok.Getter;

@Getter
public enum IngredientType {
  SAUCE("SAUCE"),
  WRAP("WRAP"),
  PROTEIN("PROTEIN"),
  VEGGIES("VEGGIES"),
  CHEESE("CHEESE");

  private final String name;

  IngredientType(String name) {
    this.name = name;
  }
}
