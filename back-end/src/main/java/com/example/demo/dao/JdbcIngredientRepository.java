package com.example.demo.dao;

import com.example.demo.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("SELECT id, name, type FROM Ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbcTemplate.query("SELECT id, name, type FROM Ingredient",
                this::mapRowToIngredient).stream().findFirst().orElse(null);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("INSERT INTO Ingredient(id, name, type) VALUES (?, ?, ?)",
                ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ingredient(
                resultSet.getString("id"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type"))
        );
    }
}
