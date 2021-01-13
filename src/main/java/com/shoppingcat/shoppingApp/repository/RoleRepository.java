package com.shoppingcat.shoppingApp.repository;

import com.shoppingcat.shoppingApp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String name);

}
