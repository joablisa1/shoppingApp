package com.shoppingcat.shoppingApp.usercontroller;

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
public class SiteController extends SiteBaseController {

    @Autowired
    private CategoryService categoryService;

//    @RequestMapping("/")
//    public String index(Model model) {
//        return "templates/index";
//    }

    //    public String home(Model model){
//        List<Category> previewCategories =new ArrayList<>();
//        List<Category> categories =categoryService.getAllCategories();
//        for (Category category:categories){
//            Set<Product> products=category.getProducts();
//            Set<Product> previewProducts=new HashSet<>();
//            int noOfProductsToDisplay=4;
//            if (products.size()>noOfProductsToDisplay){
//                Iterator<Product> iterator=products.iterator();
//                for (int i= 0;i<noOfProductsToDisplay;i++){
//                    previewProducts.add(iterator.next());
//                }
//            }else {
//                previewProducts.addAll(products);
//            }
//            category.setProducts(previewProducts);
//            previewCategories.add(category);
//        }
//        model.addAttribute("categories",previewCategories);
//        return "index";
//    }
    @RequestMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("product", categoryService.getAllProducts());
        return "templates/index";
    }

    @RequestMapping("/category/{name}")
    public String category(@PathVariable String name, Model model) {
        Category category = categoryService.getCategoryByName(name);
        model.addAttribute("category", category);
        return "category";
    }
}
