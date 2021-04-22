package com.appl.controllers;


import com.appl.entities.LoginUser;
import com.appl.repos.LoginUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    LoginUserRepo loginUserRepo;

    @ModelAttribute("loginUser")
    public LoginUser getEmptyLoginUser(){
        return new LoginUser();
    }

    @GetMapping("/")
    public String getHome(){
        return "login";
    }

    @PostMapping("/processUserLogin")
    public String processUserLogin(@ModelAttribute LoginUser loginUser, BindingResult result, Model model){
        System.out.println(loginUser.toString());
        LoginUser byUsername = loginUserRepo.findByUsername(loginUser.getUsername().trim());
        if(byUsername !=null && byUsername.getPassword().equals(loginUser.getPassword())){
            return "OptionsPage";

        }else{
            model.addAttribute("loginUser",getEmptyLoginUser());
            model.addAttribute("loginMessage","Login Failed");
            return "login";
        }
    }

}
