package com.endava.proiect.converter;

import com.endava.proiect.dto.BookDto;
import com.endava.proiect.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookConverter {

    public Book fromDtoToBook(BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getAuthor(),
                bookDto.getTitle(),
                bookDto.getStatus()
        );
    }

    public BookDto fromBookToDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getAuthor(),
                book.getTitle(),
                book.getStatus()
        );
    }

    public List<BookDto> fromBookListToBookDtoList(List<Book> bookList) {
        return bookList.stream()
                .map(book -> new BookDto(
                        book.getId(),
                        book.getAuthor(),
                        book.getTitle(),
                        book.getStatus()
                ))
                .collect(Collectors.toList());
    }
}
