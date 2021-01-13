package com.shoppingcat.shoppingApp.usercontroller;

import com.shoppingcat.shoppingApp.entities.*;
import com.shoppingcat.shoppingApp.service.CustomerService;
import com.shoppingcat.shoppingApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class OrderControllers  extends SiteBaseController{
    @Autowired private CustomerService customerService;
    @Autowired private OrderService orderService;


    @RequestMapping(value = "/orders",method = RequestMethod.POST)
    public  String placeOrder(@ModelAttribute("order")OrderDTO order, HttpServletRequest request, Model model, BindingResult result){
        Cart cart=getOrCreateCart(request);
        if (result.hasErrors()){
            return "checkout";
        }
        Order newOrder=new Order();
        String email=getCurrentCustomer().getCustomer().getEmail();
        Customer customer=customerService.getCustomerByEmail(email);
        newOrder.setCustomer(customer);
        Address address=new Address();
        address.setAddressLine1(order.getAddressLine1());
        address.setAddressLine2(order.getAddressLine2());
        address.setCity(order.getCity());
        address.setState(order.getState());
        address.setZipcode(order.getZipcode());
        address.setCountry(order.getCountry());

        newOrder.setDeliveryAddress(address);

        Address billingAddress=new Address();
        billingAddress.setAddressLine1(order.getAddressLine1());
        billingAddress.setAddressLine2(order.getAddressLine2());
        billingAddress.setCity(order.getCity());
        billingAddress.setState(order.getState());
        billingAddress.setZipcode(order.getZipcode());
        billingAddress.setCountry(order.getCountry());

        newOrder.setBillingAddress(billingAddress);

        Set<OrderItem> orderItems=new HashSet<OrderItem>();
        List<LineItem> lineItems=cart.getItems();
        for (LineItem lineItem: lineItems){
            OrderItem item=new OrderItem();
            item.setProduct(lineItem.getProduct());
            item.setQuantity(lineItem.getQuantity());
            item.setPrice(lineItem.getProduct().getPrice());
            item.setOrder(newOrder);
            orderItems.add(item);
        }
        newOrder.setItems(orderItems);
        Payment payment=new Payment();
        payment.setCcNumber(order.getCcNumber());
        payment.setCvv(order.getCvv());
        newOrder.setPayment(payment);
        Order savedOrder=orderService.createOrder(newOrder);
        request.getSession().removeAttribute("CART_KEY");
        return "redirect:orderconfirmation?orderNumber="+savedOrder.getOrderNumber();

//        this.setOrderConfirmationEmail()
    }
    @RequestMapping(value = "/confirmation",method = RequestMethod.GET)
    public String showOrderConfirmation(@RequestParam(value = "orderNumber")String orderNumber,Model model){
        Order order=orderService.getOrder(orderNumber);
        model.addAttribute("order",order);
        return "orderconfirmation";
    }
    @RequestMapping(value = "/order/{orderNumber}",method = RequestMethod.GET)
    public String viewOrder(@PathVariable(value = "orderNumber")String orderNumber,Model model){
        Order order=orderService.getOrder(orderNumber);
        model.addAttribute("order",order);
        return "view_order";
    }



































































































}
