package com.example.ecommerce;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Map<Integer, LineItem> lineItems = new HashMap<>();

    public Integer lineItemCount() {
        return lineItems.size();
    }

    public void add(Product product) {
        LineItem lineItem = lineItems.getOrDefault(product.getId(), new LineItem(product, 0));
        lineItem.increaseQuantity();
        lineItems.put(product.getId(), lineItem);
    }

    public double totalPrice() {
        double total = 0;
        for (LineItem lineItem : lineItems.values()) {
            total += lineItem.getProduct().getPrice() * lineItem.getQuantity();
        }
        return total;
    }

    public List<LineItem> getLineItems() {
        return new ArrayList<>(lineItems.values());
    }
}
