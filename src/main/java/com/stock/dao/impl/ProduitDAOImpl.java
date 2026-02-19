package com.stock.dao.impl;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.IProduitDAO;
import com.stock.model.Produit;


public class ProduitDAOImpl implements IProduitDAO {
    @Override
    public List<Produit> findAll() {
        List<Produit> mockList = new ArrayList<>();
        mockList.add(new Produit(1, "Clavier", 45.0));
        mockList.add(new Produit(2, "Souris", 25.0));
        mockList.add(new Produit(3, "Ecran", 150.0));
        return mockList;
    }
    @Override
    public void add(Produit p) {}
}
