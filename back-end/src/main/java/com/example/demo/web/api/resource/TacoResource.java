package com.example.demo.web.api.resource;

import com.example.demo.model.Ingredient;
import com.example.demo.model.Taco;
import com.example.demo.web.api.resource.resourceassembler.IngredientResourceAssembler;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Relation(value="taco", collectionRelation = "tacos")
public class TacoResource extends RepresentationModel<TacoResource> {

    private static final IngredientResourceAssembler
            ingredientAssembler = new IngredientResourceAssembler();

    private String name;
    private Date createdAt;
    private List<IngredientResource> ingredients;

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = new ArrayList<>(ingredientAssembler.toCollectionModel(taco.getIngredients()).getContent());
    }

    public TacoResource() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<IngredientResource> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientResource> ingredients) {
        this.ingredients = ingredients;
    }
}
