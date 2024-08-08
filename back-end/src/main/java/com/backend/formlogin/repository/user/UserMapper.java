package com.backend.formlogin.repository.user;

import com.backend.formlogin.dto.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
//    User selectUserById(Integer uid);
    // 회원 가입.
    int insertUser(User user);

    User getEmail(String email);
}
