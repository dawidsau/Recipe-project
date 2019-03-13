package pl.sauerann.springbootrecipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.sauerann.springbootrecipeproject.domain.UnitOfMeasure;
import pl.sauerann.springbootrecipeproject.domain.dto.UnitOfMeasureDTO;

@Component
public class UnitOfMeasureDTOToUnitOfMeasure implements Converter<UnitOfMeasureDTO, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureDTO source) {
        if (source == null) {
            return null;
        }
        UnitOfMeasure result = new UnitOfMeasure();
        result.setId(source.getId());
        result.setDescription(source.getDescription());
        return result;
    }
}
