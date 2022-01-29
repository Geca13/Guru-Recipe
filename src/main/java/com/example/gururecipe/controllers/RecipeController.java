package com.example.gururecipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gururecipe.services.RecipeService;

@Controller
public class RecipeController {
	
	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}
	
	@RequestMapping("/recipe/show/{id}")
	public String showById(Model model, @PathVariable String id) {
		model.addAttribute("recipe", recipeService.findById(new Long(id)));
		return "recipe/show";
		
	}

}
