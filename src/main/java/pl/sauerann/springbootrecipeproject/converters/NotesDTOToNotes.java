package pl.sauerann.springbootrecipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.sauerann.springbootrecipeproject.domain.Notes;
import pl.sauerann.springbootrecipeproject.domain.dto.NotesDTO;

@Component
public class NotesDTOToNotes implements Converter<NotesDTO, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesDTO source) {
        if (source == null) {
            return null;
        }
        Notes result = new Notes();
        result.setId(source.getId());
        result.setRecipeNotes(source.getRecipeNotes());
        return result;
    }

}
