package pl.sauerann.springbootrecipeproject.controller;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sauerann.springbootrecipeproject.bootstrap.Bootstrap;
import pl.sauerann.springbootrecipeproject.domain.Recipe;
import pl.sauerann.springbootrecipeproject.repositories.CategoryRepository;
import pl.sauerann.springbootrecipeproject.repositories.UnitOfMeasureRepository;
import pl.sauerann.springbootrecipeproject.services.RecipeService;

import java.util.HashSet;

@Slf4j
@Controller
public class ApplicationController {

    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;
    private RecipeService recipeService;
    private Bootstrap bootstrap;

    public ApplicationController(UnitOfMeasureRepository unitOfMeasureRepository,
                                 CategoryRepository categoryRepository,
                                 RecipeService recipeService,
                                 Bootstrap bootstrap) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.recipeService = recipeService;
        this.bootstrap = bootstrap;
    }

    @RequestMapping({"/", "", "/index", "index", "*"})
    public String getIndexPage(Model model) {
        log.debug("Controller prepare index page");
        HashSet<Recipe> guacamole = Sets.newHashSet(recipeService.getRecipeByName("Guacamole"));
        model.addAttribute("recipes", guacamole);
        model.addAttribute("categories", categoryRepository.findAll());

        return "index";
    }
}
