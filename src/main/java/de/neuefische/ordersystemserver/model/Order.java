package de.neuefische.ordersystemserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Order {

    private String id;
    private List<Product> orderedProducts = new ArrayList<>();

    public Order(List<Product> products) {
        orderedProducts = products;
        UUID uuid = UUID.randomUUID();
        id = String.valueOf(uuid);
    }

}
