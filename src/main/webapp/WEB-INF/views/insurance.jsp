<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insurances</title>
</head>
<body>
<h1>Insurances</h1>
<a href="${pageContext.request.contextPath}/insurances/create?type=home">Add Home Insurance</a>
<a href="${pageContext.request.contextPath}/insurances/create?type=health">Add Health Insurance</a>
<a href="${pageContext.request.contextPath}/insurances/create?type=vehicle">Add Vehicle Insurance</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Asset Type</th>
        <th>Risk Factor</th>
        <th>Additional Info</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="insurance" items="${insurances}">
        <tr>
            <td>${insurance.id}</td>
            <td>${insurance.class.simpleName}</td>
            <td>${insurance.assetType}</td>
            <td>${insurance.riskFactor}</td>
            <td>
                <c:choose>
                    <c:when test="${insurance instanceof com.yourpackage.HomeInsurance}">
                        Value: ${insurance.assetValue}, Security: ${insurance.securtiyType}
                    </c:when>
                    <c:when test="${insurance instanceof com.yourpackage.HealthInsurance}">
                        Coverage: ${insurance.coverage}, Provider: ${insurance.provider}
                    </c:when>
                    <c:when test="${insurance instanceof com.yourpackage.VehicleInsurance}">
                        Vehicle Type: ${insurance.vehicleType}, Model: ${insurance.model}
                    </c:when>
                </c:choose>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/insurances/edit/${insurance.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/insurances/delete/${insurance.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
