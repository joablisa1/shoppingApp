package com.shoppingcat.shoppingApp.controller;

import com.shoppingcat.shoppingApp.entities.Category;
import com.shoppingcat.shoppingApp.entities.Product;
import com.shoppingcat.shoppingApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class HomeController extends AdminBaseController {

    @RequestMapping("/home")
    public String admin(Model model){
        return "admin/home";
    }

}

