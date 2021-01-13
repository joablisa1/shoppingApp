package com.shoppingcat.shoppingApp.entities;

import java.math.BigDecimal;

public class LineItem {
    private  Product product;
    private  int quantity;

    public  LineItem(){

    }

    public LineItem(Product product,int quantity){
        this.product=product;
        this.quantity=quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal(){
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
