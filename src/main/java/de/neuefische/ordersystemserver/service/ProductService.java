package de.neuefische.ordersystemserver.service;

import de.neuefische.ordersystemserver.db.ProductDb;
import de.neuefische.ordersystemserver.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDb productDb;

    @Autowired
    public ProductService(ProductDb productDb) {
        this.productDb = productDb;
    }

    public List<Product> listProducts() {
        return productDb.listProducts();
    }

    public Optional<Product> getProductById(String id) {
        return productDb.getProductById(id);
    }

    public Product addProduct(Product product) {
        return productDb.addProduct(product);
    }
}
