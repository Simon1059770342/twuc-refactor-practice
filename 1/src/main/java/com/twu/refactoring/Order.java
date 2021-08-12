package com.twu.refactoring;

import java.util.List;

public class Order {
    String name;
    String address;
    List<OrderItem> orderItem;

    public Order(String name, String addr, List<OrderItem> orderItem) {
        this.name = name;
        this.address = addr;
        this.orderItem = orderItem;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<OrderItem> getOrderItems() {
        return orderItem;
    }
}
