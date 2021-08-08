package com.endava.proiect.controller;

import com.endava.proiect.converter.OrderConverter;
import com.endava.proiect.dto.OrderDto;
import com.endava.proiect.model.Order;
import com.endava.proiect.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderConverter orderConverter;

    @Autowired
    public OrderController(OrderService orderService, OrderConverter orderConverter) {
        this.orderService = orderService;
        this.orderConverter = orderConverter;
    }

    @GetMapping(value = "")
    public List<OrderDto> getOrders() {
        List<Order> orderList = orderService.getAllOrders();
        return orderConverter.fromEntitiesToDtos(orderList);
    }

    @GetMapping(value = "{orderId}")
    public OrderDto getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return orderConverter.fromEntityToDto(order);
    }

    @GetMapping(value = "readerOrders")
    public List<OrderDto> getOrdersOfReader(@RequestParam Long readerId) {
        List<Order> orderList = orderService.findOrdersOfReader(readerId);
        return orderConverter.fromEntitiesToDtos(orderList);
    }

    @PostMapping(value = "")
    public OrderDto saveOrder(@RequestBody OrderDto orderDto) {
        Order order = orderConverter.fromDtoToEntity(orderDto);
        Order savedOrder = orderService.saveOrder(order);
        return orderConverter.fromEntityToDto(savedOrder);
    }

    @PostMapping(value = "/rental")
    public OrderDto rentBook(@RequestParam Long bookId, @RequestParam Long readerId, @RequestBody OrderDto orderDto) {
        Order order = orderConverter.fromDtoToEntity(orderDto);
        Order savedOrder = orderService.rentBook(bookId, readerId, order);
        return orderConverter.fromEntityToDto(savedOrder);
    }

    @PutMapping(value = "/return")
    public OrderDto returnBook(@RequestParam Long orderId) {
        Order order = orderService.returnBook(orderId);
        return orderConverter.fromEntityToDto(order);
    }
}
