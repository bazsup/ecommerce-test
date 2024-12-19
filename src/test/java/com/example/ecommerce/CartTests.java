package com.example.ecommerce;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTests {

    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    void testEmptyCart() {
        Assertions.assertEquals(0, cart.lineItemCount());
    }

    @Test
    void testAddAProductToCart() {
        Product product = new Product(1, "Shirt", 100.0);

        cart.add(product);

        Assertions.assertEquals(1, cart.lineItemCount());
    }

    @Test
    void testAddSameProductTwice() {
        Product product = new Product(1, "Shirt", 100.0);

        cart.add(product);
        cart.add(product);

        Assertions.assertEquals(1, cart.lineItemCount());
        Assertions.assertEquals(2, cart.getLineItems().get(0).getQuantity());
    }

    @Test
    void testTotalForOneProduct() {
        Product product = new Product(1, "Shirt", 100.0);

        cart.add(product);

        Assertions.assertEquals(100.0, cart.totalPrice());
    }

    @Test
    void totalTotalAfterAddingAProductTwice() {
        Product product = new Product(1, "Shirt", 100.0);

        cart.add(product);
        cart.add(product);

        Assertions.assertEquals(200.0, cart.totalPrice());
    }

    @Test
    void testTotalForTwoProducts() {
        Product shirt = new Product(1, "Shirt", 100.0);
        Product pants = new Product(2, "Pants", 50.0);

        cart.add(shirt);
        cart.add(pants);

        Assertions.assertEquals(150.0, cart.totalPrice());
    }

}
