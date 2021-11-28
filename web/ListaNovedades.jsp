<%-- 
    Document   : ListaNovedades
    Created on : 9 oct. 2021, 13:46:44
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Listado de novedades</title>
    </head>
    <header>
        <%@include file = "LoginLogout.jsp" %>
        <%@include file = "Navbar.jsp" %>
    </header>
    <body class="fondo novedades">
        <div class="contenedor-listados novedades">
            <h1>
                Listado de novedades
            </h1>
            <c:choose>
                <c:when test="${gestor.cantidadNovedades == 0}">
                    No se ha cargado ninguna novedad aún.
                </c:when>
                <c:otherwise>
                    <table>
                        <thead>
                            <tr>
                                <th>
                                    Título
                                </th>
                                <th>
                                    Descripción
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${gestor.listadoNovedades}" var="listadoNovedades">
                                <tr>
                                    <td class="titulo-novedad">
                                        ${listadoNovedades.titulo}
                                    </td>
                                    <td>
                                        ${listadoNovedades.descripcion}
                                    </td>
                                    <c:if test="${!empty usuario}">
                                        <td>
                                            <a href="/Furtgolito/ModificarNovedadServlet?idNovedad=${listadoNovedades.idNovedad}">
                                                <button class="modificar">
                                                    Modificar
                                                </button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="/Furtgolito/EliminarNovedadServlet?idNovedad=${listadoNovedades.idNovedad}">
                                                <button class="eliminar">
                                                    Eliminar
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
                <a href="/Furtgolito/AltaNovedadServlet">
                    <button class="nuevo-partido">
                        Nueva novedad
                    </button>
                </a>
            </c:if>
        </div>
        <footer>
            <p>
                Design by Juan Gonzalez | 2021
            </p>
        </footer>
    </body>
</html>
