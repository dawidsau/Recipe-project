package pl.sauerann.springbootrecipeproject.bootstrap;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.sauerann.springbootrecipeproject.domain.Difficulty;
import pl.sauerann.springbootrecipeproject.domain.Ingredient;
import pl.sauerann.springbootrecipeproject.domain.Recipe;
import pl.sauerann.springbootrecipeproject.repositories.CategoryRepository;
import pl.sauerann.springbootrecipeproject.repositories.RecipeRepository;
import pl.sauerann.springbootrecipeproject.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;

@Slf4j
@Repository
public class Bootstrap {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;


    public Bootstrap(CategoryRepository categoryRepository,
                     RecipeRepository recipeRepository,
                     UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        loadRecipes();
    }

    public void loadRecipes() {
        log.debug("Loading recipes");
        Recipe guacamole = new Recipe();
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setAmount(BigDecimal.valueOf(1.5));
        ingredient1.setDescription("salt");
        ingredient1.setUnitOfMeasure(unitOfMeasureRepository
                        .findByDescription("Teaspoon")
                        .orElseThrow(RuntimeException::new));
        ingredient1.setRecipe(guacamole);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setAmount(BigDecimal.ONE);
        ingredient2.setDescription("Lemon juice");
        ingredient2.setUnitOfMeasure(unitOfMeasureRepository
                .findByDescription("Tablespoon")
                .orElseThrow(RuntimeException::new));
        ingredient2.setRecipe(guacamole);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setAmount(BigDecimal.valueOf(1.5));
        ingredient3.setDescription("Black pepper");
        ingredient3.setUnitOfMeasure(unitOfMeasureRepository
                .findByDescription("Dash")
                .orElseThrow(RuntimeException::new));
        ingredient3.setRecipe(guacamole);

        guacamole.setDescription("Guacamole");
        guacamole.setCookTime(100);
        guacamole.setPrepTime(130);
        guacamole.setServings(15);
        guacamole.setSource("SimpleRecipes.com");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setDirections("perfect_guacamole");
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setCategories(Sets.newHashSet(
                categoryRepository.findByDescription("American").orElseThrow(RuntimeException::new),
                categoryRepository.findByDescription("Mexican").orElseThrow(RuntimeException::new)
        ));
        guacamole.setIngredients(Sets.newHashSet(
                ingredient1,
                ingredient2,
                ingredient3
        ));
        recipeRepository.save(guacamole);
        log.debug("Load complete");
    }

}