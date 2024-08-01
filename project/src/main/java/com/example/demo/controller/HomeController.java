package com.example.demo.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
//        boolean isLoggedIn = false;
//        session.setAttribute("isLoggedIn", isLoggedIn);
        return "home";
    }
}
