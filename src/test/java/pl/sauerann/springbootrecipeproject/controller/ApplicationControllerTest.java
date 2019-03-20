package pl.sauerann.springbootrecipeproject.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.sauerann.springbootrecipeproject.bootstrap.Bootstrap;
import pl.sauerann.springbootrecipeproject.repositories.CategoryRepository;
import pl.sauerann.springbootrecipeproject.repositories.UnitOfMeasureRepository;
import pl.sauerann.springbootrecipeproject.services.BasicRecipeService;

import static org.junit.Assert.assertEquals;

public class ApplicationControllerTest {

    private ApplicationController controller;

    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private BasicRecipeService basicRecipeService;

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
                basicRecipeService,
                bootstrap);
    }

    @Test
    public void getIndexPage() {
        String result = controller.getIndexPage(model);


        Mockito.verify(model, Mockito.times(1))
                .addAttribute(
                        Mockito.eq("recipes")
                        , Mockito.anySet());
        Mockito.verify(basicRecipeService, Mockito.times(1)).getRecipeByName("Guacamole");
        Mockito.verify(categoryRepository, Mockito.times(1)).findAll();
        assertEquals("index", result);
    }
}