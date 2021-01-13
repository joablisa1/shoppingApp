package com.shoppingcat.shoppingApp.controller;

import com.shoppingcat.shoppingApp.entities.User;
import com.shoppingcat.shoppingApp.service.SecurityService;
import com.shoppingcat.shoppingApp.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/public")
public class UserAuthController  extends AdminBaseController{
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired private SecurityService securityService;
    @Autowired private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login")
    public  String login(Model model){
        return "public/login";
    }

    @RequestMapping(value = "/forgotPwd",method = RequestMethod.GET)
    public  String forgotPwd(Model model){
        return "public/forgotPwd";
    }
    @RequestMapping(value = "/forgotPwd",method = RequestMethod.POST)
    public  String handleForgotPwd(HttpServletRequest request, RedirectAttributes redirectAttributes){
        String email=request.getParameter("email");
        try {
            String token=securityService.resetPassword(email);
            String resetPwdURL= WebUtils.getURLWithContextPath(request)+"/resetPwd?email="+email + "&token="+token;
            redirectAttributes.addFlashAttribute("msg","Sorry wrong password");

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg",e.getMessage());
        }
        return "redirect:/public/forgotPwd";
    }

    @RequestMapping(value = "/resetPwd",method = RequestMethod.GET)
    public  String resetPwd(HttpServletRequest request,Model model,RedirectAttributes redirectAttributes){
        String email =request.getParameter("email");
        String token=request.getParameter("token");
        boolean valid=securityService.verifyPasswordResetToken(email,token);

        if (valid){
            model.addAttribute("email",email);
            model.addAttribute("token",token);
            return "public/resetPwd";
        }else {
            redirectAttributes.addFlashAttribute("msg","Invalid username and password please try again");
            return "redirect:/login";
        }
    }
    @RequestMapping(value="/resetPwd", method=RequestMethod.POST)
    public String handleResetPwd(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes){
        try{
            String email=request.getParameter("email");
            String token=request.getParameter("token");
            String password=request.getParameter("password");
            String confPassword=request.getParameter("confPassword");

            if (!password.equals(confPassword)){
                model.addAttribute("email",email);
                model.addAttribute("token",token);
                model.addAttribute("msg","Password does not match");
                return "public/resetPwd";
            }
            String encodedPwd=passwordEncoder.encode(password);
            securityService.updatePassword(email,token,encodedPwd);
            redirectAttributes.addFlashAttribute("msg","Password Updated Successfully");

        }catch (Exception e){
            logger.error(e.getMessage());
            redirectAttributes.addFlashAttribute("msg","Invalid password try again or register with new Account");
        }
        return "redirect:/login";
    }























}
