package com.endava.proiect.controller;

import com.endava.proiect.converter.BookConverter;
import com.endava.proiect.dto.BookDto;
import com.endava.proiect.model.Book;
import com.endava.proiect.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;
    private final BookConverter bookConverter;

    @Autowired
    public BookController(BookService bookService, BookConverter bookConverter) {
        this.bookService = bookService;
        this.bookConverter = bookConverter;
    }

    @GetMapping("")
    public List<BookDto> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return bookConverter.fromBookListToBookDtoList(bookList);
    }

    @GetMapping(value = "/{id}")
    public BookDto getBook(@PathVariable Long id) {
        Book book = bookService.getBook(id);
        return bookConverter.fromBookToDto(book);
    }

    @PostMapping(value = "")
    public BookDto saveBook(@RequestBody BookDto bookDto) {
        Book book = bookConverter.fromDtoToBook(bookDto);
        Book savedBook = bookService.saveBook(book);
        return bookConverter.fromBookToDto(savedBook);
    }

    @PutMapping(value = "/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestParam String status) {
        Book book = bookService.updateBook(id, status);
        return bookConverter.fromBookToDto(book);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}