package pl.sauerann.springbootrecipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.sauerann.springbootrecipeproject.domain.Category;
import pl.sauerann.springbootrecipeproject.domain.Ingredient;
import pl.sauerann.springbootrecipeproject.domain.Recipe;
import pl.sauerann.springbootrecipeproject.domain.dto.RecipeDTO;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeDTOToRecipe implements Converter<RecipeDTO, Recipe> {

    private CategoryDTOToCategory categoryDTOToCategory;
    private NotesDTOToNotes notesDTOToNotes;
    private IngredientDTOToIngredient ingredientDTOToIngredient;

    public RecipeDTOToRecipe(CategoryDTOToCategory categoryDTOToCategory,
                             NotesDTOToNotes notesDTOToNotes,
                             IngredientDTOToIngredient ingredientDTOToIngredient) {
        this.categoryDTOToCategory = categoryDTOToCategory;
        this.notesDTOToNotes = notesDTOToNotes;
        this.ingredientDTOToIngredient = ingredientDTOToIngredient;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeDTO source) {
        if (source == null) {
            return null;
        }
        Set<Category> categories = new HashSet<>();
        source.getCategories().forEach(
                categoryDTO -> categories.add(categoryDTOToCategory.convert(categoryDTO))
        );
        Set<Ingredient> ingredients = new HashSet<>();
        source.getIngredients().forEach(
                ingredientDTO -> ingredients.add(ingredientDTOToIngredient.convert(ingredientDTO))
        );
        Recipe result = new Recipe();
        result.setId(source.getId());
        result.setDifficulty(source.getDifficulty());
        result.setDirections(source.getDirections());
        result.setUrl(source.getUrl());
        result.setSource(source.getSource());
        result.setServings(source.getServings());
        result.setCookTime(source.getCookTime());
        result.setPrepTime(source.getPrepTime());
        result.setDescription(source.getDescription());
        result.setIngredients(ingredients);
        result.setNotes(notesDTOToNotes.convert(source.getNotes()));
        result.setCategories(categories);
        return result;
    }
}
