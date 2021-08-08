package com.endava.proiect.converter;

import com.endava.proiect.dto.ReaderDto;
import com.endava.proiect.model.Reader;
import org.springframework.stereotype.Service;

@Service
public class ReaderConverter extends BaseConverter<ReaderDto, Reader> {

    @Override
    public Reader fromDtoToEntity(ReaderDto dto) {
        Reader reader = new Reader();
        reader.setId(dto.getId());
        reader.setName(dto.getName());
        reader.setRegistrationDate(dto.getRegistrationDate());

        return reader;
    }

    @Override
    public ReaderDto fromEntityToDto(Reader entity) {
        ReaderDto readerDto = new ReaderDto();
        readerDto.setId(entity.getId());
        readerDto.setName(entity.getName());
        readerDto.setRegistrationDate(entity.getRegistrationDate());

        return readerDto;
    }
}
