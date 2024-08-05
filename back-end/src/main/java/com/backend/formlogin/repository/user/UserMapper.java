package com.backend.formlogin.repository.user;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface UserMapper {

    UserDetails findById(String username);

}
