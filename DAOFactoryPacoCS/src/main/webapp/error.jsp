<%-- 
    Document   : error
    Created on : 14 nov. 2018, 17:00:15
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
        <title>Error</title>
    </head>
    <body>
        <c:set var="error" value='${error}'/>
        <h1>ERROR: </h1><p>${error}</p>
        <br><br>
        <c:url var="index" value="/index.jsp"/>
        <a href="${index}">Menú</a>
    </body>
</html>
