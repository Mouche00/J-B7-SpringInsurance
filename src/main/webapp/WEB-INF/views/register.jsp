<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:navbar brandName="Spring Insurance" userLoggedIn="${sessionScope.user != null}" />

<!DOCTYPE html>
<html>
<head>
  <title>Register</title>
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<t:navbar brandName="Spring Insurance" userLoggedIn="${sessionScope.user != null}" />
<div class="form-wrapper">
  <div class="registration-container">
    <h2>Register</h2>
    <form:form cssClass="regitration-form" action="${pageContext.request.contextPath}/register" modelAttribute="user" method="post">
      <div>
        <label>Name:</label>
        <form:input path="name" />
        <form:errors path="name" cssClass="error" />
      </div>
      <div>
        <label>Email:</label>
        <form:input path="email" />
        <form:errors path="email" cssClass="error" />
      </div>
      <div>
        <label>Password:</label>
        <form:password path="password" />
        <form:errors path="password" cssClass="error" />
      </div>
      <div>
        <label>Age:</label>
        <form:input path="age" type="number" />
        <form:errors path="age" cssClass="error" />
      </div>
      <div>
        <label>Phone:</label>
        <form:input path="phone" />
        <form:errors path="phone" cssClass="error" />
      </div>
      <div>
        <label>Address:</label>
        <form:input path="address" />
        <form:errors path="address" cssClass="error" />
      </div>
      <button type="submit">Register</button>
    </form:form>
  </div>
</div>
</body>
</html>