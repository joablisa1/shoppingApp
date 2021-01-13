package com.shoppingcat.shoppingApp.dao;


import com.shoppingcat.shoppingApp.entities.Order;
import com.shoppingcat.shoppingApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class OrderDaoImpl implements  OrderDao {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order createOrder(Order order) {

        order.setOrderNumber(String.valueOf(System.currentTimeMillis()));
        Order saveOrder =orderRepository.save(order);
        return saveOrder;
    }

    @Override
    public Order getOrder(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        Order o =getOrder(order.getOrderNumber());
        o.setStatus(order.getStatus());
        Order saveOrder = orderRepository.save(o);
        return saveOrder;
    }
}
