//package com.backend.jwtTokenLogin.config.jwt;
//
//
//import com.backend.jwtTokenLogin.service.user.UserService;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Header;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class JwtUtil {
//
//    // JWT 구성
//    // header , payload, signature
//    // aaaaa.bbbbb.ccccc
//
//
//    public static String createToken(String username, String secretKey, Long expirationTime) {
//        Claims claims = Jwts.claims();
//        claims.put("username", username);
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() +expirationTime))
//                .signWith(SignatureAlgorithm.HS256,secretKey)
//                .compact();
//
//
//    }
//
//}
