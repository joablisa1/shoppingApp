package com.shoppingcat.shoppingApp.controller;

import com.shoppingcat.shoppingApp.entities.Customer;
import com.shoppingcat.shoppingApp.form.CustomerForm;
import com.shoppingcat.shoppingApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController extends AdminBaseController {
@Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public String listCustomer(Model model){
        List<Customer> list=customerService.getAllCustomers();
        model.addAttribute("customer",list);
        return "customers/customers";
    }

    @RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
    public  String viewCustomerForm(@PathVariable Integer id, Model model){
        Customer customer= customerService.getCustomerById(id);
        CustomerForm  customerForm= new CustomerForm();
        customerForm.setId(customer.getId());
        customerForm.setFirstName(customer.getFirstName());
        customerForm.setLastName(customer.getLastName());
        customerForm.setEmail(customer.getEmail());
        customerForm.setPhone(customer.getPhone());
        model.addAttribute("customerForm",customerForm);
        return "customers/view_customer";
    }

}
