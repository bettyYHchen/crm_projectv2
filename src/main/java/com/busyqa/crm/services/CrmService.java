package com.busyqa.crm.services;

import com.busyqa.crm.pojo.LoginForm;
import com.busyqa.crm.pojo.UserLoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CrmService {

    @Autowired
    AuthenticationManager authenticationManager;

    public UserLoginStatus login(LoginForm loginRequest, HttpSession session) {
        UserLoginStatus userLoginStatus = new UserLoginStatus();

        if (session.getAttribute("id") != null &&
                session.getAttribute("login") != null &&
                (boolean) session.getAttribute("login")) {
            userLoginStatus.setLogin(true);
            System.out.println("LOGIN already");
        } else {
            System.out.println("not Login yet");

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            if (userDetails != null) {
                session.setAttribute("id", session.getId());
                session.setAttribute("login", true);
                userLoginStatus.setLogin(true);
                System.out.println(" LOGIN");
            }
            else {
                session.setAttribute("login", false);
                userLoginStatus.setLogin(false);
                System.out.println(" LOGIN FAIL: username & password not match");
            }

        }

        return userLoginStatus;
    }

    public UserLoginStatus checkLoginSessionStatus(HttpSession session) {
        UserLoginStatus userLoginStatus = new UserLoginStatus();

        if (session.getAttribute("id") != null && session.getAttribute("login") != null && (boolean) session.getAttribute("login")) {
            userLoginStatus.setLogin(true);
        } else {
            userLoginStatus.setLogin(false);
        }
        return userLoginStatus;

    }
}
