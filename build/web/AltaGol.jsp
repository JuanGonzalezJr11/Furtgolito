<%-- 
    Document   : AltaGol
    Created on : 16 oct. 2021, 13:36:49
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de gol</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/AltaGolServlet">
            <table>
            <thead>
                    <tr>
                        Jornada:
                    </tr>
                    <tr>
                        Fecha:
                    </tr>
                    <tr>
                        Hora:
                    </tr>
                    <tr>
                        
                    </tr>
                    <tr>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <input type="text">
                    </tr>
                    <tr>
                        <input type="text">
                    </tr>
                </tbody>
            </table>
            <div>
                <h1>
                    Nuevo gol
                </h1>
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
        <a href="/Furtgolito/ListaPartidos.jsp">
            <button>
                Volver
            </button>
        </a>
    </body>
</html>
