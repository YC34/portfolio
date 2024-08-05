package com.backend.formlogin.controller.test;


import com.backend.formlogin.dto.TestDto;
import com.backend.formlogin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/test")
public class TestController {


    @Autowired
    TestService service;

    @GetMapping
    public String test(){
        List<TestDto> testDtos = service.findAll();
        for (TestDto testDto : testDtos) {
            System.out.println(testDto.getAid());
            System.out.println(testDto.getDate());
        }
        return "test";
    }



//    @GetMapping("/{aid}")
//    public ResponseEntity<TestDto>
}
