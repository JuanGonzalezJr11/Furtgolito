<%-- 
    Document   : VerEquipo
    Created on : 24 oct. 2021, 14:36:23
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver equipo</title>
    </head>
    <body>
        <%@include file = "Navbar.jsp" %>
        <br>
        <h1>
            ${equipo.nombre}
        </h1>
        <table>
            <thead>
                <tr>
                    <th>
                        Puntos
                    </th>
                    <th>
                        Partidos jugados
                    </th>
                    <th>
                        Partidos ganados
                    </th>
                    <th>
                        Partidos empatados
                    </th>
                    <th>
                        Partidos perdidos
                    </th>
                    <th>
                        Goles a favor
                    </th>
                    <th>
                        Goles en contra
                    </th>
                    <th>
                        Diferencia de goles
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${equipo.puntos}
                    </td>
                    <td>
                        ${equipo.partidosJugados}
                    </td>
                    <td>
                        ${equipo.partidosGanados}
                    </td>
                    <td>
                        ${equipo.partidosEmpatados}
                    </td>
                    <td>
                        ${equipo.partidosPerdidos}
                    </td>
                    <td>
                        ${equipo.golesFavor}
                    </td>
                    <td>
                        ${equipo.golesContra}
                    </td>
                    <td>
                        ${equipo.diferenciaGoles}
                    </td>
                </tr>
            </tbody>
        </table>
        <h2>
            Lista de jugadores
        </h2>
        <c:choose>
            <c:when test="${cantidadJugadores == 0}">
                Este equipo aún no tiene jugadores.
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                        <tr>
                            <th>
                                Nombre
                            </th>
                            <th>
                                Apellido
                            </th>
                            <th>
                                Edad
                            </th>
                            <th>
                                Posición
                            </th>
                            <th>
                                Dorsal
                            </th>
                            <th>
                                Capitan
                            </th>
                            <th>
                                Suspensión
                            </th>
                            <th>
                                Goles
                            </th>
                            <th>
                                Tarjetas amarillas
                            </th>
                            <th>
                                Tarjetas rojas
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${jugador}" var="j">
                            <tr>
                                <td>
                                    ${j.nombre}
                                </td>
                                <td>
                                    ${j.apellido}
                                </td>
                                <td>
                                    ${j.edad}
                                </td>
                                <td>
                                    ${j.posicionJugador}
                                </td>
                                <td>
                                    ${j.dorsal}
                                </td>
                                <td>
                                    ${j.esCapitan()}
                                </td>
                                <td>
                                    ${j.estaSuspendido()}
                                </td>
                                <td>
                                    ${gestor.cantidadGolesPorJugador(j.idJugador)}
                                </td>
                                <td>
                                    ${gestor.cantidadTarjetasAmarillasPorJugador(j.idJugador)}
                                </td>
                                <td>
                                    ${gestor.cantidadTarjetasRojasPorJugador(j.idJugador)}
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
        <a href="/Furtgolito/ListaEquipos.jsp">
            <button>
                Volver
            </button>
        </a>
    </body>
</html>
