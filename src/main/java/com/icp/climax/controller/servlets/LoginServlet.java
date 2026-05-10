package com.icp.climax.controller.servlets;


import com.icp.climax.dao.UserDAO;
import com.icp.climax.model.User;
import com.icp.climax.utilities.PasswordUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUser(email);

        //When no user is found
        if(user == null){
            request.setAttribute("error", "Invalid email or password");
            RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
            rd.forward(request, response);
        }
        else{
            String hashedPassword = user.getPassword();
            boolean matched = PasswordUtil.checkPassword(password, hashedPassword);
            // If password matches
            if(matched) {
                //Create session and store user
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", user);
                session.setMaxInactiveInterval(30 * 60);

                if ("true".equals(rememberMe)){
                    Cookie cookie = new Cookie("rememberUser",email);
                    cookie.setMaxAge(30 * 60);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
                else{
                    Cookie cookie = new Cookie("rememberUser","");
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }

                response.sendRedirect(request.getContextPath()+"/home");
            }
            // if password doesnot matches
            else{
                request.setAttribute("error", "Invalid email or password");
                RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
                rd.forward(request, response);
            }
        }

    }
}
