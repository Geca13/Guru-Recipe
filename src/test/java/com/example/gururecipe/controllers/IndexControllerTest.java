package com.example.gururecipe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import com.example.gururecipe.controllers.IndexController;
import com.example.gururecipe.domain.Recipe;
import com.example.gururecipe.services.RecipeService;
import com.example.gururecipe.services.RecipeServiceImpl;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class IndexControllerTest {
	
	IndexController indexController;

	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		indexController = new IndexController(recipeService);
	}
	
	@Test
	public void testMockMVC() throws Exception {
		MockMvc mock = MockMvcBuilders.standaloneSetup(indexController).build();
		mock.perform(get("/")).andExpect(status().isOk())
		.andExpect(view().name("index"));
	}
	
	@Test
	public void getIndexPage() throws Exception {
		
		//given
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		Recipe rec = new Recipe();
		rec.setId(1L);
		recipes.add(rec);
		//when
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		ArgumentCaptor<Set<Recipe>> argument = ArgumentCaptor.forClass(Set.class);
		String view = indexController.getIndexPage(model);
		assertEquals("index", view);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recepes"), argument.capture());
		Set<Recipe> inController = argument.getValue();
		assertEquals(2, inController.size());
	}
}
