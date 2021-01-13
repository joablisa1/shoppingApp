package com.shoppingcat.shoppingApp.form;

import com.shoppingcat.shoppingApp.entities.Category;
import com.shoppingcat.shoppingApp.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class ProductForm {
    private Integer id;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price = new BigDecimal("0.0");
    private String imageUrl;
    private MultipartFile image;
    private boolean disabled;
    private Integer categoryId=0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Product toProduct() {
        Product p = new Product();
        p.setId(id);
        p.setName(name);
        p.setDescription(description);
        p.setDisabled(disabled);
        p.setPrice(price);
        p.setSku(sku);
        Category category=new Category();
//        category.getProducts().add(p);
         category.setId(categoryId);
         p.setCategory(category);
        return p;
    }

    public static ProductForm fromProduct(Product product) {
        ProductForm p = new ProductForm();
        p.setId(product.getId());
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setDisabled(product.isDisabled());
        p.setPrice(product.getPrice());
        p.setSku(product.getSku());
        p.setCategoryId(product.getCategory().getId());
        return p;
    }
}
