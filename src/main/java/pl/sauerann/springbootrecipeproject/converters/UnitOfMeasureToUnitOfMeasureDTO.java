package pl.sauerann.springbootrecipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.sauerann.springbootrecipeproject.domain.UnitOfMeasure;
import pl.sauerann.springbootrecipeproject.domain.dto.UnitOfMeasureDTO;

@Component
public class UnitOfMeasureToUnitOfMeasureDTO implements Converter<UnitOfMeasure, UnitOfMeasureDTO> {


    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureDTO convert(UnitOfMeasure source) {
        if (source == null) {
            return null;
        }
        UnitOfMeasureDTO result = new UnitOfMeasureDTO();
        result.setId(source.getId());
        result.setDescription(source.getDescription());
        return result;
    }
}
