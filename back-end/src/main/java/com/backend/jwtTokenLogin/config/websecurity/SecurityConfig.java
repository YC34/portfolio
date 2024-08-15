package com.backend.jwtTokenLogin.config.websecurity;


import com.backend.jwtTokenLogin.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${jwt.secret}")
    private String secretKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 사용하지 않는 옵션들 disable
        http.httpBasic( HttpBasicConfigurer::disable )
                .csrf( CsrfConfigurer::disable )
                .formLogin( FormLoginConfigurer::disable );

        // 허용 가능한 url
        // page나 api 요청을 허용해 줄 수 있다.

        http.authorizeHttpRequests(
                        (auth)->{
                            auth.requestMatchers("/api/v1/user/login","/api/v1/user/signup","/test").permitAll() // 로그인, 회원가입은 모두허용
                                    .requestMatchers(HttpMethod.POST,"/api/v1/**").authenticated() // 모든 POST요청에는 권한필요.
                                    .anyRequest().authenticated();
                        }
                );

        // session 에 로그인 정보를 유지하지 않겟다는 설정
        http.sessionManagement( (session) ->{
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                });

        // jwt 토큰 필터는 security의 필터가 아니기 때문에 추가 해줘야한다.
        // security가 적용되기 전에 적용하기 위함.
//        http.addFilterBefore(new JwtFilter(userService, secretKey), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    // 비밀번호 암호화 bean 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
