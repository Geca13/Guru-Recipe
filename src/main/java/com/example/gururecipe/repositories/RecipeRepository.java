package com.example.gururecipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.gururecipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
