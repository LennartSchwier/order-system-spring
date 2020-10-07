package de.neuefische.ordersystemserver.db;

import de.neuefische.ordersystemserver.model.Order;
import de.neuefische.ordersystemserver.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class OrderDbTest {

    private final OrderDb orderDb = new OrderDb();
    private final Order firstOrder = new Order(List.of(
            new Product("foo", "Foo"),
            new Product("baa", "Baa")
    ));

    @Test
    void testAddOrderReturnsCorrectOrder() {
        // WHEN
        Order actual = orderDb.addOrder(firstOrder);

        // THEN
        assertThat(actual.getOrderedProducts(), is(new Order(List.of(
                new Product("foo", "Foo"),
                new Product("baa", "Baa")))
                    .getOrderedProducts()));
    }

    @Test
    void testListOrdersReturnsEntireOrders() {
        // GIVEN
        orderDb.addOrder(firstOrder);

        // WHEN
        List<Order> actual = orderDb.listOrders();

        // THEN
        assert(actual.contains(firstOrder));
    }
}