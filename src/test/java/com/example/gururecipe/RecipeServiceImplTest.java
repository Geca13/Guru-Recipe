package com.example.gururecipe;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.*;

import com.example.gururecipe.domain.Recipe;
import com.example.gururecipe.repositories.RecipeRepository;
import com.example.gururecipe.services.RecipeServiceImpl;

public class RecipeServiceImplTest {
	
	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository);
	}
	
	@Test
	public void getRecipes() throws Exception{
		Recipe recipe = new Recipe();
		HashSet data = new HashSet<>();
		data.add(recipe);
		
		when(recipeRepository.findAll()).thenReturn(data);
		Set<Recipe> recipes = recipeService.getRecipes();
		
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}
	
	@Test
	public void getRecipeByIsTest() {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> optional = Optional.of(recipe);
		
		
		when(recipeRepository.findById(anyLong())).thenReturn(optional);
		Recipe returned = recipeService.findById(1L);
		assertNotNull("Null recipe returned", returned);
		verify(recipeRepository,times(1)).findById(anyLong());
		
	}

}
