package com.example.backend.controller.notice;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {

    @GetMapping("/notice")
    public String notice(){
        return "notice/home";
    }
}
