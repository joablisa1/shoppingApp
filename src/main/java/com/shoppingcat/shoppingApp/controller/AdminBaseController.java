package com.shoppingcat.shoppingApp.controller;

import com.shoppingcat.shoppingApp.security.AuthenticatedUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

public  abstract class AdminBaseController {

    @ModelAttribute("authenticatedUser")
    public AuthenticatedUser authenticatedUser(@AuthenticationPrincipal AuthenticatedUser authenticatedUser){
        return authenticatedUser;
    }
    public  static  AuthenticatedUser getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AuthenticatedUser){
            return ((AuthenticatedUser)principal);
        }
        return null;
    }
}
