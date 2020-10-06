package de.neuefische.ordersystemserver.controller;

import de.neuefische.ordersystemserver.model.Order;
import de.neuefische.ordersystemserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> listOrders() {
        return orderService.listOrders();
    }

    @PutMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }
}
