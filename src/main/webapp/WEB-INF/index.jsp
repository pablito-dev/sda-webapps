<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>My blog</h2>
<c:forEach items="${articles}" var="article">
    <tr>
        <td>${article.title}</td>
        <td>${article.text}</td>
    </tr>
</c:forEach>
<a href="/addArticle">Add new post</a>
</body>
</html>
