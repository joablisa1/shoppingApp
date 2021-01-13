package com.shoppingcat.shoppingApp.service;

import com.shoppingcat.shoppingApp.entities.Category;
import com.shoppingcat.shoppingApp.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    List<Product>getAllProducts();
    Category getCategoryById(Integer id);
    Category createCategory(Category category);
    Category updateCategory(Category category);
    Product getProductById(Integer id);
    Product getProductBySku(String sku);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    List<Product> searchProducts(String query);
    Page<Product> findAll(Pageable pageable);
    Page<Product> findProductById(long id, Pageable pageable);
    Category  getById(Integer categoryId);
}
