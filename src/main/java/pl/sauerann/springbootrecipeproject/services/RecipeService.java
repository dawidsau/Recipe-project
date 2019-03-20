package pl.sauerann.springbootrecipeproject.services;

import pl.sauerann.springbootrecipeproject.domain.Recipe;
import pl.sauerann.springbootrecipeproject.domain.dto.IngredientDTO;
import pl.sauerann.springbootrecipeproject.domain.dto.RecipeDTO;

import java.util.Set;

public interface RecipeService{

    Recipe getRecipeByName(String description);

    Recipe getRecipeById(Long id);

    Recipe saveRecipe(RecipeDTO recipeDTO);

    RecipeDTO findRecipeDTOById(Long id);

    void deleteRecipeById(Long id);

    Set<Recipe> findAll();

    Set<IngredientDTO> getAllIngredientsDTO(Long id);
}

