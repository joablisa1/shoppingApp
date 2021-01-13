package com.shoppingcat.shoppingApp.controller;

import com.shoppingcat.shoppingApp.entities.Role;
import com.shoppingcat.shoppingApp.entities.User;
import com.shoppingcat.shoppingApp.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController  extends AdminBaseController{

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private SecurityService securityService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute("roleList")
    public List<Role> roleList() {
        return securityService.getAllRoles();
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String listUsers(Model model) {
        List<User> list = new ArrayList<>();
        for (User user: securityService.getAllUsers())
            list.add(user);
            model.addAttribute("users", list);
        return "users/users";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/create_user";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        String password = user.getUserpassword();
        String encoderPwd = passwordEncoder.encode(password);
        user.setUserpassword(encoderPwd);
        User persistedUser = securityService.createUser(user);
        model.addAttribute("user",user);
        logger.debug("Created new User with id : {} and name : {}", persistedUser.getId(), persistedUser.getName());
        redirectAttributes.addFlashAttribute("info", "User created successfully");
        return "redirect:/users/detail";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editUserForm(@PathVariable Integer id, Model model) {
        User user = securityService.getUserById(id);
        Map<Integer, Role> assignedRoleMap = new HashMap<>();
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            assignedRoleMap.put(role.getId(), role);
        }
        List<Role> userRoles = new ArrayList<>();
        List<Role> allRoles = securityService.getAllRoles();
        for (Role role : allRoles) {
            if (assignedRoleMap.containsKey(role.getId())) {
                userRoles.add(role);
            } else {
                userRoles.add(null);
            }
        }
        user.setRoles(userRoles);
        model.addAttribute("user", user);
        return "users/edit_user";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        User persistedUser = securityService.updateUser(user);
        logger.debug("Updated user with id : {} and name : {}", persistedUser.getId(), persistedUser.getName());
        redirectAttributes.addFlashAttribute("info", "User updates successfully");
        return "redirect:/users/detail";
    }

}
