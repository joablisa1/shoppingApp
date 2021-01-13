package com.shoppingcat.shoppingApp.security;

import com.shoppingcat.shoppingApp.entities.User;
import com.shoppingcat.shoppingApp.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired private SecurityService securityService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =securityService.findUserByEmail(email);

        if (user==null){
            throw new UsernameNotFoundException("Email"+email+"not found");
        }
        return new AuthenticatedUser(user);
    }
}
