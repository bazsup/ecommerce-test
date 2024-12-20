package com.example.ecommerce;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Map<Integer, LineItem> lineItems = new HashMap<>();
    private BigDecimal total = new BigDecimal(0);
    private Integer itemQuantity = 0;

    public Integer itemQty() {
        return itemQuantity;
    }

    public void add(Product product) {
        if (product == null) return;
        LineItem lineItem = lineItems.getOrDefault(
                product.getId(),
                new LineItem(product, 0)
        );
        lineItem.increaseQuantity();
        lineItems.put(product.getId(), lineItem);
        total = total.add(product.getPrice());
        itemQuantity++;

    }

    // O(1)
    public BigDecimal totalPrice() {
        return total;
    }

    public List<LineItem> getLineItems() {
        return new ArrayList<>(lineItems.values());
    }
}
