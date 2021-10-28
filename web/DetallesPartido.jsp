<%-- 
    Document   : DetallesPartido
    Created on : 24 oct. 2021, 11:59:26
    Author     : JuanG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles partido</title>
    </head>
    <body>
        <h1>
            Jornada: ${partido.jornada} - ${partido.equipoLocal} vs. ${partido.equipoVisitante}
        </h1>
        <div>
            <table>
                <thead>
                <th colspan="2">
                    Resultado
                </th>
                </thead>    
                <tbody>
                    <tr>
                        <th>
                            ${partido.equipoLocal} (local):
                        </th>
                        <td>
                            <c:choose>
                                <c:when test="${partido.estado == false}">
                                    -
                                </c:when>
                                <c:otherwise>
                                    ${partido.resultadoEquipoLocal}
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            ${partido.equipoVisitante} (visitante):
                        </th>
                        <td>
                            <c:choose>
                                <c:when test="${partido.estado == false}">
                                    -
                                </c:when>
                                <c:otherwise>
                                    ${partido.resultadoEquipoVisitante}
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </tbody>
                <thead>
                <th colspan="2">
                    Información del partido
                </th>
                </thead>
                <tbody>
                    <tr>
                        <th>
                            Fecha:
                        </th>
                        <td>
                            ${partido.fecha}
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Hora:
                        </th>
                        <td>
                            ${partido.hora}
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Arbitro:
                        </th>
                        <td>
                            ${partido.arbitro}
                        </td>
                    </tr>               
                    <tr>
                        <th>
                            Campo:
                        </th>
                        <td>
                            ${partido.campo}
                        </td>
                    </tr>
                </tbody>
                <thead>
                <th colspan="2">
                    Detalles del partido
                </th>
                </thead>
                <tbody>
                    <tr>
                        <th>
                            MVP:
                        </th>
                        <td>
                            <c:choose>
                                <c:when test="${partido.estado == false}">
                                    -
                                </c:when>
                                <c:otherwise>
                                    ${partido.mvp}
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Goles:
                        </th>
                        <c:choose>
                            <c:when test="${cantidadGoles == 0}">
                                <td>
                                    -
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>
                                                    Minuto
                                                </th>
                                                <th colspan="4">
                                                    Jugador
                                                </th>
                                                <th>
                                                    Equipo
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${gol}" var="g">
                                                <tr>
                                                    <td>
                                                        ${g.minuto}
                                                    </td>
                                                    <td>
                                                        ${g.jugador.dorsal}
                                                    </td>
                                                    <td>
                                                        ${g.jugador.nombre}
                                                    </td>
                                                    <td>
                                                        ${g.jugador.apellido}
                                                    </td>
                                                    <td>
                                                        ${g.jugador.posicionJugador}
                                                    </td>
                                                    <td>
                                                        ${g.jugador.equipo}
                                                    </td>
                                                </tr> 
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <th>
                            Tarjetas amarillas:
                        </th>
                        <c:choose>
                            <c:when test="${cantidadTarjetasAmarillas == 0}">
                                <td>
                                    -
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>
                                                    Minuto
                                                </th>
                                                <th colspan="4">
                                                    Jugador
                                                </th>
                                                <th>
                                                    Equipo
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${tarjetaAmarilla}" var="ta">
                                                <tr>
                                                    <td>
                                                        ${ta.minuto}
                                                    </td>
                                                    <td>
                                                        ${ta.jugador.dorsal}
                                                    </td>
                                                    <td>
                                                        ${ta.jugador.nombre}
                                                    </td>
                                                    <td>
                                                        ${ta.jugador.apellido}
                                                    </td>
                                                    <td>
                                                        ${ta.jugador.posicionJugador}
                                                    </td>
                                                    <td>
                                                        ${ta.jugador.equipo}
                                                    </td>
                                                </tr> 
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <th>
                            Tarjetas rojas:
                        </th>
                        <c:choose>
                            <c:when test="${cantidadTarjetasRojas == 0}">
                                <td>
                                    -
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>
                                                    Minuto
                                                </th>
                                                <th colspan="4">
                                                    Jugador
                                                </th>
                                                <th>
                                                    Equipo
                                                </th>
                                                <th>
                                                    Motivo
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${tarjetaRoja}" var="tr">
                                                <tr>
                                                    <td>
                                                        ${tr.minuto}
                                                    </td>
                                                    <td>
                                                        ${tr.jugador.dorsal}
                                                    </td>
                                                    <td>
                                                        ${tr.jugador.nombre}
                                                    </td>
                                                    <td>
                                                        ${tr.jugador.apellido}
                                                    </td>
                                                    <td>
                                                        ${tr.jugador.posicionJugador}
                                                    </td>
                                                    <td>
                                                        ${tr.jugador.equipo}
                                                    </td>
                                                    <td>
                                                        ${tr.motivo}
                                                    </td>
                                                </tr> 
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </tbody>
            </table>
        </div>
        <a href="/Furtgolito/ListaPartidos.jsp">
            <button>
                Volver
            </button>
        </a>
    </body>
</html>
