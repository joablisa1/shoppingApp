package com.shoppingcat.shoppingApp.dao;

import com.shoppingcat.shoppingApp.entities.Category;
import com.shoppingcat.shoppingApp.entities.Product;
import com.shoppingcat.shoppingApp.repository.CategoryRepository;
import com.shoppingcat.shoppingApp.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryDaoImplTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @Test
    void getAllCategories1() {
        List<Category>categoryList=categoryRepository.findAll();
        assertNotNull(categoryList);
        assertTrue(!categoryList.isEmpty());
    }

    @Test
    void getAllProducts1() {
        List<Product>products=productRepository.findAll();
        assertNotNull(products);

    }

    @Test
    void getCategoryByName1() {
    }

    @Test
    void getCategoryById1() {
        Category category=categoryRepository.getOne(1);
        assertNotNull(category);
    }

    @Test
    void createCategory1() {
    }

    @Test
    void updateCategory1() {

    }

    @Test
    void getProductById1() {
        Product product=productRepository.getOne(1);
        assertNotNull(product);
    }

    @Test
    void getProductBySku1() {


    }

    @Test
    void createProduct1() {
    }

    @Test
    void updateProduct1() {
    }

    @Test
    void searchProducts1() {
    }

    @Test
    void getAllCategories() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getCategoryByName() {
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void createCategory() {
    }

    @Test
    void updateCategory() {
    }

    @Test
    void getProductById() {

    }

    @Test
    void getProductBySku() {
    }

    @Test
    void createProduct() {

    }

    @Test
    void updateProduct() {
    }

    @Test
    void searchProducts() {

    }

}