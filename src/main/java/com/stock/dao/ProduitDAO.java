package com.stock.dao;
import com.stock.model.Produit;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {
    public List<Produit> findAll() {
        List<Produit> mockList = new ArrayList<>();
        mockList.add(new Produit(1, "Clavier", 45.0));
        mockList.add(new Produit(2, "Souris", 25.0));
        mockList.add(new Produit(3, "Ecran", 150.0));
        return mockList;
    }
}
