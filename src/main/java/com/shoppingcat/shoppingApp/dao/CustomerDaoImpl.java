package com.shoppingcat.shoppingApp.dao;

import com.shoppingcat.shoppingApp.entities.Customer;
import com.shoppingcat.shoppingApp.entities.Order;
import com.shoppingcat.shoppingApp.repository.CustomerReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public class CustomerDaoImpl implements  CustomerDao {

    @Autowired
    private CustomerReposity customerReposity;


    @Override
    public Customer getCustomerByEmail(String email) {
        return customerReposity.findByEmail(email);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerReposity.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerReposity.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerReposity.getOne(id);
    }

    @Override
    public List<Order> getCustomerOrders(String email) {
        return customerReposity.getCustomerOrders(email);
    }
}
