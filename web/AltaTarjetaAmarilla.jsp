<%-- 
    Document   : AltaTarjetaAmarilla
    Created on : 26 oct. 2021, 13:11:34
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de tarjeta amarilla</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/AltaTarjetaAmarillaServlet">
            <div>
                <h1>
                    Nueva tarjeta amarilla
                </h1>
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
        <!-- <div>
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
</div> -->
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
        <a href="/Furtgolito/ListaPartidos.jsp">
            <button>
                Volver
            </button>
        </a>
    </body>
</html>
