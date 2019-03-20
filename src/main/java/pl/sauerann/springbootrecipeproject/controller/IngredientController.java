package pl.sauerann.springbootrecipeproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sauerann.springbootrecipeproject.domain.dto.IngredientDTO;
import pl.sauerann.springbootrecipeproject.services.RecipeService;

import java.util.Set;

@Slf4j
@Controller
public class IngredientController {

    private RecipeService recipeService;

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("recipe/{recipeId}/ingredients")
    public String getIngredientList(@PathVariable String recipeId, Model model) {
        Set<IngredientDTO> ingredientDTOSet = recipeService.getAllIngredientsDTO(new Long(recipeId));
        model.addAttribute("ingredients", ingredientDTOSet);
        return "recipes/ingredients/ingredient";
    }

}
