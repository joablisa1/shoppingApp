package com.shoppingcat.shoppingApp.usercontroller;

import com.shoppingcat.shoppingApp.entities.Customer;
import com.shoppingcat.shoppingApp.entities.Order;
import com.shoppingcat.shoppingApp.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerControllers extends SiteBaseController {
    public static final Logger logger = LoggerFactory.getLogger(CustomerControllers.class);
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes, SessionStatus status, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        String password = customer.getPassword();
        String encodedPwd = passwordEncoder.encode(password);
        customer.setPassword(encodedPwd);
        Customer persistedCustomer = customerService.createCustomer(customer);
        logger.debug("Created new Customer with id : {} and email : {}", persistedCustomer.getId(), persistedCustomer.getEmail());
        redirectAttributes.addFlashAttribute("info", "Customer created successfully");
        return "redirect:/public/login";
    }

    @RequestMapping(value = "/myAccount", method = RequestMethod.GET)
    public String myAccount(Model model) {
        String email = getCurrentCustomer().getCustomer().getEmail();
        Customer customer = customerService.getCustomerByEmail(email);
        model.addAttribute("customer", customer);
        List<Order> orders = customerService.getCustomerOrders(email);
        model.addAttribute("orders", orders);
        return "myAccount";
    }


}
