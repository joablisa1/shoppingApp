package com.shoppingcat.shoppingApp.controller;

import com.shoppingcat.shoppingApp.entities.Permission;
import com.shoppingcat.shoppingApp.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/permissions")
public class PermissionController extends AdminBaseController {

    @Autowired
    protected SecurityService securityService;

    @RequestMapping(value = "/permissions",method = RequestMethod.GET)
    public  String listPermissions(Model model){
        List<Permission>list =securityService.getAllPermissions();
        model.addAttribute("permissions",list);
        return "permissions/permissons";
    }

}
