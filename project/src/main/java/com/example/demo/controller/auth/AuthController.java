package com.example.demo.controller.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class AuthController {
    private Logger log = Logger.getLogger(AuthController.class.getName());

    // sign-up page return
    @GetMapping("/signup")
    public String signin(HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        int serverPort = request.getServerPort();
        log.info("request Client IP :  " + clientIp);
        log.info("request ServerPort IP :  " + serverPort);
        return "auth/signup";
    }


    // login page return
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        int serverPort = request.getServerPort();
        log.info("request Client IP :  " + clientIp);
        log.info("request ServerPort IP :  " + serverPort);
        return "auth/login";
    }


}
