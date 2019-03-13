package pl.sauerann.springbootrecipeproject.converters;


import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.sauerann.springbootrecipeproject.domain.Category;
import pl.sauerann.springbootrecipeproject.domain.dto.CategoryDTO;


@Component
public class CategoryDTOToCategory implements Converter<CategoryDTO, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryDTO source) {
        if (source == null){
            return null;
        }
        Category result = new Category();
        result.setId(source.getId());
        result.setDescription(source.getDescription());
        return result;
    }
}
