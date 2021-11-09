<%-- 
    Document   : TablaGoleadores
    Created on : 4 nov. 2021, 21:46:15
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla de goleadores</title>
    </head>
    <body>
        <h1>
            Tabla de goleadores
        </h1>
        <table>
            <thead>
                <tr>
                    <th>
                        Jugador
                    </th>
                    <th>
                        Equipo
                    </th>
                    <th>
                        Goles
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${gestor.tablaGoleadores}" var="g">
                    <tr>
                        <td>
                            ${g.nombre} ${g.apellido}
                        </td>
                        <td>
                            ${g.nombreEquipo}
                        </td>
                        <td>
                            ${g.cantidadGoles}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
