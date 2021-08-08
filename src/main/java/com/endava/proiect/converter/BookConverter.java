package com.endava.proiect.converter;

import com.endava.proiect.dto.BookDto;
import com.endava.proiect.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookConverter extends BaseConverter<BookDto, Book> {

    @Override
    public Book fromDtoToEntity(BookDto dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setAuthor(dto.getAuthor());
        book.setTitle(dto.getTitle());
        book.setStatus(dto.getStatus());

        return book;
    }

    @Override
    public BookDto fromEntityToDto(Book entity) {
        BookDto bookDto = new BookDto();
        bookDto.setId(entity.getId());
        bookDto.setAuthor(entity.getAuthor());
        bookDto.setTitle(entity.getTitle());
        bookDto.setStatus(entity.getStatus());

        return bookDto;
    }
}
