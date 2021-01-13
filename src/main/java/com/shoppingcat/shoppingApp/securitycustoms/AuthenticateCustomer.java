package com.shoppingcat.shoppingApp.securitycustoms;

import com.shoppingcat.shoppingApp.entities.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class AuthenticateCustomer extends  org.springframework.security.core.userdetails.User {

    private Customer customer;

    public AuthenticateCustomer(Customer customer){
        super(customer.getEmail(),customer.getPassword(), getAuthorities(customer));
        this.customer=customer;
    }
    public  Customer getCustomer(){
        return customer;
    }

    public  static Collection<? extends GrantedAuthority> getAuthorities(Customer customer){
        Collection<GrantedAuthority>authorities= AuthorityUtils.createAuthorityList("ROLE_USER");
        return authorities;
    }

















}


