package com.backend.formlogin.service.user;

import com.backend.formlogin.dto.user.User;
import com.backend.formlogin.repository.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    // DB insert시 암호화를 위해 사용.
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

//    public User selectUserById(Integer uid){
//       User user =  mapper.selectUserById(uid);
//       return user;
//    }

    public int signUp(User user){
        System.out.println("user 들어옴? " +user.getEmail());
        if(!user.getUsername().equals("") && !user.getEmail().equals("") && !user.getPassword().equals("")){
            user.setPassword(passwordEncoder.encode(user.getPassword()));// DB에 암호화
            Integer count = mapper.insertUser(user);
            System.out.println(count);
            return mapper.insertUser(user);
        }
            return 0;
    }

    public User getEmail(String email){
        return mapper.getEmail(email);
    }




    public PasswordEncoder passwordEncoder(){
        return this.passwordEncoder;
    }

}
