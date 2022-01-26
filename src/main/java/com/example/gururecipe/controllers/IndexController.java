package com.example.gururecipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.gururecipe.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	private final RecipeService recipeService;
	

	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}


	@GetMapping({"","/","index","index.html"})
	public String getIndexPage(Model model) {
		log.debug("Loading index page");
		model.addAttribute("recepes", recipeService.getRecipes());
		return "index";
	}
}
