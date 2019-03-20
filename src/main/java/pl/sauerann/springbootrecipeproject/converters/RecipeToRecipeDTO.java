package pl.sauerann.springbootrecipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.sauerann.springbootrecipeproject.domain.Recipe;
import pl.sauerann.springbootrecipeproject.domain.dto.CategoryDTO;
import pl.sauerann.springbootrecipeproject.domain.dto.IngredientDTO;
import pl.sauerann.springbootrecipeproject.domain.dto.RecipeDTO;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeToRecipeDTO implements Converter<Recipe, RecipeDTO> {

    private CategoryToCategoryDTO categoryToCategoryDTO;
    private NotesToNotesDTO notesToNotesDTO;
    private IngredientToIngredientDTO ingredientToIngredientDTO;

    public RecipeToRecipeDTO(CategoryToCategoryDTO categoryToCategoryDTO,
                             NotesToNotesDTO notesToNotesDTO,
                             IngredientToIngredientDTO ingredientToIngredientDTO) {
        this.categoryToCategoryDTO = categoryToCategoryDTO;
        this.notesToNotesDTO = notesToNotesDTO;
        this.ingredientToIngredientDTO = ingredientToIngredientDTO;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeDTO convert(Recipe source) {
        if (source == null) {
            return null;
        }
        Set<CategoryDTO> categoryDTOSet = new HashSet<>();
        if (source.getCategories() != null) {
            source.getCategories().forEach(
                    category -> categoryDTOSet.add(categoryToCategoryDTO.convert(category))
            );
        }
        Set<IngredientDTO> ingredientDTOSet = new HashSet<>();
        if (source.getIngredients() != null) {
            source.getIngredients().forEach(
                    ingredient -> ingredientDTOSet.add(ingredientToIngredientDTO.convert(ingredient))
            );
        }
        RecipeDTO result = new RecipeDTO();
        result.setId(source.getId());
        result.setCategories(categoryDTOSet);
        result.setCookTime(source.getCookTime());
        result.setDescription(source.getDescription());
        result.setDifficulty(source.getDifficulty());
        result.setDirections(source.getDirections());
        result.setPrepTime(source.getPrepTime());
        result.setUrl(source.getUrl());
        result.setServings(source.getServings());
        result.setSource(source.getSource());
        result.setIngredients(ingredientDTOSet);
        result.setNotes(notesToNotesDTO.convert(source.getNotes()));
        return result;
    }
}
