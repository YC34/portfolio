package com.backend.jwtTokenLogin.controller.user;


import com.backend.jwtTokenLogin.entity.user.User;
import com.backend.jwtTokenLogin.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        try {
            int result = userService.signUp(user);
            if(result == 1) {
                return ResponseEntity.ok().body("회원가입이 성공하였습니다.");
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입이 실패하였습니다.");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


}
