package com.example.demo.service.auth;

import com.example.demo.dao.auth.UserDao;
import com.example.demo.dto.auth.User;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

@Service
public class AuthService {

    private final UserDao dao;
    private Logger log = Logger.getLogger(AuthService.class.getName());
    public AuthService(UserDao dao) {
        this.dao = dao;
    }

    // 중복 체크
    public boolean checkUser(String username) throws Exception {
        return dao.checkUser(username);
    }

    // 회원 가입
    public void signUpUser(User user) throws Exception {
        // 암호화 전 비밀번호
        String password = user.getPassword();
        log.info("before password : " + password);
        StringBuilder passwordSecurity = getPassword(password);
        log.info("after password : " + passwordSecurity.toString());
        user.setPassword(passwordSecurity.toString());
        dao.addUser(user);
    }

    // 암호화
    private StringBuilder getPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        return hexString;
    }


    public boolean checkInfo(User user) throws Exception {
        System.out.println("check");
        StringBuilder password = getPassword(user.getPassword());

        boolean info = dao.checkUser(user.getUsername(), password.toString());
        if (info) {
            return true;
        }
        return false;

    }

    public User getUser(String username) throws Exception {
        return dao.getUser(username);
    }
}
