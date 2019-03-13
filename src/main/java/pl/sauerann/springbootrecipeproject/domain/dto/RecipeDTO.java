package pl.sauerann.springbootrecipeproject.domain.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sauerann.springbootrecipeproject.domain.Difficulty;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDTO {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Set<CategoryDTO> categories;
    private NotesDTO notes;
    private Set<IngredientDTO> ingredients;

}
