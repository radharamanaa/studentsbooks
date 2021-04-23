package com.appl.controllers;

import com.appl.entities.LoginUser;
import com.appl.entities.Student;
import com.appl.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class StudentController {

    StudentRepo studentRepo;

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @ModelAttribute
    public Student getNewStudent(){
        return new Student();
    }

    @GetMapping("/addStudent")
    public String addStudent(HttpSession session, Model model) {
        if (session.getAttribute(LoginUser.loggedInUser) == null) {
            model.addAttribute("loginMessage", "Are you a Hacker?");
            return "login";
        }
        model.addAttribute("newStudent",new Student());
        return "AddStudent";

    }

    @PostMapping("/persistStudent")
    public String persistStudent(@Valid @ModelAttribute Student student,
                                 BindingResult result, Model model, HttpSession session){
        System.out.println("persistStudent: "+student.getName());
        if (session.getAttribute(LoginUser.loggedInUser) == null) {
            model.addAttribute("loginMessage", "Are you a Hacker?");
            return "login";
        }
        if(result.hasErrors()){
            model.addAttribute("errors","Student could not be added");
            return "addStudent";
        }
        model.addAttribute("message","Student Added Successfully");
        return "OptionsPage";
    }
}
