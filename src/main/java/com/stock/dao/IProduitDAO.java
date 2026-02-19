package com.stock.dao;

import java.util.List;
import com.stock.model.Produit;

public interface IProduitDAO {
    List<Produit> findAll();
    void add(Produit p);
}
