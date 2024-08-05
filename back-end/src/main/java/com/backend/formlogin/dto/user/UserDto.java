package com.backend.formlogin.dto.user;


import com.backend.formlogin.dto.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class UserDto implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private UserRole role;

    public UserDto() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role));
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠금 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 패스워드 만료 여부
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 계정 사용 여부
        return true;
    }
}
