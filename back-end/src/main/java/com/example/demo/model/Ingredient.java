package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    public static enum Type {
        WRAP, SAUCE, PROTEIN, VEGGIES, CHEESE
    }

    public Ingredient() {
    }

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
