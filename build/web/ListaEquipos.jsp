<%-- 
    Document   : ListaEquipos
    Created on : 8 oct. 2021, 20:21:54
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de equipos</title>
    </head>
    <body>
        <%@include file = "LoginLogout.jsp" %>
        <%@include file = "Navbar.jsp" %>
        <br>
        <h1>
            Listado de equipos
        </h1>
        <c:choose>
            <c:when test="${gestor.cantidadEquipos == 0}">
                No se han cargados equipos aún.
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                        <tr>
                            <th>
                                Nombre
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${gestor.listadoEquipos}" var="listadoEquipos">
                            <tr>
                                <td>
                                    ${listadoEquipos.nombre}
                                </td>
                                <c:if test="${!empty usuario}">
                                    <td>
                                        <a href="/Furtgolito/ModificarEquipoServlet?idEquipo=${listadoEquipos.idEquipo}">
                                            <button>
                                                Modificar
                                            </button>
                                        </a>
                                    </td>
                                </c:if>
                                <td>
                                    <a href="/Furtgolito/VerEquipoServlet?idEquipo=${listadoEquipos.idEquipo}">
                                        <button>
                                            Ver
                                        </button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
        <c:if test="${!empty usuario}">
            <a href="/Furtgolito/AltaEquipoServlet">
                <button>
                    Nuevo equipo
                </button>
            </a>
        </c:if>
    </body>
</html>
