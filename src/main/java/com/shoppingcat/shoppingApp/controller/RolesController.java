package com.shoppingcat.shoppingApp.controller;

import com.shoppingcat.shoppingApp.entities.Permission;
import com.shoppingcat.shoppingApp.entities.Role;
import com.shoppingcat.shoppingApp.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/roles")
public class RolesController  extends AdminBaseController{
    public  static  final Logger logger= LoggerFactory.getLogger(RolesController.class);

    @Autowired
    private SecurityService securityService;

    @ModelAttribute("permissionsList")
    public List<Permission> permissionsList(){
        return securityService.getAllPermissions();
    }

    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public String listRoles(Model model){
        List<Role> list=securityService.getAllRoles();
        model.addAttribute("roles",list);
        return "roles/role";
    }
    @RequestMapping("/new")
    public String createRoleForm(Model model){
        Role role=new Role();
        model.addAttribute("role",role);
        return "roles/create_role";
    }
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public  String createRole(@ModelAttribute("role") Role role, Model model, RedirectAttributes redirectAttributes, SessionStatus status){
        Role persistedRole=securityService.createRole(role);
        logger.debug("Created new role with id: {} and name:{}",persistedRole.getId(),persistedRole.getName());
        redirectAttributes.addFlashAttribute("info","Role created successfully");
        status.setComplete();
        return "redirect:/roles/roles";
    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public  String editRoleForm(@PathVariable Integer id , Model model){
        Role role=securityService.getRoleById(id);
        Map<Integer,Permission> assignedPermissionMap=new HashMap<>();
        List<Permission>permissions=role.getPermissions();
        for (Permission permission:permissions){
            assignedPermissionMap.put(permission.getId(),permission);
        }
        List<Permission>rolePermissions=new ArrayList<>();
        List<Permission> allpermiPermissions=securityService.getAllPermissions();
        for (Permission permission:allpermiPermissions){
            if (assignedPermissionMap.containsKey(permission.getId())){
                rolePermissions.add(permission);
            }else {
                rolePermissions.add(null);
            }
        }
        role.setPermissions(rolePermissions);
        model.addAttribute("role",role);
        return "roles/edit_role";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public  String updateRole(@ModelAttribute("role")Role role, BindingResult result,SessionStatus status,RedirectAttributes redirectAttributes){
        Role persistedRole= securityService.updateRole(role);
        logger.debug("Updated role with id: {}  and name :{}",persistedRole.getId(),persistedRole.getName());
        redirectAttributes.addFlashAttribute("info","Role updated successfully");
        status.setComplete();
        return "redirect:/roles/roles";
    }
}
