package pl.sauerann.springbootrecipeproject.controller;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.sauerann.springbootrecipeproject.bootstrap.Bootstrap;
import pl.sauerann.springbootrecipeproject.repositories.CategoryRepository;
import pl.sauerann.springbootrecipeproject.repositories.UnitOfMeasureRepository;
import pl.sauerann.springbootrecipeproject.services.RecipeService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ApplicationControllerTest {

    private ApplicationController controller;

    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private RecipeService recipeService;

    @Mock
    private Bootstrap bootstrap;

    @Mock
    private Model model;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new ApplicationController(
                unitOfMeasureRepository,
                categoryRepository,
                recipeService,
                bootstrap);
    }

    @Test
    public void getIndexPage() {
        String result = controller.getIndexPage(model);


        Mockito.verify(model, Mockito.times(1))
                .addAttribute(
                        Mockito.eq("recipes")
                        , Mockito.anySet());
        Mockito.verify(recipeService, Mockito.times(1)).getRecipeByName("Guacamole");
        Mockito.verify(categoryRepository, Mockito.times(1)).findAll();
        assertEquals("index", result);
    }

    @Test
    public void streamTesting() {
        List<String> list = Lists.newArrayList("Element 1", "Element 4", "Element ", "Element 2", "Element 3");
        list.stream()
                .flatMap(string -> Arrays.stream(string.split("")))
                .forEach(System.out::println);
    }

}