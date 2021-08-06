package com.endava.proiect.service;

import com.endava.proiect.exception.NotFoundException;
import com.endava.proiect.model.Reader;
import com.endava.proiect.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader getReader(Long id) {
        Optional<Reader> readerOptional = readerRepository.findById(id);
        if(readerOptional.isPresent()) {
            return readerOptional.get();
        }
        else {
            throw new NotFoundException("Reader not found", "reader.not.found");
        }
    }

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }
}
