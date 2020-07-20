package com.example.demo.web.api.resource.resourceassembler;

import com.example.demo.model.Ingredient;
import com.example.demo.web.api.IngredientsApi;
import com.example.demo.web.api.resource.IngredientResource;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class IngredientResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler() {
        super(IngredientsApi.class, IngredientResource.class);
    }

    @Override
    public IngredientResource toModel(Ingredient ingredient) {
        return createModelWithId(ingredient.getId(), ingredient);
    }

    @Override
    protected IngredientResource instantiateModel(Ingredient ingredient) {
        return new IngredientResource(ingredient);
    }
}
