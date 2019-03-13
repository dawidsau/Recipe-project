package pl.sauerann.springbootrecipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.sauerann.springbootrecipeproject.domain.Ingredient;
import pl.sauerann.springbootrecipeproject.domain.dto.IngredientDTO;

@Component
public class IngredientToIngredientDTO implements Converter<Ingredient, IngredientDTO> {

    private UnitOfMeasureToUnitOfMeasureDTO unitOfMeasureToUnitOfMeasureDTO;

    public IngredientToIngredientDTO(UnitOfMeasureToUnitOfMeasureDTO unitOfMeasureToUnitOfMeasureDTO) {
        this.unitOfMeasureToUnitOfMeasureDTO = unitOfMeasureToUnitOfMeasureDTO;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientDTO convert(Ingredient source) {
        if (source == null){
        return null;
        }
        IngredientDTO result = new IngredientDTO();
        result.setId(source.getId());
        result.setAmount(source.getAmount());
        result.setDescription(source.getDescription());
        result.setUnitOfMeasure(unitOfMeasureToUnitOfMeasureDTO.convert(source.getUnitOfMeasure()));
        return result;
    }
}
