package com.example.demo.web.api;

import com.example.demo.dao.IngredientJPARepo;
import com.example.demo.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "ingredients", produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200")
public class IngredientsApi {

    @Autowired
    private IngredientJPARepo ingredientJPARepo;

    @GetMapping
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientJPARepo.findAll();
    }
}
