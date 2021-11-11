<%-- 
    Document   : ListaArbitros
    Created on : 7 oct. 2021, 16:55:55
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de arbitros</title>
    </head>
    <body>
        <%@include file = "LoginLogout.jsp" %>
        <%@include file = "Navbar.jsp" %>
        <br>
        <h1>
            Listado de arbitros
        </h1>
        <c:choose>
            <c:when test="${gestor.cantidadArbitros == 0}">
                No se han cargado arbitros aún.
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
                                Teléfono
                            </th>
                            <th>
                                E-mail
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${gestor.listadoArbitros}" var="listadoArbitros">
                            <tr>
                                <td>
                                    ${listadoArbitros.nombre}
                                </td>
                                <td>
                                    ${listadoArbitros.apellido}
                                </td>
                                <td>
                                    ${listadoArbitros.telefono}
                                </td>
                                <td>
                                    ${listadoArbitros.email}
                                </td>
                                <c:if test="${!empty usuario}">
                                    <td>
                                        <a href="/Furtgolito/ModificarArbitroServlet?idArbitro=${listadoArbitros.idArbitro}">
                                            <button>
                                                Modificar
                                            </button>
                                        </a>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
        <c:if test="${!empty usuario}">
            <a href="/Furtgolito/AltaArbitroServlet">
                <button>
                    Nuevo arbitro
                </button>
            </a>
        </c:if>
    </body>
</html>
