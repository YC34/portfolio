package com.backend.formlogin.controller.api_user;

import com.backend.formlogin.dto.user.User;
import com.backend.formlogin.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 */


@RestController
@RequestMapping("/user")
public class UserRestController {


    @Autowired
    private UserService service;

//    @GetMapping
//    public ResponseEntity<User> selectUserById(@RequestParam Integer uid){
//        User user = service.selectUserById(uid);
//        return ResponseEntity.ok(user);
//
//    }



    @PostMapping
    public ResponseEntity<Integer> signUpUser(@RequestBody User user){
        int count = service.signUp(user);
        if(count < 1){
            return ResponseEntity.badRequest().body(-1);
        }
        return ResponseEntity.ok(count);
    }

}
