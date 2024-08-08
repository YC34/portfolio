package com.backend.formlogin.controller.web_user;

import com.backend.formlogin.dto.user.User;
import com.backend.formlogin.dto.user.UserRole;
import com.backend.formlogin.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/login")
    public String login() {
        return "login-page";
    }

//    @PostMapping("/login")
//    public String login(@RequestBody User user , Model model) {
//    //        service.login();
//    // TODO login 성공시와 실패시의 분기문
//        return "redirect:/";
//    }

    @PostMapping("/logout")
    public String logout() {
        HttpSession session = null;
        session.invalidate();
        return "redirect:/";
    }


    /**
     *
     * 아래부터 회원가입 CRUD
     * C : PostMapping -> signUp
     * R : GetMapping -> getEmail
     * U : PutMapping -> modify
     * D : DeleteMapping -> delete
     * 이 외에 것들은 화면을 반환하는 controller
     */

    @GetMapping("/signUp")
    public String signUp() {
        return "user/signup-page";
    }

    @PostMapping("/signUp")
    public String signUp(HttpServletRequest request ,User user) {
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        try {
            UserRole userRole = UserRole.valueOf(request.getParameter("roles"));
            user.setRole(userRole);
        } catch (IllegalArgumentException e) {
            return "redirect:/user/signup-page";
        }

        int loginCount = service.signUp(user);
        if( loginCount < 1) {
            return "redirect:user/signup-page";
        }
        return "redirect:/login-page";
    }

    // 수정
    @GetMapping("/modify")
    public String modify() {
        return "user/modify-page";
    }

    // all  수정 action 회원 정보 수정
    @PutMapping("/modify")
    public String modify(@RequestBody User user , Model model) {
     return "";
    }

    // each 수정 action 회원 탈퇴
    @PatchMapping("/delete")
    public String modify(@RequestParam String deleteYn,
                         Model model){

        // TODO 1. 일부 수정은 회원탈퇴로 한다.
        // TODO 2. 회원정보를 delete 시키는것이 아닌 update를 사용하여, flag값을 사용하지 않는 flag로 변경한다.
        return "";
    }


    @GetMapping("/getEmail")
    public String getEmail(@RequestParam String email){
        // TODO 1. 이메일 체크 boolean type으로 성공과 실패시 action 달리 하기.
        return " ";
    }

}
