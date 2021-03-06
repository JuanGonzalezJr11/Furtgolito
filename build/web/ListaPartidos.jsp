<%-- 
    Document   : ListaPartidos
    Created on : 22 oct. 2021, 21:25:26
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
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Furtgolito - Listado de partidos</title>
    </head>
    <body class="jornadas-y-partidos">
        <header>
            <%@include file = "LoginLogout.jsp" %>
            <%@include file = "Navbar.jsp" %>
        </header>
        <div class="contenedor-jornadas-y-partidos">
            <h1>
                Jornadas y partidos
            </h1>
            <c:if test="${!empty usuario}">
                <a href="/Furtgolito/AltaPartidoServlet">
                    <button class="nuevo-partido">
                        Nuevo partido
                    </button>
                </a>
                <br>
            </c:if>
            <c:choose>
                <c:when test="${gestor.cantidadPartidos == 0}">
                    <p>
                        No se han cargado partidos aún.
                    </p>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${gestor.listadoJornadas}" var="lj">
                        <table>
                            <caption>
                                Jornada ${lj.jornada}
                            </caption>
                            <thead>
                                <tr>
                                    <th>
                                        Fecha
                                    </th>
                                    <th>
                                        Hora
                                    </th>
                                    <th>
                                        Equipo local
                                    </th>
                                    <th colspan="3">
                                        Resultado
                                    </th>
                                    <th>
                                        Equipo visitante
                                    </th>
                                    <th colspan="7">

                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${gestor.listadoPartidos}" var="lp">
                                    <c:if test="${lj.jornada == lp.jornada}">
                                        <tr>
                                            <td>
                                                ${lp.fecha}
                                            </td>
                                            <td>
                                                ${lp.hora}
                                            </td>
                                            <td>
                                                ${lp.equipoLocal}
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${lp.estado == false}">

                                                    </c:when>
                                                    <c:otherwise>
                                                        ${lp.resultadoEquipoLocal}
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                -
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${lp.estado == false}">

                                                    </c:when>
                                                    <c:otherwise>
                                                        ${lp.resultadoEquipoVisitante}
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                ${lp.equipoVisitante}
                                            </td>
                                            <td>
                                                <a href="/Furtgolito/DetallesPartidoServlet?idPartido=${lp.idPartido}">
                                                    <button class="detalles">
                                                        Detalles
                                                    </button>
                                                </a>
                                            </td>
                                            <c:if test="${!empty usuario}">
                                                <td>
                                                    <a href="/Furtgolito/ModificarPartidoServlet?idPartido=${lp.idPartido}">
                                                        <button class="modificar">
                                                            Modificar
                                                        </button>
                                                    </a>
                                                </td>
                                                <c:choose>
                                                    <c:when test="${lp.estado == false}">
                                                        <td>
                                                            <a href="/Furtgolito/EliminarPartidoServlet?idPartido=${lp.idPartido}">
                                                                <button class="eliminar">
                                                                    Eliminar
                                                                </button>
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a href="/Furtgolito/ResultadoPartidoServlet?idPartido=${lp.idPartido}">
                                                                <button class="resultado">
                                                                    Resultado
                                                                </button>
                                                            </a>
                                                        </td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>
                                                            <a href="/Furtgolito/LimpiarPartidoServlet?idPartido=${lp.idPartido}">
                                                                <button class="limpiar">
                                                                    Limpiar
                                                                </button>
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a href="/Furtgolito/ResultadoPartidoServlet?idPartido=${lp.idPartido}">
                                                                <button class="resultado">
                                                                    Resultado
                                                                </button>
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a href="/Furtgolito/CargarDetallesResultadoPartidoServlet?idPartido=${lp.idPartido}">
                                                                <button class="cargar-detalles">
                                                                    Cargar detalles
                                                                </button>
                                                            </a>
                                                        </td>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:if>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
        <footer>
            <p>
                Design by Juan Gonzalez | 2021
            </p>
        </footer>
    </body>
</html>
