package com.backend.formlogin.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * 로그인 성공했을시 취해야할 행동들.
 * response 객체를 사용하여 여러 행동들을 해줄수도 있다.
 * TODO ?? session에도 set 해줄수 있는거 아닌가?
 * TODO 로그인 성공한 사람들에게만 권한을 줄 수 있게 setting 할수 있을것 같다..? 여기서 메뉴판을 조정?
 */

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    private final Logger log = Logger.getLogger(CustomSuccessHandler.class.getName());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        HttpSession session = request.getSession();
//        session.setAttribute("username", authentication.getName());
        log.info("Login SuccessHandler");
        log.info("Username: " + authentication.getName());

        response.sendRedirect("/");
    }
}
