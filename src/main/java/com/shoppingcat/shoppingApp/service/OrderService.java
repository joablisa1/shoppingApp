package com.shoppingcat.shoppingApp.service;

import com.shoppingcat.shoppingApp.entities.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrder(String orderNumber);

    List<Order> getAllOrders();

    Order updateOrder(Order order);
}
