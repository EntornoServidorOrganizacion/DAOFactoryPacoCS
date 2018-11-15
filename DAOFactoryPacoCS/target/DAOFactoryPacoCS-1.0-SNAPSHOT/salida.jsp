<%-- 
    Document   : salida
    Created on : 14 nov. 2018, 17:00:52
    Author     : paco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/normalizer.css">
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css">
        <title>AVE</title>
    </head>
    <body>
        <p>Este es el ave seleccionada</p>
        <c:forEach var="ave" items="${avistamiento}">
        Anilla: ${ave.anilla} | Especie: ${ave.especie} | Lugar: ${ave.lugar} | Fecha: ${ave.fecha}</br>
        </c:forEach>

        <c:url var="index" value="/index.jsp"/>
        <a href="${index}">Menú</a>
    </body>
</html>
