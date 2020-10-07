package de.neuefische.ordersystemserver.db;

import de.neuefische.ordersystemserver.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class ProductDbTest {

    private final ProductDb testDb = new ProductDb();

    @Test
    void testlistProductsListsEntireDb() {
        // WHEN
        List<Product> actual = testDb.listProducts();

        // THEN
        assertThat(actual, is(List.of(
                new Product("tomate", "Tomate"),
                new Product("gurke", "Gurke"),
                new Product("kartoffel", "Kartoffel")
        )));
    }

    @Test
    void testGetProductByIdReturnsCorrectProduct() {
        // GIVEN
        String id = "tomate";

        // WHEN
        Optional<Product> actual = testDb.getProductById(id);

        // THEN
        assertThat(actual, is(Optional.of(new Product("tomate", "Tomate"))));
    }

    @Test
    void testAddProductShouldAddProductToDb() {
        // GIVEN
        Product testProduct = new Product("schuh", "Schuh");

        // WHEN
        testDb.addProduct(testProduct);

        // THEN
        assertThat(testDb.listProducts(), is(List.of(
                new Product("tomate", "Tomate"),
                new Product("gurke", "Gurke"),
                new Product("kartoffel", "Kartoffel"),
                new Product("schuh", "Schuh")
        )));
    }

}