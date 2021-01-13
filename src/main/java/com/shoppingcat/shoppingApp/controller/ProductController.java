package com.shoppingcat.shoppingApp.controller;

import com.shoppingcat.shoppingApp.JCartException;
import com.shoppingcat.shoppingApp.entities.Category;
import com.shoppingcat.shoppingApp.entities.Product;
import com.shoppingcat.shoppingApp.form.ProductForm;
import com.shoppingcat.shoppingApp.service.CategoryService;
import com.shoppingcat.shoppingApp.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@EnableSpringDataWebSupport
@RequestMapping("/products")
public class ProductController extends  AdminBaseController{

    public static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired private CategoryService categoryService;
    private Category category ;



    @RequestMapping("/{sku}")
    public String product(@PathVariable String sku,Model model){
        Product product=categoryService.getProductBySku(sku);
        model.addAttribute("product",product);
        return "redirect:/products/getProducts";
    }
    @RequestMapping("/products")
    public  String searchProduct(@RequestParam(name = "q",defaultValue = "")String query,Model model){
        List<Product> products = categoryService.searchProducts(query);
        model.addAttribute("products",products);
        return "redirect:/products/getProducts";
    }

    @RequestMapping(value = "/new")
    public  String creteProductForm(Model model){
        ProductForm productForm= new ProductForm();
        model.addAttribute("productForm",productForm);
        return "products/create_product";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public  String createProduct(@ModelAttribute("productForm") ProductForm productForm, Model model, RedirectAttributes redirectAttributes, BindingResult result,SessionStatus status){
        if (result.hasErrors()){
            return "products/create_product";
        }
        Product product =productForm.toProduct();
        Product persistedProduct= categoryService.createProduct(product);
        productForm.setId(product.getId());
        this.saveProductImageToDisk(productForm);
       logger.debug("created new product with id:{} and name:{}",persistedProduct.getId(),persistedProduct.getName());
        redirectAttributes.addFlashAttribute("info","Product created successfully");
        status.setComplete();
        return "redirect:/products/getProducts";
    }

    private void saveProductImageToDisk(ProductForm productForm) {
        MultipartFile file=productForm.getImage();
        if (file !=null && !file.isEmpty()){
            String name= WebUtils.IMAGES_DIR + productForm.getId()+ ".jpg";
            try {
                byte[] bytes=file.getBytes();
                BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();

            }catch (Exception e){
                throw new JCartException(e);
            }
        }
    }
    @ModelAttribute("/categoryList")
    public List<Category> categoriesList(Model model){
        List<Category> categoryList=categoryService.getAllCategories();
        model.addAttribute("categoryList",categoryList);
        return categoryList;
    }
    @RequestMapping("/getProducts")
    public  String listProducts(Model model){
        model.addAttribute("products", categoryService.getAllProducts());
        return "products/product";
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String editProductForm(@PathVariable Integer id,Model model){
        Product product =categoryService.getProductById(id);
        model.addAttribute("productForm",ProductForm.fromProduct(product));
        return "products/edit";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public  String updateProduct( @ModelAttribute("productForm") ProductForm productForm,BindingResult result,Model model,RedirectAttributes redirectAttributes,SessionStatus status){
        Product product =productForm.toProduct();
        Product persistedProduct =categoryService.updateProduct(product);
        this.saveProductImageToDisk(productForm);
        logger.debug("Updated product with id:{} and name:{}",persistedProduct.getId(),persistedProduct.getName());
        status.setComplete();
        redirectAttributes.addFlashAttribute("info","Product updated successfully");
        return "redirect:/products/getProducts";
    }

    @RequestMapping("/product/images/{productId}")
    public  void  showProductImage(@PathVariable Integer productId, HttpServletRequest request, HttpServletResponse response){
        try {
            FileSystemResource file = new FileSystemResource(WebUtils.IMAGES_DIR + productId+".jpg");
            response.setContentType("image/jpg");
            org.apache.commons.io.IOUtils.copy(file.getInputStream(),response.getOutputStream());
            response.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
