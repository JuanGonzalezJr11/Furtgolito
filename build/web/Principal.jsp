<%-- 
    Document   : Principal
    Created on : 9 oct. 2021, 14:08:44
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Furtgolito - Inicio</title>
    </head>
    <body>
        <h1>¡Bienvenidos a Furtgolito!</h1>
        <%@include file = "Navbar.jsp" %>
        <h2>
            Partidos
        </h2>
        <br>
        <h2>
            Novedades
        </h2>
        <table>
            <thead>
                <tr>
                    <th>
                        Título
                    </th>
                    <th>
                        Descripción
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${gestor.listadoNovedades}" var="listadoNovedades">
                    <tr>
                        <td>
                            ${listadoNovedades.titulo}
                        </td>
                        <td>
                            ${listadoNovedades.descripcion}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
