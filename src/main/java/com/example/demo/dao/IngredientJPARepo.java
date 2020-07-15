package com.example.demo.dao;

import com.example.demo.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IngredientJPARepo extends CrudRepository<Ingredient, String> {

}
