package com.shoppingcat.shoppingApp.service;

import com.shoppingcat.shoppingApp.entities.Customer;
import com.shoppingcat.shoppingApp.entities.Order;

import java.util.List;

public interface CustomerService {
    Customer getCustomerByEmail(String email);
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Integer id);
    List<Order>getCustomerOrders(String email);
}
