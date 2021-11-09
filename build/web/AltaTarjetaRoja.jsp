<%-- 
    Document   : AltaTarjetaRoja
    Created on : 27 oct. 2021, 10:52:05
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de tarjeta roja</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/AltaTarjetaRojaServlet">
            <div>
                <h1>
                    Nueva tarjeta roja
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
