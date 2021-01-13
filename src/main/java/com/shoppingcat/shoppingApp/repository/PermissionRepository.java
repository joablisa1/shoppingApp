package com.shoppingcat.shoppingApp.repository;


import com.shoppingcat.shoppingApp.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Integer> {
}
