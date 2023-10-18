package com.resourcium1.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TaskController", value = "/tasks")
public class TaskController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Message From TaskController";

        // Set the data as a request attribute
        request.setAttribute("message", message);

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/page.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
