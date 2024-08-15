//package com.backend.jwtTokenLogin.controller.user;
//
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class UserExceptionController {
//    // TODO Exception을 전역에서 처리해주기.
//    // TODO customer Exception을 만들어서 처리해주기.
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<Map<String,String>> handleIllegalArgumentException(IllegalArgumentException ex) {
//        Map<String, String> errorMessage = new HashMap<>();
//        errorMessage.put("error", ex.getMessage());
//        errorMessage.put("message","이메일이 존재합니다.");
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
//    }
//}
