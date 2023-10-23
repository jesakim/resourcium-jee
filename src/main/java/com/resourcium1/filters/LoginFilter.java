package com.resourcium1.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/dashboard","/me","/logout"}) // Define the URL pattern to filter
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Check if the user is authenticated (add your authentication logic here)
        // For example, you could check if the user is in a session
        // You might want to use a session attribute set during login

        // Example: Check if a session attribute 'user' exists
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpSession session = httpRequest.getSession(false); // false means don't create a new session

            if (session == null || session.getAttribute("user") == null) {
                // User is not authenticated, redirect or display an error
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.sendRedirect("index.jsp");
                return;
            }
        }
        // If the user is authenticated, continue with the request
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}

