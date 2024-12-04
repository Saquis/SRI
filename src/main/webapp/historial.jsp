<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Historial de Consultas</title>
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<header>
  <h1>Historial de Consultas</h1>
</header>

<main>
  <!-- Verificar si el historial está vacío -->
  <c:choose>
    <c:when test="${not empty historial}">
      <!-- Mostrar tabla si hay datos en el historial -->
      <table>
        <thead>
        <tr>
          <th>RUC</th>
          <th>Nombre</th>
          <th>Fecha de Consulta</th>
          <th>Estado</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="consulta" items="${historial}">
          <tr>
            <td>${consulta.ruc}</td>
            <td>${consulta.nombre}</td>
            <td>${consulta.fecha}</td>
            <td>${consulta.estado}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </c:when>
    <c:otherwise>
      <!-- Mensaje si no hay datos en el historial -->
      <p>No hay consultas en el historial.</p>
    </c:otherwise>
  </c:choose>

  <a href="index.jsp">Volver al inicio</a>
</main>
</body>
</html>

