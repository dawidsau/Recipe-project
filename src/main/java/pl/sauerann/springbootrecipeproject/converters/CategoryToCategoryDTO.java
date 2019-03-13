package pl.sauerann.springbootrecipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.sauerann.springbootrecipeproject.domain.Category;
import pl.sauerann.springbootrecipeproject.domain.dto.CategoryDTO;


@Component
public class CategoryToCategoryDTO implements Converter<Category, CategoryDTO> {

    @Synchronized
    @Nullable
    @Override
    public CategoryDTO convert(Category source) {
        if (source == null) {
            return null;
        }
        CategoryDTO result = new CategoryDTO();
        result.setId(source.getId());
        result.setDescription(source.getDescription());
        return result;
    }
}
