package com.backend.formlogin.config.security;

import com.backend.formlogin.dto.user.User;
import com.backend.formlogin.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class AuthProvider implements AuthenticationProvider {
    private final Logger log = Logger.getLogger(AuthProvider.class.getName());

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = (String) authentication.getPrincipal(); // 로그인 창에 입력한 email
        String password = (String) authentication.getCredentials(); // 로그인 창에 입력한 password

        PasswordEncoder encoder = userService.passwordEncoder(); // 비밀번호 검증
        UsernamePasswordAuthenticationToken authenticationToken ; // id password를 통한 검증.
        User user = userService.getEmail(email);
        if(user != null && encoder.matches(password, user.getPassword())){
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(user.getRole().name()));

            return new UsernamePasswordAuthenticationToken(email, password, roles);
        }else {
            log.info("입력한 이메일 : " + email);
            log.info("입력한 비밀번호 : " + password);
            throw new BadCredentialsException("email or password is incorrect");
        }
    }

    // 어떤 인증방법을 지원할 것인가에 대한 메소드
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
