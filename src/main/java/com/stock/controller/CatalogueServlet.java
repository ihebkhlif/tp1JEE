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

        List<Produit> maListe = service.getCatalogue();

        request.setAttribute("listeProduits", maListe);

        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp").forward(request, response);
    }
}
