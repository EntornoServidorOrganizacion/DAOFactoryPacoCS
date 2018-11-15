<%-- 
    Document   : entrada
    Created on : 14 nov. 2018, 17:00:38
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
        <title>Busque el ave que desea</title>
    </head>
    <body>
        <form action="ControladorDatosSalida" method="post">

            <label>Introduce una anilla</label><input name="anilla" maxlength="3"/>
            <br>

            <button type="submit" name="anillaboton" value="buscar"/>Buscar
        </form>
    </body>
</html>
