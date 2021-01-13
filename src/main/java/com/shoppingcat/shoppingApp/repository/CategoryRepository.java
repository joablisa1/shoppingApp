package com.shoppingcat.shoppingApp.repository;


import com.shoppingcat.shoppingApp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category getByName(String name);
    Category  getById(Integer categoryId);
}
