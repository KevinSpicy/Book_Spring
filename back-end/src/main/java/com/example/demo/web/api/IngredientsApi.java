package com.example.demo.web.api;

import com.example.demo.dao.IngredientJPARepo;
import com.example.demo.model.Ingredient;
import com.example.demo.web.api.resource.IngredientResource;
import com.example.demo.web.api.resource.resourceassembler.IngredientResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "ingredients", produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200")
public class IngredientsApi {

    @Autowired
    private IngredientJPARepo ingredientJPARepo;

    @GetMapping
    public CollectionModel<IngredientResource> getAllIngredients() {
        Iterable<Ingredient> ingredients = ingredientJPARepo.findAll();
        CollectionModel<IngredientResource> ingredientResources = new IngredientResourceAssembler().toCollectionModel(ingredients);
        ingredientResources.add(ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(IngredientsApi.class)
                        .getAllIngredients())
                        .withRel("ingredientsRel")
        );

        return ingredientResources;
    }
}
