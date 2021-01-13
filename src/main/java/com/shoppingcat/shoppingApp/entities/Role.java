package com.shoppingcat.shoppingApp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role  {
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(length = 1024)
    private String description;
    @ManyToMany(mappedBy = "roles")
    private List<User>users;
    @ManyToMany
    @JoinTable(name ="role_permission",joinColumns = {@JoinColumn(name = "ROLE_ID",referencedColumnName = "ID")},inverseJoinColumns = {@JoinColumn(name = "PERM_ID",referencedColumnName = "ID")})
    private List<Permission>permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
