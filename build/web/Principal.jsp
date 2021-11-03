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
        <div>
            HACER QUE LOS EQUIPOS SE CREEN CON PUNTAJE DE 0.
            <h2>
                Posiciones
            </h2>
            <table>
                <thead>
                    <tr>
                        <th>
                            Posición
                        </th>
                        <th>
                            Equipo
                        </th>
                        <th>
                            Puntos
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${gestor.posicionesEquiposTOP3}" var="e">
                        <tr>
                            <td>
                                ${e.posicion}
                            </td>
                            <td>
                                ${e.nombre}
                            </td>
                            <td>
                                ${e.puntos}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <h2>
                Goleadores
            </h2>
            <table>
                <thead>
                    <tr>
                        <th>
                            Nombre
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
                    <c:forEach items="${gestor.tablaGoleadoresTOP3}" var="g">
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
        </div>
        <div>
            <h2>
                Próxima jornada
            </h2>
        </div>
        <br>
        <div>
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
        </div>
    </body>
</html>
