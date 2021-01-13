package com.shoppingcat.shoppingApp.service;

import com.shoppingcat.shoppingApp.dao.CategoryDao;
import com.shoppingcat.shoppingApp.entities.Category;
import com.shoppingcat.shoppingApp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CatalogServiceImp implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public Category getCategoryByName(String name) {
        return categoryDao.getCategoryByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public List<Product> getAllProducts() {
        return categoryDao.getAllProducts();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryDao.createCategory(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }

    @Override
    public Product getProductById(Integer id) {
        return categoryDao.getProductById(id);
    }

    @Override
    public Product getProductBySku(String sku) {
        return categoryDao.getProductBySku(sku);
    }

    @Override
    public Product createProduct(Product product) {
        return categoryDao.createProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return categoryDao.updateProduct(product);
    }
    @Override
    public List<Product> searchProducts(String query) {
        return categoryDao.searchProducts(query);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return categoryDao.findAll(pageable);
    }

    @Override
    public Page<Product> findProductById(long id, Pageable pageable) {
        return categoryDao.findProductById(id,pageable);
    }

    @Override
    public Category getById(Integer categoryId) {
        return  categoryDao.getById(categoryId);
    }
}
