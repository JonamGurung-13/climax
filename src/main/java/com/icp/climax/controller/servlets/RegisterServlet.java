package com.icp.climax.controller.servlets;

import com.icp.climax.dao.UserDAO;
import com.icp.climax.utilities.PasswordUtil;
import com.icp.climax.utilities.ValidationUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet (name="RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        //Get its values from the client
        final String name = request.getParameter("name");
        final String username = request.getParameter("username");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String cfPassword = request.getParameter("cfPassword");

        //Validation for each inputs
        //name
        final boolean isValidName = !ValidationUtil.isNullOrEmpty(name)
                && ValidationUtil.isAlphabetic(name) && name.length()>5;
        System.out.println(isValidName);
        String errorName = isValidName? "" : "Name is not Proper!";

        //username
        final boolean isValidUsername = !ValidationUtil.isNullOrEmpty(username)
                && ValidationUtil.isAlphanumericStartingWithLetter(username)
                && username.length()>5;
        String errorUsername = isValidUsername? "" : "Username is not Proper!";

        //email
        final boolean isValidMail = ValidationUtil.isValidEmail(email);
        String errorMail = isValidMail? "" : "Email is not Proper!";

        //password
        final boolean isValidPassword = ValidationUtil.isValidPassword(password);
        String errorPassword = isValidPassword? "" : "Password is not Proper!";

        //confirm password
        final boolean isValidCfPassword = ValidationUtil.doPasswordsMatch(password, cfPassword);
        String errorCfPassword = isValidCfPassword? "" : "Password does not match!";

        String error = errorName + errorUsername + errorMail + errorPassword + errorCfPassword;
        request.setAttribute("error", error);
        request.setAttribute("erName",errorName);
        request.setAttribute("erUsername",errorUsername);
        request.setAttribute("erEmail",errorMail);
        request.setAttribute("erPassword",errorPassword);
        request.setAttribute("erCfPassword",errorCfPassword);


        //if error in user data provide feedback to same page
        if(!error.isBlank()) {
            RequestDispatcher rd = request.getRequestDispatcher("/pages/register.jsp");
            rd.forward(request,response);
        }
        else{
            //hashed password before storing
            String hashedPassword = PasswordUtil.getHashPassword(password);

            //create user entry on database users table
            final UserDAO  userDAO = new UserDAO();
            int check = userDAO.insertUser(name,username,email,hashedPassword);
            switch (check) {
                case 1: //Case of successful login
                    response.sendRedirect(request.getContextPath()+"/login"); //redirect to login page
                    break;

                case 2:
                        request.setAttribute("error", "Username/Email Already Exists");
                        RequestDispatcher rd = request.getRequestDispatcher("/pages/register.jsp");
                        rd.forward(request,response);
                        break;

                default:
                    System.out.println("Server error: " + check + ": error code");
                    break;
            }
        }

    }
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
    }
}
