<%@ tag language="java" %>
<%@ attribute name="brandName" required="false" type="java.lang.String" %>
<%@ attribute name="userLoggedIn" required="false" type="java.lang.Boolean" %>

<div class="navbar">
    <div class="navbar-brand">${brandName != null ? brandName : "Spring Insurance"}</div>
    <div class="navbar-links">
        <div class="dropdown">
            <button class="dropdown-toggle">Insurance</button>
            <div class="dropdown-menu">
                <a href="${pageContext.request.contextPath}/insurances/health/create">Health Insurance</a>
                <a href="${pageContext.request.contextPath}/insurances/vehicle/create">Vehicle Insurance</a>
                <a href="${pageContext.request.contextPath}/insurances/home/create">Home Insurance</a>
            </div>
        </div>
        <a href="#">My Insurances</a>
        <c:choose>
            <c:when test="${userLoggedIn}">
                <a href="#">Logout</a>
            </c:when>
            <c:otherwise>
                <a href="#">Login</a>
                <a href="#">Register</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>