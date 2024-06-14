package com.jee.web;

import com.jee.beans.User;
import com.jee.business.Facade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginAction extends Action {

    private static final int MAX_LOGIN_ATTEMPTS = 3;

    public LoginAction(Facade facade) {
        super(facade);
    }
    
    @Override
    String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String username = req.getParameter("username");
            String pass = req.getParameter("pass");

            boolean authenticated = false;
            User authenticatedUser = null;

            for (User us : facade.listerUsers()) {
                if (us.getUsername().equals(username) && us.getPassword().equals(pass)) {
                    authenticated = true;
                    authenticatedUser = us;
                    break;
                }
            }

            if (authenticated) {
                if (authenticatedUser.getType().equals("admin")) {
                    req.setAttribute("ld", facade.listerDocs(""));
                    return "/views/MainAdmin.jsp";
                } else if (authenticatedUser.getType().equals("user")) {
                    req.setAttribute("ld", facade.listerDocs(authenticatedUser.getUsername()));
                    req.setAttribute("username", authenticatedUser.getUsername());
                    return "/views/MainUsers.jsp";
                }
            } else {
                System.out.println("Login failed!");
                int loginAttempts = 1;

                if (req.getSession().getAttribute("loginAttempts") != null) {
                    loginAttempts = (int) req.getSession().getAttribute("loginAttempts") + 1;
                }
                req.getSession().setAttribute("loginAttempts", loginAttempts);

                if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                    return "/views/accountLocked.jsp";
                } else {
                    req.setAttribute("invalidLogin", true);
                    return "/views/loginResult.jsp";
                }
            }
            return "Not Executed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
