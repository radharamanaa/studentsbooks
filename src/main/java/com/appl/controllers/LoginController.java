package com.appl.controllers;


import com.appl.entities.LoginUser;
import com.appl.repos.LoginUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    LoginUserRepo loginUserRepo;


    @Autowired
    public void setLoginUserRepo(LoginUserRepo loginUserRepo) {
        this.loginUserRepo = loginUserRepo;
    }

    @ModelAttribute("loginUser")
    public LoginUser getEmptyLoginUser(){
        return new LoginUser();
    }

    @RequestMapping("/")
    public String getHome(HttpSession session,Model model){
        Object loggedInUser = session.getAttribute("loggedInUser");
        if(loggedInUser !=null){
            model.addAttribute("loginMessage","Welcome"+loggedInUser+"!");
        }
        return "login";
    }
    //todo: Need to add User to session here
    @PostMapping("/processUserLogin")
    public String processUserLogin(@RequestParam("username")String username, @RequestParam("password")String password,
                                   Model model, HttpSession session){
        System.out.println("Username is "+username);
        LoginUser byUsername = loginUserRepo.findByUsername(username.trim());
        if(byUsername !=null && byUsername.getPassword().equals(password)){
            System.out.println("Logged in");
            session.setAttribute("loggedInUser",byUsername.getUsername());
            return "OptionsPage";
        }else{
            model.addAttribute("loginMessage","Login Failed");
            return "login";
        }
    }

}
