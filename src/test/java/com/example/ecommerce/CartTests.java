package com.example.ecommerce;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CartTests {

    public static final Product PRODUCT_SHIRT = new Product(1, "Shirt", BigDecimal.valueOf(100));
    public static final Product PRODUCT_PANTS = new Product(2, "Pants", BigDecimal.valueOf(50));

    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    void testEmptyCart() {
        Assertions.assertEquals(0, cart.itemQty());
    }

    @Test
    void testAddAProductToCart() {
        cart.add(PRODUCT_SHIRT);

        Assertions.assertEquals(1, cart.itemQty());
    }

    @Test
    void testAddSameProductTwice() {
        cart.add(PRODUCT_SHIRT);
        cart.add(PRODUCT_SHIRT);

        Assertions.assertEquals(2, cart.itemQty());
        Assertions.assertEquals(2, cart.getLineItems().get(0).getQuantity());
    }

    @Test
    void testTotalForOneProduct() {
        cart.add(PRODUCT_SHIRT);

        Assertions.assertEquals(BigDecimal.valueOf(100), cart.totalPrice());
    }

    @Test
    void totalTotalAfterAddingSameProductTwice() {
        cart.add(PRODUCT_SHIRT);
        cart.add(PRODUCT_SHIRT);

        Assertions.assertEquals(BigDecimal.valueOf(200), cart.totalPrice());
    }

    @Test
    void testTotalForTwoProducts() {
        cart.add(PRODUCT_SHIRT);
        cart.add(PRODUCT_PANTS);

        Assertions.assertEquals(BigDecimal.valueOf(150), cart.totalPrice());
    }

    @Test
    void testTotalForTwoProductsWithSpecialPrice() {
        Product productA = new Product(1, "Shirt", BigDecimal.valueOf(0.1));
        Product productB = new Product(2, "Pants", BigDecimal.valueOf(0.2));

        cart.add(productA);
        cart.add(productB);

        Assertions.assertEquals(BigDecimal.valueOf(0.3), cart.totalPrice());
    }

    // depensive coding
    @Test
    void testAddNullProduct() {
        cart.add(null);

        Assertions.assertEquals(BigDecimal.valueOf(0), cart.totalPrice());
    }

    @Test
    void testAddXXX() {
        cart.add(PRODUCT_SHIRT);
        cart.add(PRODUCT_SHIRT);
        cart.add(PRODUCT_PANTS);

        Assertions.assertEquals(BigDecimal.valueOf(250), cart.totalPrice());
        Assertions.assertEquals(3, cart.itemQty());
    }
}
