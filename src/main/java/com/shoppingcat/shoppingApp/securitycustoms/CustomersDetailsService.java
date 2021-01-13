package com.shoppingcat.shoppingApp.securitycustoms;

import com.shoppingcat.shoppingApp.entities.Customer;
import com.shoppingcat.shoppingApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomersDetailsService implements UserDetailsService {
    @Autowired private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer= customerService.getCustomerByEmail(email);
        if (customer==null){
            throw  new UsernameNotFoundException("Emali"+ email+"not found");
        }
        return new AuthenticateCustomer(customer);
    }




}
