package com.stock.dao.impl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.IProduitDAO;
import com.stock.model.Produit;


public class ProduitDAOImpl implements IProduitDAO {
    // Partie 5
    private static final String URL = "jdbc:mysql://localhost:3306/stockmaster?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "local_user";
    private static final String PASS = "z6EyNk8Q3xlkyR6gQ4nU";

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return produits; // Liste vide si driver manquant
        }
        String sql = "SELECT id, nom, prix FROM produits";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrix(rs.getDouble("prix"));
                produits.add(p);
            }
        } catch (SQLException e) {
            System.err.println("ERREUR DB: " + e.getMessage());
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public void add(Produit p) { }
}
