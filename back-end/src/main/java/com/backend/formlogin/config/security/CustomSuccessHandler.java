package com.backend.formlogin.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    private Logger log = Logger.getLogger(CustomSuccessHandler.class.getName());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("login success!!!" + authentication.getName());
        response.sendRedirect("/login");
    }
}
