package com.example.springinaction.takoapp.web;

import com.example.springinaction.takoapp.Ingredient;
import com.example.springinaction.takoapp.Ingredient.*;
import com.example.springinaction.takoapp.data.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientsByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepo;

    public IngredientsByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }
}
