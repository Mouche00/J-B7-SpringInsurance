<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
  <title>${homeInsurance.id == null ? 'Create Home Insurance' : 'Edit Home Insurance'}</title>
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<t:navbar brandName="Spring Insurance" userLoggedIn="${sessionScope.user != null}" />
<div class="form-wrapper">
  <div class="insurance">

    <h1>${homeInsurance.id == null ? 'Create New Home Insurance' : 'Edit Home Insurance'}</h1>

    <form:form action="${pageContext.request.contextPath}/insurances/home/${homeInsurance.id == null ? 'create' : 'edit/'.concat(homeInsurance.id)}"
               modelAttribute="homeInsurance" method="post">

      <!-- Display errors if any -->
      <c:if test="${not empty errors}">
        <div style="color:red">
          <c:forEach var="error" items="${errors.allErrors}">
            <p>${error.defaultMessage}</p>
          </c:forEach>
        </div>
      </c:if>

      <!-- Form fields -->
      <label>Asset Type:</label>
      <form:input path="assetType" />
      <br/>

      <label>Risk Factor:</label>
      <form:checkbox path="riskFactor" />
      <br/>

      <label>Validated At:</label>
      <form:input path="validatedAt" type="date" />
      <br/>

      <label>Asset Value:</label>
      <form:input path="assetValue" type="number" step="0.01" />
      <br/>

      <label>Security Type:</label>
      <form:select path="securityType">
        <c:forEach var="securityType" items="${securityTypes}">
          <form:option value="${securityType}">${securityType}</form:option>
        </c:forEach>
      </form:select>
      <br/>

      <!-- Submit button -->
      <button type="submit">${homeInsurance.id == null ? 'Save' : 'Update'}</button>
    </form:form>

  </div>
</div>
</body>
</html>