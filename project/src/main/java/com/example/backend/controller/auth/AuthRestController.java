package com.example.backend.controller.auth;


import com.example.backend.dto.auth.User;
import com.example.backend.dto.auth.UserRole;
import com.example.backend.service.auth.AuthService;
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
    public ResponseEntity<?> login(@RequestBody User user, HttpSession session) throws Exception {

        log.info("들어왔니?"+user.getUsername());
        // 인증 .
        boolean checkInfo = service.checkInfo(user);

        // userInfo get 인가를 위해 username과 권한을 가져옴.
        // TODO username은 등록을 위한..? 정보. 유일한 컬럼인 id를 고려.

        User loginUser = service.getUser(user.getUsername());
        log.info("login USERNAME : " + loginUser.getUsername());
        log.info("login USERAUTH : " + String.valueOf(loginUser.getAuth()));

        // 인가
        if(checkInfo){
            session.setAttribute("username", loginUser.getUsername());
            session.setAttribute("role", loginUser.getAuth());
            session.setAttribute("login", true);
            return ResponseEntity.ok(loginUser);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패 아이디 비밀번호를 확인하세요.");
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) throws Exception {
        session.invalidate();
        return ResponseEntity.ok("로그아웃 성공.");
    }

}
