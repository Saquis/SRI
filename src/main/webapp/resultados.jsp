<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Resultado de la Consulta</title>
</head>
<body>
<h1>Información del Contribuyente</h1>
<p>Nombre: ${rucInfo.nombre}</p>
<p>Actividad Económica: ${rucInfo.actividadEconomica}</p>
<p>Estado: ${rucInfo.estado}</p>
<p>Dirección: ${rucInfo.direccion}</p>
</body>
</html>
