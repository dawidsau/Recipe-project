package pl.sauerann.springbootrecipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sauerann.springbootrecipeproject.domain.Recipe;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByDescription (String description);
}
