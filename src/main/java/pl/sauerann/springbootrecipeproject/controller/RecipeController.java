package pl.sauerann.springbootrecipeproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sauerann.springbootrecipeproject.domain.Recipe;
import pl.sauerann.springbootrecipeproject.domain.dto.RecipeDTO;
import pl.sauerann.springbootrecipeproject.services.RecipeService;

@Controller
@RequestMapping({"/recipe"})
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/show/{id}")
    public String getRecipeById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(new Long(id)));
        return "recipes/recipe";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getRecipeForm(@ModelAttribute RecipeDTO recipeDTO) {
        Recipe recipeSaved = recipeService.saveRecipe(recipeDTO);
        return "redirect:/recipe/show/" + recipeSaved.getId();
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getEmptyRecipeForm(Model model) {
        model.addAttribute("recipe", new RecipeDTO());

        return "/recipes/recipeform";
    }

    @RequestMapping("/update/{id}")
    public String getUpdateRecipeForm(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findRecipeDTOById(new Long(id)));

        return "/recipes/recipeform";
    }

    @RequestMapping("/delete/{id}")
    public String deleteRecipeById(@PathVariable String id){
        recipeService.deleteRecipeById(new Long(id));
        return "/index";
    }
}
