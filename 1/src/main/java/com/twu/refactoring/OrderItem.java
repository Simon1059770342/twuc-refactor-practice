package com.twu.refactoring;

public class OrderItem {
    private String description;
    private double price;
    private int quantity;

    public OrderItem(String description, double price, int quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return getDescription() + '\t' + getPrice() + '\t' + getQuantity() + '\t' + totalAmount() + '\n';
    }
}