package com.backend.formlogin.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((auth)->{
                    auth.requestMatchers("/","/signUp","/signIn","/login").permitAll()
                        .requestMatchers("/WEB-INF/views/home.jsp","/WEB-INF/views/login-page.jsp","/WEB-INF/views/user/signup-page.jsp").permitAll()
//                            .requestMatchers("/WEB-INF/views/**").permitAll()
                        .anyRequest().authenticated();
                })
                .csrf( (CsrfConfigurer::disable))
                .cors( (CorsConfigurer::disable));

        http.formLogin( ( formLogin )->{
            formLogin.loginPage("/login")
                    .loginProcessingUrl("/loginProc")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .successHandler(new CustomSuccessHandler())
                    .failureHandler(new CustomFailureHandler())
                    .failureUrl("/login")
                    .permitAll();
        });

        http.logout( ( logout ) ->{
            logout.logoutUrl("/logout")
            .logoutSuccessUrl("/");
        });

        return http.build();
    }



}
