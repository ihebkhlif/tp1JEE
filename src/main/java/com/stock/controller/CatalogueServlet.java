package com.stock.controller;

import com.stock.model.Produit;
import com.stock.service.IStockService;
import com.stock.service.ProduitService;
import com.stock.service.impl.StockServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "catalogue", value ="/catalogue")


public class CatalogueServlet extends HttpServlet {
    private IStockService service = new StockServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Call Service (which calls DAO)
        List<Produit> maListe = service.recupererCatalogueFiltre();

        // 2. Put data in the request "envelope"
        request.setAttribute("listeProduits", maListe);

        // Partie 4
        // 1. LECTURE cookie lastVisit
        String lastVisit = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("lastVisit".equals(cookie.getName())) {
                    lastVisit = cookie.getValue();
                    break;
                }
            }
        }
        request.setAttribute("lastVisit", lastVisit);

        // 2. ÉCRITURE cookie (24h)
        Cookie visitCookie = new Cookie("lastVisit", java.time.LocalDateTime.now().toString());
        visitCookie.setMaxAge(24 * 60 * 60);  // 24h
        response.addCookie(visitCookie);

        // 3. Forward to the protected JSP
        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp").forward(request, response);
    }
}
