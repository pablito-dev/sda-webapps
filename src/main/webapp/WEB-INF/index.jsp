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
<a href="/addProduct">Add new product</a>
<a href="/login">Log in</a>
</body>
</html>
