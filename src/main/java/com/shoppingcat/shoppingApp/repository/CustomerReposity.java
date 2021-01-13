package com.shoppingcat.shoppingApp.repository;


import com.shoppingcat.shoppingApp.entities.Customer;
import com.shoppingcat.shoppingApp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerReposity extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);

    @Query("select o from Order o where o.customer.email=?1")
    List<Order> getCustomerOrders(String email);
}
