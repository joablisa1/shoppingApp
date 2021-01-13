package com.shoppingcat.shoppingApp.usercontroller;

import com.shoppingcat.shoppingApp.entities.Product;
import com.shoppingcat.shoppingApp.service.CategoryService;
import com.shoppingcat.shoppingApp.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductControllers  extends SiteBaseController{

    @Autowired private CategoryService categoryService;

    @RequestMapping("/{sku}")
    public String product(@PathVariable String sku, Model model){
        Product product=categoryService.getProductBySku(sku);
        model.addAttribute("product",product);
        return "templates/product_detail";
    }
    @RequestMapping(value = "/search",method =RequestMethod.POST)
    public String searchProducts(@RequestParam(name = "q",defaultValue = "")String query,Model model){
        List<Product> products=categoryService.searchProducts(query);
            model.addAttribute("products",products);
        return "templates/product_search";
    }

    @RequestMapping(value = "/product/images/{productId}",method = RequestMethod.GET)
    public void showProductImage(@PathVariable String productId, HttpServletRequest request, HttpServletResponse response){
        try {
            FileSystemResource file=new FileSystemResource(WebUtils.IMAGES_DIR+productId+".jpg");
            response.setContentType("image/jpg");
            org.apache.commons.io.IOUtils.copy(file.getInputStream(),response.getOutputStream());
            response.flushBuffer();

        }catch (Exception e){
            e.getMessage();
        }
    }
}
