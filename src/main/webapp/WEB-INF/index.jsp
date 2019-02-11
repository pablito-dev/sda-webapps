<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Online shop</h2>
<c:forEach items="${products}" var="product">
    <jsp:include page="/WEB-INF/product.jsp">
        <jsp:param name="name" value="${product.name}"/>
        <jsp:param name="description" value="${product.description}"/>
        <jsp:param name="price" value="${product.price}"/>
        <jsp:param name="category" value="${product.category}"/>
    </jsp:include>
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
