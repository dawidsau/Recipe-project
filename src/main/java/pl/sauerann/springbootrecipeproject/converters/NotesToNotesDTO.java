package pl.sauerann.springbootrecipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.sauerann.springbootrecipeproject.domain.Notes;
import pl.sauerann.springbootrecipeproject.domain.dto.NotesDTO;

@Component
public class NotesToNotesDTO implements Converter<Notes, NotesDTO> {

    @Synchronized
    @Nullable
    @Override
    public NotesDTO convert(Notes source) {
        if (source == null){
            return null;
        }
        NotesDTO result = new NotesDTO();
        result.setId(source.getId());
        result.setRecipeNotes(source.getRecipeNotes());
        return result;
    }
}
