package de.neuefische.ordersystemserver.controller;

import de.neuefische.ordersystemserver.model.Product;
import de.neuefische.ordersystemserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable String id) {
        Optional<Product> searchedProduct = productService.getProductById(id);
        if (searchedProduct.isPresent()) {
            return searchedProduct.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path = "/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
