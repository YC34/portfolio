package com.backend.formlogin.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;


@Component
public class CustomerFailuerHanlder implements AuthenticationFailureHandler {
    private final Logger log = Logger.getLogger(CustomerFailuerHanlder.class.getName());


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("login fail!");
        response.sendRedirect("/fail");
    }
}
