package com.shoppingcat.shoppingApp.service;

import com.shoppingcat.shoppingApp.dao.CustomerDao;
import com.shoppingcat.shoppingApp.entities.Customer;
import com.shoppingcat.shoppingApp.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
public class CustomerServiceImpl implements CustomerService {
     @Autowired
     CustomerDao customerDao;
    @Override
    public Customer getCustomerByEmail(String email) {
        return customerDao.getCustomerByEmail(email);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public List<Order> getCustomerOrders(String email) {
        return customerDao.getCustomerOrders(email);
    }
}
