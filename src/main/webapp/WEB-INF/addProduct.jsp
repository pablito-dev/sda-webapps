<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add article</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addProduct" method="post">
    <p>Title
        <input type="text" name="name"/>
    </p>
    <p>Price
        <input type="text" name="price"/>
    </p>
    <p>Description
        <textarea name="description"></textarea>
    </p>
    <p>Category
        <input type="text" name="category"/>
    </p>
    <p>Submit
        <input type="submit" name="submit" value="submit"/>
    </p>
</form>
</body>
</html>
