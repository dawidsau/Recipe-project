package pl.sauerann.springbootrecipeproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sauerann.springbootrecipeproject.domain.Recipe;
import pl.sauerann.springbootrecipeproject.domain.dto.RecipeDTO;
import pl.sauerann.springbootrecipeproject.repositories.RecipeRepository;

@Slf4j
@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe getRecipeByName(String description) {
        log.debug("Getting recipes by name");
        return recipeRepository.findByDescription(description).orElseThrow(RuntimeException::new);
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("No such id found"));
    }


}
