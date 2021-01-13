package com.shoppingcat.shoppingApp.controller;

import com.shoppingcat.shoppingApp.entities.Category;
import com.shoppingcat.shoppingApp.service.CategoryService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController extends AdminBaseController {
    public static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/new")
    public String createCategoryForm(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "categories/create_category";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String createCategory(@ModelAttribute("category") Category category, BindingResult result, Model model, RedirectAttributes redirectAttributes, SessionStatus status) {
        if (result.hasErrors()) {
            return "create_category";
        }
        Category persistedCategory = categoryService.createCategory(category);
        if (persistedCategory == null) {
            System.out.println("Record not saved in the database");
        } else {
            System.out.println("Successfully saved in the database" + persistedCategory.getId());
        }
        logger.debug("Created new Category with id:{} and name: {}", persistedCategory.getId(), persistedCategory.getName());
        redirectAttributes.addFlashAttribute("info", "category created successfully");
        status.setComplete();
        return "redirect:/categories/getCategories";
    }

    @RequestMapping("/getCategories")
    public String listCategory(Model model) {
        List<Category>list =new ArrayList<>();
        for (Category category:categoryService.getAllCategories())
            list.add(category);
            model.addAttribute("categories",list);

        return "categories/categories";
    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public  String editCategoryForm(@PathVariable Integer id ,Model model){
        Category category=categoryService.getCategoryById(id);
        model.addAttribute("category",category);
        return "categories/edit";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public  String updateCategory(@ModelAttribute(value ="category")Category category, Model model, RedirectAttributes redirectAttributes,SessionStatus status){
        Category persistedCategory =categoryService.updateCategory(category);
        logger.debug("Updated category with id:{} and name :{}",persistedCategory.getId(),persistedCategory.getName());
        redirectAttributes.addFlashAttribute("info","Category updated successfully");
        status.setComplete();
        System.out.println("category updated successfully");
        return "redirect:/categories/getCategories";
    }


}
