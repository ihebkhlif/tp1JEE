package com.stock.service;

import com.stock.dao.ProduitDAO;
import com.stock.model.Produit;

import java.util.List;

public class ProduitService {
    private ProduitDAO dao = new ProduitDAO();

    public List<Produit> getCatalogue() {
        // Here you could add logic (e.g., filtering or tax calculation)
        return dao.findAll();
    }
}
