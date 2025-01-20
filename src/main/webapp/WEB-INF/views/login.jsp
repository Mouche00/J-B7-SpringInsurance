<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<t:navbar brandName="Spring Insurance" userLoggedIn="${sessionScope.user != null}" />
<div class="form-wrapper">
    <div class="login-container">
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <label for="email">Email:</label>
            <input type="text" name="email" required />
            <label for="password">Password:</label>
            <input type="password" name="password" required />
            <button type="submit">Login</button>
        </form>
    </div>
</div>
</body>
</html>