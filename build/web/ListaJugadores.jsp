<%-- 
    Document   : ListaJugadores2
    Created on : 23 oct. 2021, 10:23:01
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de jugadores</title>
    </head>
    <body>
        <%@include file = "Navbar.jsp" %>
        <br>
        <c:if test="${!empty usuario}">
            <a href="/Furtgolito/AltaJugadorServlet">
                <button>
                    Nuevo jugador
                </button>
            </a>
        </c:if>
        <h1>
            Listado de jugadores
        </h1>
        <c:choose>
            <c:when test="${gestor.cantidadJugadores == 0}">
                No se ha cargado ningún jugador aún.
            </c:when>
            <c:otherwise>
                <c:forEach items="${gestor.listadoEquipos}" var="e">
                    <h2>
                        ${e.nombre}
                    </h2>
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
                                    Teléfono
                                </th>
                                <th>
                                    E-mail
                                </th>
                                <th>
                                    Suspensión
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${gestor.listadoJugadores}" var="listadoJugadores">
                                <c:if test="${e.nombre == listadoJugadores.equipo}">
                                    <tr>
                                        <td>
                                            ${listadoJugadores.nombre}
                                        </td>
                                        <td>
                                            ${listadoJugadores.apellido}
                                        </td>
                                        <td>
                                            ${listadoJugadores.edad}
                                        </td>
                                        <td>
                                            ${listadoJugadores.posicionJugador}
                                        </td>
                                        <td>
                                            ${listadoJugadores.dorsal}
                                        </td>
                                        <td>
                                            ${listadoJugadores.esCapitan()}
                                        </td>
                                        <td>
                                            ${listadoJugadores.telefono}
                                        </td>
                                        <td>
                                            ${listadoJugadores.email}
                                        </td>
                                        <td>
                                            ${listadoJugadores.estaSuspendido()}
                                        </td>
                                        <c:if test="${!empty usuario}">
                                            <td>
                                                <c:if test="${listadoJugadores.suspension == true}">
                                                    <a href="/Furtgolito/QuitarSuspensionJugadorServlet?idJugador=${listadoJugadores.idJugador}">
                                                        <button>
                                                            Quitar suspensión
                                                        </button>
                                                    </a>
                                                </c:if>
                                                <c:if test="${listadoJugadores.suspension == false}">
                                                    <a href="/Furtgolito/SuspenderJugadorServlet?idJugador=${listadoJugadores.idJugador}">
                                                        <button>
                                                            Añadir suspensión
                                                        </button>
                                                    </a>
                                                </c:if>
                                            </td>
                                            <td>
                                                <a href="/Furtgolito/ModificarJugadorServlet?idJugador=${listadoJugadores.idJugador}">
                                                    <button>
                                                        Modificar
                                                    </button>
                                                </a>
                                            </td> 
                                        </c:if>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
