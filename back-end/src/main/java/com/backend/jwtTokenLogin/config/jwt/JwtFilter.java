//package com.backend.jwtTokenLogin.config.jwt;
//
//import com.backend.jwtTokenLogin.service.user.UserService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//
///**
// * token을 검증하는 filter
// */
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private UserService userService;
//    private String secretKey;
//
//    public JwtFilter(UserService userService, String secretKey) {
//        this.userService = userService;
//        this.secretKey = secretKey;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//
//        // 권한 가져오기.
//        final String authorization = request.getHeader("Authorization");
//        final String jwt;
//
//        if(authorization == null || !authorization.startsWith("Bearer ")){
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        jwt = authorization.substring(7);
//        j
//
//        UsernamePasswordAuthenticationToken authenticationToken
//                = new UsernamePasswordAuthenticationToken(username, null, List.of(new SimpleGrantedAuthority("USER")));
//
//
//
//        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        filterChain.doFilter(request, response);
//
//
//    }
//}
