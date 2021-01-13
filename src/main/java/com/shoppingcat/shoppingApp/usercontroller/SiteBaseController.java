package com.shoppingcat.shoppingApp.usercontroller;

import com.shoppingcat.shoppingApp.entities.Cart;
import com.shoppingcat.shoppingApp.security.AuthenticatedUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public abstract class SiteBaseController {

    @ModelAttribute("authenticatedUser")
    public AuthenticatedUser authenticatedUser(@AuthenticationPrincipal AuthenticatedUser authenticatedUser){
        return authenticatedUser;
    }

    public  static  AuthenticatedUser getCurrentCustomer(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof  AuthenticatedUser){
            return ((AuthenticatedUser)principal);
        }
        return  null;
    }
    public  static  boolean isLoggedIn(){
        return getCurrentCustomer() !=null;
    }
    public Cart getOrCreateCart(HttpServletRequest request){
        Cart cart=null;
        cart = (Cart)request.getSession().getAttribute("CART_KEY");
        if (cart==null){
            cart=new Cart();
            request.getSession().setAttribute("CART_KEY",cart);
        }
        return cart;
    }























}
