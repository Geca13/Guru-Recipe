package com.example.gururecipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gururecipe.repositories.CategoryRepository;
import com.example.gururecipe.services.RecipeService;

@Controller
public class IndexController {
	
	private final RecipeService recipeService;
	

	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}


	@GetMapping({"","/","index","index.html"})
	public String getIndexPage(Model model) {
		model.addAttribute("recepes", recipeService.getRecipes());
		return "index";
	}
}
