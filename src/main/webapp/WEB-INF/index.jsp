<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Online shop</h2>
<c:forEach items="${products}" var="product">
    <tr>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.price}</td>
    </tr>
</c:forEach>
<a href="${pageContext.request.contextPath}/addProduct">Add new product</a>
<% if (session.getAttribute("user") == null) { %>
    <a href="${pageContext.request.contextPath}/login">Log in</a>
<% } else {%>
    <p>Logged as ${sessionScope["user"]["userName"]}</p>
    <a href="${pageContext.request.contextPath}/logout">Log out</a>
<% } %>
</body>
</html>
