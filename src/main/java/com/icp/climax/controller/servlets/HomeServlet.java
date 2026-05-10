package com.icp.climax.controller.servlets;

import com.icp.climax.dao.UserDAO;
import com.icp.climax.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet (name="HomeServlet", urlPatterns="/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Check if user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if("rememberUser".equals(cookie.getName())) {
                        String email = cookie.getValue();
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.getUser(email);

                        if (user != null) {
                            HttpSession newSession = request.getSession();
                            newSession.setAttribute("loggedInUser", user);
                            newSession.setMaxInactiveInterval(30 * 60);
                            break;
                        }
                    }
                }
            }
            HttpSession updateSession = request.getSession(false);
            if (updateSession == null || updateSession.getAttribute("loggedInUser") == null) {
                response.sendRedirect(request.getContextPath()+"/login");
                return;
            }

        }


        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
