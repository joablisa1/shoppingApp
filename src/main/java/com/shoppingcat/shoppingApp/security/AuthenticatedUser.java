package com.shoppingcat.shoppingApp.security;

import com.shoppingcat.shoppingApp.entities.Customer;
import com.shoppingcat.shoppingApp.entities.Permission;
import com.shoppingcat.shoppingApp.entities.Role;
import com.shoppingcat.shoppingApp.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

    private User user;
    private  Customer customer;

    public AuthenticatedUser(User user) {
        super(user.getEmail(),user.getUserpassword(),getAuthorities(user));
        this.user=user;
    }
    public  AuthenticatedUser(Customer customer){
        super(customer.getEmail(),customer.getPassword(), getAuthorities(customer));
        this.customer=customer;
    }
    public  User getUser(){
        return user;
    }
    public  Customer getCustomer(){
        return customer;
    }
    private  static Collection<? extends GrantedAuthority>getAuthorities(User user){
        Set<String>roleAndPermissions=new HashSet<>();
        List<Role> roles=user.getRoles();
        for (Role role:roles){
            roleAndPermissions.add(role.getName());
            List<Permission> permissions=role.getPermissions();
            for (Permission permission:permissions){
                roleAndPermissions.add("ROLE_" + permission.getName());
            }
        }
        String[] roleNames=new String[roleAndPermissions.size()];
        Collection<GrantedAuthority>authorities=AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
        return authorities;
    }

    public  static Collection<? extends GrantedAuthority> getAuthorities(Customer customer){
        Collection<GrantedAuthority>authorities= AuthorityUtils.createAuthorityList("ROLE_USER");
        return authorities;
    }
}
