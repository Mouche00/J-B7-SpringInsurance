<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.insurance.utils.reflection.ReflectionUtils" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Insurances</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <style>


        h1 {
            color: #333;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin-top: 2rem;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            text-align: left;
            padding: 1rem;
        }
        th {
            background-color: #d5d5d5;
            font-weight: 600;
        }
        tr {
            background-color: #f3f3f3;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        a {
            color: #007bff;
            text-decoration: none;
            margin-right: 1rem;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<t:navbar brandName="Spring Insurance" userLoggedIn="${sessionScope.user != null}" />

<h1 class="centered">Insurances</h1>
<div class="form-wrapper">
<%--<a href="${pageContext.request.contextPath}/insurances/home/create">Add Home Insurance</a>--%>
<%--<a href="${pageContext.request.contextPath}/insurances/health/create">Add Health Insurance</a>--%>
<%--<a href="${pageContext.request.contextPath}/insurances/vehicle/create">Add Vehicle Insurance</a>--%>

<table border="1">
    <tr>
<%--        <th>ID</th>--%>
        <th>Type</th>
        <th>Asset Type</th>
        <th>Risk Factor</th>
        <th>Additional Info</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="insurance" items="${insurances}">
        <tr>
<%--            <td>${insurance.id}</td>--%>
            <td>${ReflectionUtils.getClassName(insurance)}</td>
            <td>${insurance.assetType}</td>
            <td>${insurance.riskFactor}</td>
            <td>
                <c:choose>
                    <c:when test="${ReflectionUtils.getClassName(insurance) == 'HomeInsurance'}">
                        Value: ${insurance.assetValue}, Security: ${insurance.securityType}
                    </c:when>
                    <c:when test="${ReflectionUtils.getClassName(insurance) == 'HealthInsurance'}">
                        N/A
                    </c:when>
                    <c:when test="${ReflectionUtils.getClassName(insurance) == 'VehicleInsurance'}">
                        Usage Type: ${insurance.usageType}, Model: ${insurance.vehicleModel}
                    </c:when>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${ReflectionUtils.getClassName(insurance) == 'HomeInsurance'}">
                        <a href="${pageContext.request.contextPath}/insurances/home/edit/${insurance.id}">Edit</a>
                    </c:when>
                    <c:when test="${ReflectionUtils.getClassName(insurance) == 'HealthInsurance'}">
                        <a href="${pageContext.request.contextPath}/insurances/health/edit/${insurance.id}">Edit</a>
                    </c:when>
                    <c:when test="${ReflectionUtils.getClassName(insurance) == 'VehicleInsurance'}">
                        <a href="${pageContext.request.contextPath}/insurances/vehicle/edit/${insurance.id}">Edit</a>
                    </c:when>
                </c:choose>
                <a href="${pageContext.request.contextPath}/insurances/delete/${insurance.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
