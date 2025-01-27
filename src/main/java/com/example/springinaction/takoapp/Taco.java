package com.example.springinaction.takoapp;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class Taco {

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min=1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredientList;
}
