<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Online shop</h2>
<a href="${pageContext.request.contextPath}/addProduct">Add new product</a>
<% if (session.getAttribute("user") == null) { %>
<a href="${pageContext.request.contextPath}/login">Log in</a>
<% } else {%>
<p>Logged as ${sessionScope["user"]["userName"]}</p>
<a href="${pageContext.request.contextPath}/logout">Log out</a>
<% } %>
<div>
    <c:forEach items="${products}" var="product">
        <jsp:include page="/WEB-INF/product.jsp">
            <jsp:param name="name" value="${product.name}"/>
            <jsp:param name="description" value="${product.description}"/>
            <jsp:param name="price" value="${product.price}"/>
            <jsp:param name="category" value="${product.category}"/>
            <jsp:param name="id" value="${product.id}"/>
        </jsp:include>
    </c:forEach>
</div>
<div>
    <c:choose>
        <c:when test="${lastViewed != null}">
            <p>Last viewed:</p>
            <jsp:include page="/WEB-INF/product.jsp">
                <jsp:param name="name" value="${lastViewed.name}"/>
                <jsp:param name="description" value="${lastViewed.description}"/>
                <jsp:param name="price" value="${lastViewed.price}"/>
                <jsp:param name="category" value="${lastViewed.category}"/>
                <jsp:param name="id" value="${lastViewed.id}"/>
            </jsp:include>
        </c:when>
    </c:choose>
</div>
</body>
</html>
