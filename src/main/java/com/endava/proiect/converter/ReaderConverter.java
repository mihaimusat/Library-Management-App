package com.endava.proiect.converter;

import com.endava.proiect.dto.ReaderDto;
import com.endava.proiect.model.Reader;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderConverter {

    public Reader fromDtoToReader(ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getName(),
                LocalDate.now()
        );
    }

    public ReaderDto fromReaderToDto(Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getRegistrationDate()
        );
    }

    public List<ReaderDto> fromReaderListToReaderDtoList(List<Reader> readerList) {
        return readerList.stream()
                .map(reader -> new ReaderDto(
                        reader.getId(),
                        reader.getName(),
                        reader.getRegistrationDate()
                ))
                .collect(Collectors.toList());
    }
}
