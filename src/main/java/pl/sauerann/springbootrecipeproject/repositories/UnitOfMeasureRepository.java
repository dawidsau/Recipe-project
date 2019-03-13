package pl.sauerann.springbootrecipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sauerann.springbootrecipeproject.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
