<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultados del RUC</title>
</head>
<body>
<h1>Resultados del RUC</h1>

<%-- Mostrar error, si existe --%>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<%-- Mostrar estado, si existe --%>
<c:if test="${not empty estado}">
    <p>Estado: ${estado}</p>
</c:if>

<%-- Mostrar comprobantes, si existen --%>
<c:if test="${not empty comprobantes}">
    <h2>Comprobantes:</h2>
    <ul>
        <c:forEach var="comprobante" items="${comprobantes}">
            <li>${comprobante}</li>
        </c:forEach>
    </ul>
</c:if>

<%-- Log de depuración en caso de valores vacíos --%>
<c:if test="${empty estado}">
    <p>No se recibió un estado desde el servicio.</p>
</c:if>
<c:if test="${empty comprobantes}">
    <p>No se recibieron comprobantes desde el servicio.</p>
</c:if>
</body>
</html>




