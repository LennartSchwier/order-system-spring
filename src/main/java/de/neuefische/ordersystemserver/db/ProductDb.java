package de.neuefische.ordersystemserver.db;

import de.neuefische.ordersystemserver.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDb {

    private final List<Product> products = new ArrayList<>();

    @Autowired
    public ProductDb() {
        Product product1 = new Product("tomate", "Tomate");
        Product product2 = new Product("gurke", "Gurke");
        Product product3 = new Product("kartoffel", "Kartoffel");
        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    public List<Product> listProducts() {
        return products;
    }

    public Optional<Product> getProductById(String id) {
        Optional<Product> searchedProduct = Optional.of(new Product());
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return searchedProduct = Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }
}

