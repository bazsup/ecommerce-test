package com.example.ecommerce;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTests {

    public static final Product PRODUCT_SHIRT = new Product(1, "Shirt", 100.0);
    public static final Product PRODUCT_PANTS = new Product(2, "Pants", 50.0);

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
        cart.add(PRODUCT_SHIRT);

        Assertions.assertEquals(1, cart.lineItemCount());
    }

    @Test
    void testAddSameProductTwice() {
        cart.add(PRODUCT_SHIRT);
        cart.add(PRODUCT_SHIRT);

        Assertions.assertEquals(1, cart.lineItemCount());
        Assertions.assertEquals(2, cart.getLineItems().get(0).getQuantity());
    }

    @Test
    void testTotalForOneProduct() {
        cart.add(PRODUCT_SHIRT);

        Assertions.assertEquals(100.0, cart.totalPrice());
    }

    @Test
    void totalTotalAfterAddingSameProductTwice() {
        cart.add(PRODUCT_SHIRT);
        cart.add(PRODUCT_SHIRT);

        Assertions.assertEquals(200.0, cart.totalPrice());
    }

    @Test
    void testTotalForTwoProducts() {
        cart.add(PRODUCT_SHIRT);
        cart.add(PRODUCT_PANTS);

        Assertions.assertEquals(150.0, cart.totalPrice());
    }

}
