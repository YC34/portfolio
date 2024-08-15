package com.backend.jwtTokenLogin.config.websecurity;

import com.backend.jwtTokenLogin.entity.user.User;
import com.backend.jwtTokenLogin.entity.user.UserRole;
import com.backend.jwtTokenLogin.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Component
@RequiredArgsConstructor
public class AuthProvider implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        // 회원 인증 및 비밀번호 체크.
        User user = userService.getUserInfo(email);
        if(user != null && passwordEncoder.matches(password, user.getPassword())){
            List<GrantedAuthority> roles = new ArrayList<>();
            UserRole role = null;
            roles.add(new SimpleGrantedAuthority(String.valueOf(role.USER)));
            return new UsernamePasswordAuthenticationToken(email, password, roles);
        }else {
            log.info("입력한 이메일 : " + email);
            log.info("입력한 비밀번호 : " + password);
            throw new BadCredentialsException("email or password is incorrect");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
