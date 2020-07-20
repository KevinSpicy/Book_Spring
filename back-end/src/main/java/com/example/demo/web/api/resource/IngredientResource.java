package com.example.demo.web.api.resource;

import com.example.demo.model.Ingredient;
import org.springframework.hateoas.RepresentationModel;

public class IngredientResource extends RepresentationModel<IngredientResource> {

    private String name;
    private Ingredient.Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient.Type getType() {
        return type;
    }

    public void setType(Ingredient.Type type) {
        this.type = type;
    }
}
