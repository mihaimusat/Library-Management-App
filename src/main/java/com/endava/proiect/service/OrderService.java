package com.endava.proiect.service;

import com.endava.proiect.exception.BookRentedException;
import com.endava.proiect.exception.NotFoundException;
import com.endava.proiect.model.Book;
import com.endava.proiect.model.Order;
import com.endava.proiect.model.Reader;
import com.endava.proiect.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookService bookService;
    private final ReaderService readerService;

    @Autowired
    public OrderService(OrderRepository orderRepository, BookService bookService, ReaderService readerService) {
        this.orderRepository = orderRepository;
        this.bookService = bookService;
        this.readerService = readerService;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if(orderOptional.isPresent()) {
            return orderOptional.get();
        }
        else {
            throw new NotFoundException("Order not found", "order.not.found");
        }
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order rentBook(Long bookId, Long readerId, Order oldOrder) {
        Book book = bookService.getBook(bookId);
        Reader reader = readerService.getReader(readerId);

        if (book.getStatus().equals("available")) {
            Order newOrder = new Order(book, reader, oldOrder.getRentalDate(), oldOrder.getReturnDate());
            book.setStatus("ordered");
            bookService.saveBook(book);
            return orderRepository.save(newOrder);
        }
        else {
            throw new BookRentedException("Book already rented", "book.already.rented");
        }
    }

    public Order returnBook(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if(orderOptional.isPresent()) {
            Order order = orderOptional.get();
            Book book = order.getBook();
            book.setStatus("available");
            order.setReturnDate(LocalDate.now());
            bookService.saveBook(book);
            return orderRepository.save(order);
        }
        else {
            throw new NotFoundException("Order not found", "order.not.found");
        }
    }

    public List<Order> findOrdersOfReader(Long readerId) {
        Reader reader = readerService.getReader(readerId);
        return orderRepository.findAllByReader(reader);
    }
}
