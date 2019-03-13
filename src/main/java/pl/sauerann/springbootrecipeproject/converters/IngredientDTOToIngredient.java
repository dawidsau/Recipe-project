package pl.sauerann.springbootrecipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.sauerann.springbootrecipeproject.domain.Ingredient;
import pl.sauerann.springbootrecipeproject.domain.dto.IngredientDTO;


@Component
public class IngredientDTOToIngredient implements Converter<IngredientDTO, Ingredient> {

    private UnitOfMeasureDTOToUnitOfMeasure unitOfMeasureDTOToUnitOfMeasure;

    public IngredientDTOToIngredient(UnitOfMeasureDTOToUnitOfMeasure unitOfMeasureDTOToUnitOfMeasure) {
        this.unitOfMeasureDTOToUnitOfMeasure = unitOfMeasureDTOToUnitOfMeasure;
    }

    @Nullable
    @Synchronized
    @Override
    public Ingredient convert(IngredientDTO source) {
        if (source == null) {
            return null;
        }
        Ingredient result = new Ingredient();
        result.setId(source.getId());
        result.setAmount(source.getAmount());
        result.setDescription(source.getDescription());
        result.setUnitOfMeasure(unitOfMeasureDTOToUnitOfMeasure.convert(source.getUnitOfMeasure()));
        return result;
    }
}
