package com.stock.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        if ("admin".equals(login) && "123".equals(pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", "admin");
            response.sendRedirect(request.getContextPath() + "/catalogue");
        } else {
            response.sendRedirect("Login.jsp");
        }
    }

}
