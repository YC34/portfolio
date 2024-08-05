package com.backend.formlogin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login() {
        return "login-page";
    }

    @GetMapping("/success")
    public String loginSucessPage(){
        return "login-success";
    }

}
