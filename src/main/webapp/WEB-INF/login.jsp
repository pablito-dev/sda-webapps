<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <p>Username
        <input type="text" name="username"/>
    </p>
    <p>Password
        <input type="password" name="password"/>
    </p>
    <p>Log in
        <input type="submit" name="submit" value="submit"/>
    </p>
</form>
</body>
</html>
