package com.stock.controller;

import com.stock.model.Produit;
import com.stock.service.ProduitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "catalogue", value ="/catalogue")


public class CatalogueServlet extends HttpServlet {
    private ProduitService service = new ProduitService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Call Service (which calls DAO)
        List<Produit> maListe = service.getCatalogue();

        // 2. Put data in the request "envelope"
        request.setAttribute("listeProduits", maListe);

        // 3. Forward to the protected JSP
        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp").forward(request, response);
    }
}
