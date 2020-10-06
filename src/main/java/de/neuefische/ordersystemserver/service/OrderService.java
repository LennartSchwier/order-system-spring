package de.neuefische.ordersystemserver.service;

import de.neuefische.ordersystemserver.db.OrderDb;
import de.neuefische.ordersystemserver.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderDb orderDb;

    @Autowired
    public OrderService(OrderDb orderDb) {
        this.orderDb = orderDb;
    }

    public List<Order> listOrders() {
        return orderDb.listOrders();
    }

    public Order addOrder(Order order) {
        return orderDb.addOrder(order);
    }
}
