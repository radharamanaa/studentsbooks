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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    LoginUserRepo loginUserRepo;
    @Autowired
    public LoginUserRepo getLoginUserRepo() {
        return loginUserRepo;
    }

    public void setLoginUserRepo(LoginUserRepo loginUserRepo) {
        this.loginUserRepo = loginUserRepo;
    }

    @ModelAttribute("loginUser")
    public LoginUser getEmptyLoginUser(){
        return new LoginUser();
    }

    @GetMapping("/")
    public String getHome(){
        return "login";
    }
    //todo: Need to add User to session here
    @PostMapping("/processUserLogin")
    public String processUserLogin(@RequestParam("username")String username,@RequestParam("password")String password,Model model){
//        System.out.println(loginUser.toString());
        LoginUser byUsername = loginUserRepo.findByUsername(username.trim());
        if(byUsername !=null && byUsername.getPassword().equals(password)){
            return "OptionsPage";
        }else{
            model.addAttribute("loginMessage","Login Failed");
            return "login";
        }
//        return "login";
    }

}
