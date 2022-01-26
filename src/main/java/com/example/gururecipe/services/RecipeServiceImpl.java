package com.example.gururecipe.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.gururecipe.domain.Recipe;
import com.example.gururecipe.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recepeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recepeSet:: add);
		
		return recepeSet;
	}
	
	
}
