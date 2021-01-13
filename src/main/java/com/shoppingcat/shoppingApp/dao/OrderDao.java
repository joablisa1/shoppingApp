package com.shoppingcat.shoppingApp.dao;



import com.shoppingcat.shoppingApp.entities.Order;

import java.util.List;

public interface OrderDao {

    Order createOrder(Order order);

    Order getOrder(String orderNumber);

    List<Order> getAllOrders();

    Order updateOrder(Order order);
}
