package com.example.gururecipe.service;

import com.example.gururecipe.command.RecipeCommand;
import com.example.gururecipe.converters.RecipeCommandToRecipe;
import com.example.gururecipe.converters.RecipeToRecipeCommand;
import com.example.gururecipe.domain.Recipe;
import com.example.gururecipe.repositories.RecipeRepository;
import com.example.gururecipe.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RecipeServiceIT {

    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Transactional
    @Test
    public void testSaveOfDescription() throws Exception{
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe test = recipes.iterator().next();
        RecipeCommand convert = recipeToRecipeCommand.convert(test);

        //when
        convert.setDescription(NEW_DESCRIPTION);
        RecipeCommand toBeSaved = recipeService.saveRecipeCommand(convert);

        //then
        assertEquals(NEW_DESCRIPTION, toBeSaved.getDescription());
        assertEquals(test.getId(), convert.getId());
        assertEquals(test.getCategories().size(), toBeSaved.getCategories().size());
        assertEquals(test.getIngredients().size(), toBeSaved.getIngredients().size());

    }
}
