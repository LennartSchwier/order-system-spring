package de.neuefische.ordersystemserver.controller;

import de.neuefische.ordersystemserver.db.ProductDb;
import de.neuefische.ordersystemserver.model.Product;
import de.neuefische.ordersystemserver.service.ProductService;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    private final Product testProduct = new Product("testProduct1", "TestProduct");

    @Test
    void testAddProductShouldAddProductToProductDb() {
        // GIVEN
        ProductService productServiceMock = mock(ProductService.class);
        ProductController testController = new ProductController(productServiceMock);

        when(productServiceMock.addProduct(testProduct)).
                thenReturn(testProduct);

        // WHEN
        Product actualProduct = testController.addProduct(testProduct);

        // THEN
        assertThat(actualProduct, is(new Product("testProduct1", "TestProduct")));
    }

}