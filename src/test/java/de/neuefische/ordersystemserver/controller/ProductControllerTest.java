package de.neuefische.ordersystemserver.controller;

import de.neuefische.ordersystemserver.model.Product;
import de.neuefische.ordersystemserver.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    private final Product testProduct = new Product("testProduct1", "TestProduct");
    private final ProductService productServiceMock = mock(ProductService.class);
    private final ProductController testController = new ProductController(productServiceMock);

    @Test
    void testListProductsReturnsEntireProducts() {
        // GIVEN
        when(productServiceMock.listProducts()).thenReturn(List.of(
                        new Product("tomate", "Tomate"),
                        new Product("gurke", "Gurke"),
                        new Product("kartoffel", "Kartoffel")
        ));

        // WHEN
        List<Product> actual = testController.listProducts();

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
        String id = "some-id";
        when(productServiceMock.getProductById(id)).
                thenReturn(Optional.of(new Product(id, "foo")));

        // WHEN
        Optional<Product> actual = Optional.of(testController.getProductById(id));

        // THEN
        assertThat(actual, is(Optional.of(new Product("some-id", "foo"))));
    }

    @Test
    void testAddProductShouldAddProductToProductDb() {
        // GIVEN
        when(productServiceMock.addProduct(testProduct)).
                thenReturn(testProduct);

        // WHEN
        Product actualProduct = testController.addProduct(testProduct);

        // THEN
        assertThat(actualProduct, is(new Product("testProduct1", "TestProduct")));
    }

}