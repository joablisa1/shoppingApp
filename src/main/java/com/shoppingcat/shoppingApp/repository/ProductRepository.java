package com.shoppingcat.shoppingApp.repository;


import com.shoppingcat.shoppingApp.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Integer>{
    Product findByName(String name);
    Product findBySku(String sku);
    @Query("select p from Product p where  p.name like ?1 or p.sku like ?1 or p.description like  ?1")
    List<Product> search(String query);

    @Override
    Page<Product> findAll(Pageable pageable);

    Page<Product>findProductById(long id, Pageable pageable);
}
