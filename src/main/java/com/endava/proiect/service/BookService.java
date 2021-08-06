package com.endava.proiect.service;

import com.endava.proiect.exception.NotFoundException;
import com.endava.proiect.model.Book;
import com.endava.proiect.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()) {
            return bookOptional.get();
        }
        else {
            throw new NotFoundException("Book not found", "book.not.found");
        }
    }

    public Book saveBook(Book book) {
       return bookRepository.save(book);
    }

    public Book updateBook(Long id, String status) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setId(id);
            book.setStatus(status);
            return bookRepository.save(book);
        }
        else {
            throw new NotFoundException("Book not found", "book.not.found");
        }
    }

    public void deleteBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()) {
            bookRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("Book not found", "book.not.found");
        }
    }

}