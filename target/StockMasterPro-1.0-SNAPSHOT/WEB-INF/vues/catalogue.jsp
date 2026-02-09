<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Catalogue des Produits</title>
</head>
<body>
<h2>Utilisateur connecté : ${sessionScope.user}</h2>
<h2>Liste des Produits</h2>

<table border="1">
  <tr>
    <th>ID</th>
    <th>Nom</th>
    <th>Prix</th>
  </tr>

  <c:forEach var="produit" items="${listeProduits}">
    <tr>
      <td>${produit.id}</td>
      <td>${produit.nom}</td>
      <td>${produit.prix} DT</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
