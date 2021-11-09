<%-- 
    Document   : CargarDetallesResultadoPartido
    Created on : 8 nov. 2021, 12:38:48
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar detalles resultado partido</title>
    </head>
    <body>
        <h1>
            Cargar detalles resultado partido
        </h1>
        <form method="post" action="/Furtgolito/AsignarMvpServlet">
            <div>
                <h2>
                    Most Valuable Player:
                </h2>
                <label>
                    Jugador (MVP):
                </label>
                <select name="cboMvp" id="cboMvp">
                    <c:forEach var="j" items="${jugador}">
                        <option value="${j.idJugador}"<c:if test="${j.idJugador == partido.mvp.idJugador}"> selected </c:if>>
                            ${j.dorsal}. ${j.nombre} ${j.apellido} (${j.posicionJugador}) - ${j.equipo}
                        </option>
                    </c:forEach>
                </select>
                <input type="hidden" name="txtIdPartido" id="idPartido" value="${partido.idPartido}"/>
                <c:choose>
                    <c:when test="${partido.mvp == null}">
                        <button type="submit">
                            Agregar
                        </button>
                    </c:when>
                    <c:otherwise>
                        Ya hay un jugador asignado como MPV.
                    </c:otherwise>
                </c:choose>
            </div>
        </form>
        <div>
            <c:choose>
                <c:when test="${partido.mvp == null}">
                    No ha cargado ningún jugador como MVP aún.
                </c:when>
                <c:otherwise>
                    <table>
                        <thead>
                            <tr>
                                <th>
                                    Dorsal
                                </th>
                                <th colspan="3">
                                    Nombre
                                </th>
                                <th>
                                    Equipo
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${mvp}" var="m">
                                <tr>
                                    <td>
                                        ${m.dorsal}
                                    </td>
                                    <td>
                                        ${m.nombre}
                                    </td>
                                    <td>
                                        ${m.apellido}
                                    </td>
                                    <td>
                                        ${m.posicionJugador}
                                    </td>
                                    <td>
                                        ${m.equipo}
                                    </td>
                                    <td>
                                        <a href="/Furtgolito/EliminarMvpServlet?idPartido=${partido.idPartido}">
                                            <button>
                                                Eliminar
                                            </button>
                                        </a>
                                    </td>
                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>       
        <form method="post" action="/Furtgolito/AltaGolServlet">
            <div>
                <h2>
                    Gol/es:
                </h2>
            </div>
            <div>
                <label>
                    Jugador (autor):
                </label>
                <select name="cboJugador" id="cboJugador">
                    <c:forEach var="j" items="${jugador}">
                        <option value="${j.idJugador}">
                            ${j.dorsal}. ${j.nombre} ${j.apellido} (${j.posicionJugador}) - ${j.equipo}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>
                    Minuto:
                </label>
                <input type="number" name="txtMinuto"/>
            </div>
            <div>
                <label>
                    Gol en contra:
                </label>
                <input type="checkbox" name="chkContra" id="chkContra" value="true">
            </div>
            <input type="hidden" name="txtIdPartido" id="idPartido" value="${partido.idPartido}"/>
            <c:choose>
                <c:when test="${cantidadGoles < cantidadGolesLYV}">
                    <button type="submit">
                        Agregar
                    </button>
                </c:when>
                <c:otherwise>
                    Ya ha cargado todos los goles de este partido.
                </c:otherwise>
            </c:choose>
        </form>
        <div>
            <c:choose>
                <c:when test="${cantidadGoles == 0}">
                    No ha cargado ningún gol aún.
                </c:when>
                <c:otherwise>
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
                                        ${g.minuto}' ${g.golEnContra()}
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
                                    <td>
                                        <a href="/Furtgolito/EliminarGolServlet?idGol=${g.idGol}&idPartido=${partido.idPartido}">
                                            <button>
                                                Eliminar
                                            </button>
                                        </a>
                                    </td>
                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
        <form method="post" action="/Furtgolito/AltaTarjetaAmarillaServlet">
            <div>
                <h2>
                    Tarjetas amarillas:
                </h2>
            </div>
            <div>
                <label>
                    Jugador:
                </label>
                <select name="cboJugador" id="cboJugador">
                    <c:forEach var="j" items="${jugador}">
                        <option value="${j.idJugador}">
                            ${j.dorsal}. ${j.nombre} ${j.apellido} (${j.posicionJugador}) - ${j.equipo}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>
                    Minuto:
                </label>
                <input type="number" name="txtMinuto"/>
            </div>
            <input type="hidden" name="txtIdPartido" id="idPartido" value="${partido.idPartido}"/>
            <button type="submit">
                Agregar
            </button>
        </form>
        <div>
            <c:choose>
                <c:when test="${cantidadTarjetasAmarillas == 0}">
                    No ha cargado ninguna tarjeta aún.
                </c:when>
                <c:otherwise>
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
                                        ${ta.minuto}'
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
                                    <td>
                                        <a href="/Furtgolito/EliminarTarjetaAmarillaServlet?idTarjetaAmarilla=${ta.idTarjetaAmarilla}&idPartido=${partido.idPartido}">
                                            <button>
                                                Eliminar
                                            </button>
                                        </a>
                                    </td>
                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>    
        <form method="post" action="/Furtgolito/AltaTarjetaRojaServlet">
            <div>
                <h2>
                    Tarjetas rojas:
                </h2>
            </div>
            <div>
                <label>
                    Jugador:
                </label>
                <select name="cboJugador" id="cboJugador">
                    <c:forEach var="j" items="${jugador}">
                        <option value="${j.idJugador}">
                            ${j.dorsal}. ${j.nombre} ${j.apellido} (${j.posicionJugador}) - ${j.equipo}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>
                    Minuto:
                </label>
                <input type="number" name="txtMinuto"/>
            </div>
            <input type="hidden" name="txtIdPartido" id="idPartido" value="${partido.idPartido}"/>
            <div>
                <label>
                    Motivo:
                </label>
                <textarea type="text" name="txtMotivo" rows="4" cols="40"></textarea>
            </div>
            <button type="submit">
                Agregar
            </button>
        </form>
        <div>
            <c:choose>
                <c:when test="${cantidadTarjetasRojas == 0}">
                    No ha cargado ninguna tarjeta aún.
                </c:when>
                <c:otherwise>
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
                                        ${tr.minuto}'
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
                                    <td>
                                        <a href="/Furtgolito/EliminarTarjetaRojaServlet?idTarjetaRoja=${tr.idTarjetaRoja}&idPartido=${partido.idPartido}">
                                            <button>
                                                Eliminar
                                            </button>
                                        </a>
                                    </td>
                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>    
        <a href="/Furtgolito/ListaPartidos.jsp">
            <button>
                Volver
            </button>
        </a>
    </body>
</html>
