package com.stock.service.impl;

import com.stock.dao.IProduitDAO;
import com.stock.dao.impl.ProduitDAOImpl;
import com.stock.model.Produit;
import com.stock.service.IStockService;

import java.util.List;

public class StockServiceImpl implements IStockService {
    // Le service possède une instance de l'interface DAO
    private IProduitDAO dao = new ProduitDAOImpl();

    @Override
    public List<Produit> recupererCatalogueFiltre() {
    // Logique métier : par exemple, ne retourner que les produits en stock
        return dao.findAll();
    }
}
