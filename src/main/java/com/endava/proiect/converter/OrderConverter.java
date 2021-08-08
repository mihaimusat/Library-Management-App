package com.endava.proiect.converter;

import com.endava.proiect.dto.OrderDto;
import com.endava.proiect.exception.NotFoundException;
import com.endava.proiect.model.Order;
import com.endava.proiect.repository.BookRepository;
import com.endava.proiect.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter extends BaseConverter<OrderDto, Order> {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    @Autowired
    public OrderConverter(BookRepository bookRepository, ReaderRepository readerRepository) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }

    @Override
    public Order fromDtoToEntity(OrderDto dto) {
        Order order = new Order();
        order.setBook(bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new NotFoundException("Book not found", "book.not.found")));
        order.setReader(readerRepository.findById(dto.getReaderId())
                .orElseThrow(() -> new NotFoundException("Reader not found", "reader.not.found")));
        order.setRentalDate(dto.getRentalDate());
        order.setReturnDate(dto.getReturnDate());

        return order;
    }

    @Override
    public OrderDto fromEntityToDto(Order entity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(entity.getId());
        orderDto.setBookId(entity.getBook().getId());
        orderDto.setReaderId(entity.getReader().getId());
        orderDto.setRentalDate(entity.getRentalDate());
        orderDto.setReturnDate(entity.getReturnDate());

        return orderDto;
    }
}
