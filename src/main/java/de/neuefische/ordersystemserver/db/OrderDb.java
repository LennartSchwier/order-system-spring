package de.neuefische.ordersystemserver.db;

import de.neuefische.ordersystemserver.model.Order;
import de.neuefische.ordersystemserver.service.OrderService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDb {

    private List<Order> orders = new ArrayList<>();


    public List<Order> listOrders() {
        return orders;
    }

    public Order addOrder(Order order) {
        orders.add(order);
        return order;
    }
}
