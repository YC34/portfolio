package com.backend.jwtTokenLogin.mapper.user;

import com.backend.jwtTokenLogin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
//    User selectUserById(Integer uid);
    // 회원 가입.
    int insertUser(User user);

    User getUserInfo(String email);

    boolean existsByEmail(String email);
}
