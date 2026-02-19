<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="catalogue">catalogue</a>
<br></br>
<!--  To protect login and prevent redirects after logging in  -->
<c:if test="${empty sessionScope.user}">
    <a href="Login.jsp">login</a>
</c:if>

</body>
</html>