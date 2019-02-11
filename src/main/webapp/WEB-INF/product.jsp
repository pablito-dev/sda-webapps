<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>

<body>
<c:choose>
    <c:when test="${product != null}">
        <p>${product.name}</p>
        <p>${product.description}</p>
        <p>Price: ${product.price}</p>
        <p>Category: ${product.category}</p>
    </c:when>
    <c:otherwise>
        <p>${param.name}</p>
        <p>${param.description}</p>
        <p>Price: ${param.price}</p>
        <p>Category: ${param.category}</p>
    </c:otherwise>
</c:choose>
</body>
</html>
