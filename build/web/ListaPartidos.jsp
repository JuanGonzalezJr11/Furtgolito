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
        <title>Listado de partidos</title>
    </head>
    <body>
        <%@include file = "Navbar.jsp" %>
        <br>
        <a href="/Furtgolito/AltaPartidoServlet">
            <button>
                Nuevo partido
            </button>
        </a>
        <br>
        <h1>
            Jornadas y partidos
        </h1>
        <c:forEach items="${gestor.listadoJornadas}" var="lj">
            <h2>
                Jornada ${lj.jornada}
            </h2>
            <table>
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
                                        <button>
                                            Detalles
                                        </button>
                                    </a>
                                </td>
                                <td>
                                    <a href="/Furtgolito/ModificarPartidoServlet?idPartido=${lp.idPartido}">
                                        <button>
                                            Modificar
                                        </button>
                                    </a>
                                </td>
                                <c:choose>
                                    <c:when test="${lp.estado == false}">
                                        <td>
                                            <a href="/Furtgolito/EliminarPartidoServlet?idPartido=${lp.idPartido}">
                                                <button>
                                                    Eliminar
                                                </button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="/Furtgolito/ResultadoPartidoServlet?idPartido=${lp.idPartido}">
                                                <button>
                                                    Resultado
                                                </button>
                                            </a>
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>
                                            <a href="/Furtgolito/LimpiarPartidoServlet?idPartido=${lp.idPartido}">
                                                <button>
                                                    Limpiar
                                                </button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="/Furtgolito/ResultadoPartidoServlet?idPartido=${lp.idPartido}">
                                                <button>
                                                    Resultado
                                                </button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="/Furtgolito/AltaGolServlet?idPartido=${lp.idPartido}">
                                                <button>
                                                    Goles
                                                </button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="/Furtgolito/AltaTarjetaAmarillaServlet?idPartido=${lp.idPartido}">
                                                <button>
                                                    Tarjetas amarillas
                                                </button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="/Furtgolito/AltaTarjetaRojaServlet?idPartido=${lp.idPartido}">
                                                <button>
                                                    Tarjetas rojas
                                                </button>
                                            </a>
                                        </td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </c:forEach>
    </body>
</html>
