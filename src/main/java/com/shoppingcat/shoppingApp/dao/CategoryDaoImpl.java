package com.shoppingcat.shoppingApp.dao;


import com.shoppingcat.shoppingApp.JCartException;
import com.shoppingcat.shoppingApp.entities.Category;
import com.shoppingcat.shoppingApp.entities.Product;
import com.shoppingcat.shoppingApp.repository.CategoryRepository;
import com.shoppingcat.shoppingApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CategoryDaoImpl implements  CategoryDao {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public  List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public  Category getCategoryByName(String name){
        return  categoryRepository.getByName(name);
    }

    public  Category getCategoryById(Integer id){
        return categoryRepository.getOne(id);
    }
    public  Category createCategory(Category category){
        Category persistedCategory =getCategoryByName(category.getName());
        if (persistedCategory !=null){
            throw  new JCartException("Category" + category.getName()+"already exist");
        }
        return categoryRepository.save(category);
    }

    public  Category updateCategory(Category category){
        Category persistedCategory =getCategoryById(category.getId());
        if (persistedCategory==null){
            throw new JCartException("Category" + category.getId()+ "doesn't exist");
        }
        persistedCategory.setName(category.getName());
        persistedCategory.setDescription(category.getDescription());
        persistedCategory.setDisplayOrder(category.getDisplayOrder());
        persistedCategory.setDisabled(category.isDisabled());
        return categoryRepository.save(persistedCategory);
    }
    public  Product getProductById(Integer id){
        return productRepository.getOne(id);
    }
    public  Product getProductBySku(String sku){
        return productRepository.findBySku(sku);
    }

    public  Product createProduct(Product product){
        Product persistedProduct = getProductBySku(product.getName());
        Category category=new Category();
        if (persistedProduct !=null){
            throw new JCartException("Product SKU" + product.getSku()+"already exist");
        }
        return productRepository.save(product);
    }

    public  Product updateProduct(Product product){
        Product persistedProduct=getProductById(product.getId());
        if (persistedProduct == null){
            throw new JCartException("Product" + product.getId()+ "doesn't exist");
        }
        persistedProduct.setName(product.getName());
        persistedProduct.setDescription(product.getDescription());
        persistedProduct.setDisabled(product.isDisabled());
        persistedProduct.setPrice(product.getPrice());
        persistedProduct.setDisabled(product.isDisabled());
        persistedProduct.setCategory(getCategoryById(product.getCategory().getId()));
        return productRepository.save(persistedProduct);
    }

    public  List<Product> searchProducts(String query){
        return productRepository.search("%" +query + "%");
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findProductById(long id, Pageable pageable) {
        return productRepository.findProductById(id,pageable);
    }

    @Override
    public Category getById(Integer categoryId) {
        return categoryRepository.getById(categoryId);
    }
}

