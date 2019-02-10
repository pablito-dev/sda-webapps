<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add article</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addArticle" method="post">
    <p>Title
        <input type="text" name="title"/>
    </p>
    <p>Text
        <textarea name="text"></textarea>
    </p>
    <p>Submit
        <input type="submit" name="submit" value="submit"/>
    </p>
</form>
</body>
</html>
