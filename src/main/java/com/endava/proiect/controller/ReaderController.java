package com.endava.proiect.controller;

import com.endava.proiect.converter.ReaderConverter;
import com.endava.proiect.dto.ReaderDto;
import com.endava.proiect.model.Reader;
import com.endava.proiect.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reader")
public class ReaderController {

    private final ReaderService readerService;
    private final ReaderConverter readerConverter;

    @Autowired
    public ReaderController(ReaderService readerService, ReaderConverter readerConverter) {
        this.readerService = readerService;
        this.readerConverter = readerConverter;
    }

    @GetMapping(value = "")
    public List<ReaderDto> getReaders() {
        List<Reader> readerList = readerService.getAllReaders();
        return readerConverter.fromEntitiesToDtos(readerList);
    }

    @GetMapping(value = "/{id}")
    public ReaderDto getReader(@PathVariable Long id) {
        Reader reader = readerService.getReader(id);
        return readerConverter.fromEntityToDto(reader);
    }

    @PostMapping(value = "")
    public ReaderDto saveReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerConverter.fromDtoToEntity(readerDto);
        Reader savedReader = readerService.saveReader(reader);
        return readerConverter.fromEntityToDto(savedReader);
    }
}
