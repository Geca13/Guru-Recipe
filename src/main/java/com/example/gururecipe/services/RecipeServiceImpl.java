package com.example.gururecipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.example.gururecipe.command.RecipeCommand;
import com.example.gururecipe.converters.RecipeCommandToRecipe;
import com.example.gururecipe.converters.RecipeToRecipeCommand;
import org.springframework.stereotype.Service;

import com.example.gururecipe.domain.Recipe;
import com.example.gururecipe.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;

	public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}




    @Override
	public Set<Recipe> getRecipes() {
		log.debug("I'm in the service");
		Set<Recipe> recepeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recepeSet:: add);
		
		return recepeSet;
	}

	

	@Override
	public Recipe findById(Long id) {
		
		Optional<Recipe> optional = recipeRepository.findById(id);
		if (!optional.isPresent()) {
			throw new RuntimeException("Recipe Not Found!");
		}
		return optional.get();
	}
	@Transactional
	@Override
	public RecipeCommand saveRecipeCommand(RecipeCommand command) {
		Recipe recipe = recipeCommandToRecipe.convert(command);

		Recipe toBeSaved = recipeRepository.save(recipe);
		return recipeToRecipeCommand.convert(toBeSaved);
	}


}
