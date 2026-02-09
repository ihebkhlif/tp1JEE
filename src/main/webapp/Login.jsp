<!DOCTYPE html>
<html>
<head><title>Login StockMaster Pro</title></head>
<body>
<h2>Connexion</h2>
<form method="POST" action="${pageContext.request.contextPath}/connexion">
    Login: <input type="text" name="login"><br>
    Mot de passe: <input type="password" name="pass"><br>
    <input type="submit" value="Se connecter">
</form>
</body>
</html>
