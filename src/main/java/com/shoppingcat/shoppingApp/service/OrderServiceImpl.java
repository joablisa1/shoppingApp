package com.shoppingcat.shoppingApp.service;

import com.shoppingcat.shoppingApp.dao.CustomerDao;
import com.shoppingcat.shoppingApp.dao.OrderDao;
import com.shoppingcat.shoppingApp.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class OrderServiceImpl  implements  OrderService{
    @Autowired
    private OrderDao orderDao;

    @Override
    public Order createOrder(Order order) {
        return orderDao.createOrder(order);
    }

    @Override
    public Order getOrder(String orderNumber) {
        return orderDao.getOrder(orderNumber);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public Order updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }
}
