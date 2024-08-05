package com.backend.formlogin.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *   UsernamePasswordAuthenticationFilter  formLogin에서 loginProcessingUrl이 던져주는 정보를 처리해주는 filter층
 *   TODO UsernamePasswordAuthenticationFilter로 jwt를 이용한 api 서비스 개발.
 *   TODO session 으로 인증 유지 하는 방법과 , redis로 인증 유지하는 방법 .
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 개발 환경에서는 cors,csrf disable
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.cors( cors -> cors.disable());
        http.csrf( csrf -> csrf.disable());

        // "/", "/login"는 security 적용에서 제외 시키겠다.

        http.authorizeHttpRequests((auth)->
                        auth.requestMatchers(HttpMethod.GET,"/","/login","/test").permitAll() // Get요청은 모두 허용
                            .requestMatchers(HttpMethod.POST,"/admin").hasRole("ADMIN") // Post요청과 admin 권한을 가질떄
                            .anyRequest().authenticated() // 다른 요청은 인증을 받아야 한다.
                );

        http.formLogin(
                (formLogin) -> formLogin.loginPage("/login")
                 .loginProcessingUrl("/loginProc") // spring security filter층 (UsernamePasswordAuthenticationFilter)
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successHandler(new CustomSuccessHandler())
                        .failureHandler(new CustomerFailuerHanlder())
                 .permitAll());


        http.userDetailsService(new CustomUserDetailService());

//        http.addFilterBefore(new J)


        return http.build();
    }


    // password 암호화
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
