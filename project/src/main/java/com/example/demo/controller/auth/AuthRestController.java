package com.example.demo.controller.auth;


import com.example.demo.dto.auth.User;
import com.example.demo.dto.auth.UserRole;
import com.example.demo.service.auth.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    private final AuthService service;
    @Autowired
    public AuthRestController(AuthService authService) {
        this.service = authService;
    }

    // action signup
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) throws Exception {
        if(user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID와 Password를 입력해주세요.");
        }
        if (service.checkUser(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 아이디 입니다.");
        }


        try{
            user.setAuth(UserRole.USER);
            service.signUpUser(user);
        }catch (SQLException e){
            log.info("회원가입 오류: "+ e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 실패. back-end check");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
    }

    // action login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpSession session) throws Exception {
        // TODO 1. id, password check

        log.info("들어왔니?"+user.getUsername());

        boolean checkInfo = service.checkInfo(user);
        if(checkInfo){
            session.setAttribute("username", user.getUsername());
            session.setAttribute("isLoggedIn", true);
            return ResponseEntity.ok("로그인 성공");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패 아이디 비밀번호를 확인하세요.");
    }
}
