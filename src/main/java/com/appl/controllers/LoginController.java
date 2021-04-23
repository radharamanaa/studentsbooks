package com.appl.controllers;


import com.appl.entities.LoginUser;
import com.appl.repos.LoginUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {


    LoginUserRepo loginUserRepo;

    public LoginUserRepo getLoginUserRepo() {
        return loginUserRepo;
    }
    @Autowired
    public void setLoginUserRepo(LoginUserRepo loginUserRepo) {
        this.loginUserRepo = loginUserRepo;
    }

    @ModelAttribute("loginUser")
    public LoginUser getEmptyLoginUser(){
        return new LoginUser();
    }

    @RequestMapping("/home")
    public String getHome(Model model){
        model.addAttribute("loginMessage","Please Login.");
        return "login";
    }
    //todo: Need to add User to session here
    @PostMapping("/processUserLogin")
    public String processUserLogin(@RequestParam("username")String username,@RequestParam("password")String password,Model model){
        System.out.println("Username is "+username+" and password is "+password);
        LoginUser byUsername = loginUserRepo.findByUsername(username.trim());
        if(byUsername !=null && byUsername.getPassword().equals(password)){
            System.out.println("Logged in");
            return "OptionsPage";
        }else{
            model.addAttribute("loginMessage","Login Failed");
            return "home";
        }
    }

}
