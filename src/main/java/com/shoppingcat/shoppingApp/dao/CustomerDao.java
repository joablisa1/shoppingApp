package com.shoppingcat.shoppingApp.dao;

import com.shoppingcat.shoppingApp.entities.Customer;
import com.shoppingcat.shoppingApp.entities.Order;

import java.util.List;

public interface CustomerDao {
    Customer getCustomerByEmail(String email);
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Integer id);
    List<Order>getCustomerOrders(String email);
}
