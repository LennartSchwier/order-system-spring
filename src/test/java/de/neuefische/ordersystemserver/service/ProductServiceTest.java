package de.neuefische.ordersystemserver.service;

import de.neuefische.ordersystemserver.db.ProductDb;
import de.neuefische.ordersystemserver.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    private final Product testProduct = new Product("testProduct1", "TestProduct");
    String id = "some-own-id";
    ProductDb productDbMock = mock(ProductDb.class);
    ProductService testService = new ProductService(productDbMock);

    @Test
    void testGetProductByIdShouldReturnCorrectProduct() {
        // GIVEN
        when(productDbMock.getProductById(id)).
                thenReturn(Optional.of(new Product(id,"testProduct")));

        // WHEN
        Optional<Product> actualProduct = testService.getProductById(id);

        // THEN
        assertThat(actualProduct, is(Optional.of(new Product("some-own-id", "testProduct"))));
    }

}