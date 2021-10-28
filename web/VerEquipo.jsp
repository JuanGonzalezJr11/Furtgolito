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
        <h2>
            Lista de jugadores
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
                            ${j.telefono}
                        </td>
                        <td>
                            ${j.email}
                        </td>
                        <td>
                            ${j.estaSuspendido()}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/Furtgolito/ListaEquipos.jsp">
            <button>
                Volver
            </button>
        </a>
    </body>
</html>
