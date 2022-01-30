package com.example.gururecipe.services;

import java.util.Optional;
import java.util.Set;

import com.example.gururecipe.command.RecipeCommand;
import com.example.gururecipe.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
	
	Recipe findById(Long id);

	RecipeCommand saveRecipeCommand(RecipeCommand command);
}
