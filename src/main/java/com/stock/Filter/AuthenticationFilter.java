package com.stock.Filter;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    private static final String USER_SESSION_KEY = "user";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getRequestURI();
        String contextPath = req.getContextPath();

        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute(USER_SESSION_KEY) != null);

        boolean loginPage = path.endsWith("Login.jsp");
        boolean loginServlet = path.endsWith("/connexion");

        // Allow login page + login servlet
        if (loginPage || loginServlet) {
            if (loggedIn) {
                // if Logged in
                resp.sendRedirect(req.getContextPath() + "/");
                return;
            }
            chain.doFilter(request, response);
            return;
        }
        if (path.equals(req.getContextPath() + "/")) {
            chain.doFilter(request, response);
            return;
        }
        // Block protected pages
        if (!loggedIn) {
            resp.sendRedirect(contextPath + "/Login.jsp");
            return;
        }

        chain.doFilter(request, response);
    }
}
