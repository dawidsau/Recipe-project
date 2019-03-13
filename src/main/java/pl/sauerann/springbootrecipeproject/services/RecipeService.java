package pl.sauerann.springbootrecipeproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sauerann.springbootrecipeproject.converters.RecipeDTOToRecipe;
import pl.sauerann.springbootrecipeproject.converters.RecipeToRecipeDTO;
import pl.sauerann.springbootrecipeproject.domain.Recipe;
import pl.sauerann.springbootrecipeproject.domain.dto.RecipeDTO;
import pl.sauerann.springbootrecipeproject.repositories.RecipeRepository;

@Slf4j
@Service
public class RecipeService {

    private RecipeToRecipeDTO recipeToRecipeDTO;
    private RecipeDTOToRecipe recipeDTOToRecipe;
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeToRecipeDTO recipeToRecipeDTO,
                         RecipeDTOToRecipe recipeDTOToRecipe,
                         RecipeRepository recipeRepository) {
        this.recipeToRecipeDTO = recipeToRecipeDTO;
        this.recipeDTOToRecipe = recipeDTOToRecipe;
        this.recipeRepository = recipeRepository;
    }

    public Recipe getRecipeByName(String description) {
        log.debug("Getting recipes by name");
        return recipeRepository.findByDescription(description).orElseThrow(RuntimeException::new);
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("No such id found"));
    }

    public Recipe saveRecipe(RecipeDTO recipeDTO) {
        return recipeRepository.save(recipeDTOToRecipe.convert(recipeDTO));
    }


}
