package com.resourcium1.controllers;

import com.resourcium1.dao.UserDao;
import com.resourcium1.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProfileController", value = "/me")
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "changeinfo":
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                User user = (User) request.getSession().getAttribute("user");
                user.setUsername(username);
                user.setEmail(email);
                UserDao.update(user);
                break;
            case "changepassword":
                String oldPassword = request.getParameter("oldpassword");
                String newPassword = request.getParameter("newpassword");
                String confirmPassword = request.getParameter("confirmpassword");
                User user1 = (User) request.getSession().getAttribute("user");
                if (user1.getPassword().equals(oldPassword) && newPassword.equals(confirmPassword)) {
                    user1.setPassword(newPassword);
                    UserDao.update(user1);
                }
                break;
            default:
                response.sendRedirect("me");
        }
        response.sendRedirect("me");

    }
}