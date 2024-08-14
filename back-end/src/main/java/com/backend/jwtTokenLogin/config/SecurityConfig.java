package com.backend.jwtTokenLogin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic( HttpBasicConfigurer::disable )
                .cors( CorsConfigurer::disable )
                .csrf( CsrfConfigurer::disable )
                .formLogin( FormLoginConfigurer::disable )
                .authorizeHttpRequests(
                        (auth)->{
                            auth.requestMatchers("/api/v1/user/login","/api/v1/user/signup","/test").permitAll() // 로그인, 회원가입은 모두허용
                                    .requestMatchers(HttpMethod.POST,"/api/v1/**").authenticated() // 모든 POST요청에는 권한필요.
                                    .anyRequest().authenticated();
                        }
                )
                .sessionManagement( (session) ->{
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                });
        return http.build();
    }
}
