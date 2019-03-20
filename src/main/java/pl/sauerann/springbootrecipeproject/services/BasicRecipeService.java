package pl.sauerann.springbootrecipeproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sauerann.springbootrecipeproject.converters.IngredientToIngredientDTO;
import pl.sauerann.springbootrecipeproject.converters.RecipeDTOToRecipe;
import pl.sauerann.springbootrecipeproject.converters.RecipeToRecipeDTO;
import pl.sauerann.springbootrecipeproject.domain.Ingredient;
import pl.sauerann.springbootrecipeproject.domain.Recipe;
import pl.sauerann.springbootrecipeproject.domain.dto.IngredientDTO;
import pl.sauerann.springbootrecipeproject.domain.dto.RecipeDTO;
import pl.sauerann.springbootrecipeproject.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class BasicRecipeService implements RecipeService {

    private RecipeToRecipeDTO recipeToRecipeDTO;
    private RecipeDTOToRecipe recipeDTOToRecipe;
    private RecipeRepository recipeRepository;
    private IngredientToIngredientDTO ingredientToIngredientDTO;

    public BasicRecipeService(RecipeToRecipeDTO recipeToRecipeDTO,
                              RecipeDTOToRecipe recipeDTOToRecipe,
                              RecipeRepository recipeRepository,
                              IngredientToIngredientDTO ingredientToIngredientDTO) {
        this.recipeToRecipeDTO = recipeToRecipeDTO;
        this.recipeDTOToRecipe = recipeDTOToRecipe;
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientDTO = ingredientToIngredientDTO;
    }

    @Override
    public Recipe getRecipeByName(String description) {
        log.debug("Getting recipes by name");
        return recipeRepository.findByDescription(description).orElseThrow(RuntimeException::new);
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("No such id found"));
    }

    @Override
    @Transactional
    public Recipe saveRecipe(RecipeDTO recipeDTO) {
        return recipeRepository.save(recipeDTOToRecipe.convert(recipeDTO));
    }

    @Override
    @Transactional
    public RecipeDTO findRecipeDTOById(Long id) {
        return recipeToRecipeDTO.convert(getRecipeById(id));
    }

    @Override
    @Transactional
    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Set<Recipe> findAll() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    @Transactional
    public Set<IngredientDTO> getAllIngredientsDTO(Long id) {
        Set<IngredientDTO> ingredientDTOSet = new HashSet<>();
        Set<Ingredient> ingredients = getRecipeById(id).getIngredients();
        ingredients.forEach(
                        ingredient ->  ingredientDTOSet.add(
                                ingredientToIngredientDTO.convert(ingredient)
                        ));
        return  ingredientDTOSet;
    }


}
