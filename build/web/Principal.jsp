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
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
        <title>Furtgolito - Inicio</title>
    </head>
    <body class="fondo-principal">
        <%@include file = "LoginLogout.jsp" %>
        <%@include file = "Navbar.jsp" %>
        <div class="wrapper">
            <div class="contenedor-principal-novedades">
                <h2>
                    Novedades
                </h2>
                <c:choose>
                    <c:when test="${gestor.cantidadNovedades == 0}">
                        No se han cargado novedades aún.
                    </c:when>
                    <c:otherwise>
                        <table>
                            <tbody>
                                <c:forEach items="${gestor.listadoNovedades}" var="listadoNovedades">
                                    <tr>
                                        <th>
                                            ${listadoNovedades.titulo}
                                        </th>
                                    </tr>
                                    <tr>
                                        <td>
                                            ${listadoNovedades.descripcion}
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="contenedor-principal-tablas">
                <section>
                    <c:choose>
                        <c:when test="${gestor.cantidadEquipos == 0}">
                            <table>
                                <caption>
                                    Posiciones
                                </caption>
                            </table>
                            <p class="texto-lista-vacia">
                                No se han cargado equipos aún.
                            </p>
                        </c:when>
                        <c:otherwise>
                            <table>
                                <caption>
                                    Posiciones
                                </caption>
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
                        </c:otherwise>
                    </c:choose>
                </section>
                <section>
                    <c:choose>
                        <c:when test="${gestor.cantidadGolesTotales == 0}">
                            <table>
                                <caption>
                                    Goleadores
                                </caption>
                            </table>
                            <p class="texto-lista-vacia">
                                No hay registro de goleadores aún.
                            </p>
                        </c:when>
                        <c:otherwise>
                            <table>
                                <caption>
                                    Goleadores
                                </caption>
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
                        </c:otherwise>
                    </c:choose>
                </section>
            </div>
        </div>
        <footer>
            <p>
                Design by Juan Gonzalez | 2021
            </p>
        </footer>
    </body>
</html>
