package com.shoppingcat.shoppingApp.repository;


import com.shoppingcat.shoppingApp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order findByOrderNumber(String orderNumber);
}
