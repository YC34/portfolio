package com.backend.jwtTokenLogin.service.user;

import com.backend.jwtTokenLogin.entity.user.User;
import com.backend.jwtTokenLogin.entity.user.UserRole;
import com.backend.jwtTokenLogin.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;




    public int signUp(User user){

        if(mapper.existsByEmail(user.getEmail())){
            throw new IllegalStateException("이메일이 존재합니다.");
        }
        if(!user.getUsername().equals("") && !user.getEmail().equals("") && !user.getPassword().equals("")){
            user.setPassword(passwordEncoder.encode(user.getPassword()));// DB에 암호화
            user.setRole(UserRole.USER);
            int count = mapper.insertUser(user);
            return count;
        }
            return 0;
    }

    public User getUserInfo(String email){
        return mapper.getUserInfo(email);
    }



}
