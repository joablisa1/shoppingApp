package com.shoppingcat.shoppingApp.controller;

import com.shoppingcat.shoppingApp.entities.Order;
import com.shoppingcat.shoppingApp.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController extends AdminBaseController {

    public  static Logger logger= LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public  String ListOrders(Model model){
        List<Order> list=orderService.getAllOrders();
        model.addAttribute("orders",list);
        return "orders/orders";
    }

    @RequestMapping(value = "/edit/{orderNumber}",method = RequestMethod.GET)
    public String editOrderForm(@PathVariable String orderNumber,Model model){
        Order order =orderService.getOrder((orderNumber));
        model.addAttribute("order",order);
        return "orders/edit_order";
    }
    @RequestMapping(value = "/update/{orderNumber}",method = RequestMethod.POST)
    public  String updateOrder(@ModelAttribute("order")Order order, SessionStatus status, RedirectAttributes redirectAttributes, BindingResult result,Model model){
        Order persistedOrder= orderService.updateOrder(order);
        logger.debug("Updated order with orderNumber : {}", persistedOrder.getOrderNumber());
        redirectAttributes.addFlashAttribute("info","Order updated successfully");
        status.setComplete();
        return "redirect:/orders/orders";
    }


}
