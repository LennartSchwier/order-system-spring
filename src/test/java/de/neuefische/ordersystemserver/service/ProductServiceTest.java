package de.neuefische.ordersystemserver.service;

import de.neuefische.ordersystemserver.db.ProductDb;
import de.neuefische.ordersystemserver.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    private final ProductDb productDbMock = mock(ProductDb.class);
    private final ProductService testService = new ProductService(productDbMock);

    @Test
    void testlistProductsReturnsEntireProducts() {
        // WHEN
        when(productDbMock.listProducts()).
                thenReturn(List.of(
                        new Product("tomate", "Tomate"),
                        new Product("gurke", "Gurke"),
                        new Product("kartoffel", "Kartoffel")
                ));
        List<Product> actual = testService.listProducts();

        // THEN
        assertThat(actual, is(List.of(
                new Product("tomate", "Tomate"),
                new Product("gurke", "Gurke"),
                new Product("kartoffel", "Kartoffel")
        )));
    }

    @Test
    void testGetProductByIdShouldReturnCorrectProduct() {
        // GIVEN
        String id = "some-own-id";
        when(productDbMock.getProductById(id)).
                thenReturn(Optional.of(new Product(id,"testProduct")));

        // WHEN
        Optional<Product> actualProduct = testService.getProductById(id);

        // THEN
        assertThat(actualProduct, is(Optional.of(new Product("some-own-id", "testProduct"))));
    }

    @Test
    void testAddProductShouldReturnCorrectProduct() {
        // GIVEN
        Product testProduct = new Product("foo", "bah");
        when(productDbMock.addProduct(testProduct)).
                thenReturn(new Product("foo", "bah"));

        // WHEN
        Product actual = testService.addProduct(testProduct);

        // THEN
        assertThat(actual, is(new Product("foo", "bah")));
    }

}