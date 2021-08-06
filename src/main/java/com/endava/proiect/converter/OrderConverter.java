package com.endava.proiect.converter;

import com.endava.proiect.dto.OrderDto;
import com.endava.proiect.exception.NotFoundException;
import com.endava.proiect.model.Order;
import com.endava.proiect.repository.BookRepository;
import com.endava.proiect.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderConverter {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    @Autowired
    public OrderConverter(BookRepository bookRepository, ReaderRepository readerRepository) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }

    public Order fromDtoToOrder(OrderDto orderDto) {
        return new Order(
                bookRepository.findById(orderDto.getBookId())
                        .orElseThrow(() -> new NotFoundException("Book not found", "book.not.found")),
                readerRepository.findById(orderDto.getReaderId())
                        .orElseThrow(() -> new NotFoundException("Reader not found", "reader.not.found")),
                orderDto.getRentalDate(),
                orderDto.getReturnDate()
        );
    }

    public OrderDto fromOrderToDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getBook().getId(),
                order.getReader().getId(),
                order.getRentalDate(),
                order.getReturnDate()
        );
    }

    public List<OrderDto> fromOrderListToOrderDtoList(List<Order> orderList) {
        return orderList.stream()
                .map(order -> new OrderDto(
                        order.getId(),
                        order.getBook().getId(),
                        order.getReader().getId(),
                        order.getRentalDate(),
                        order.getReturnDate()
                ))
                .collect(Collectors.toList());
    }
}
