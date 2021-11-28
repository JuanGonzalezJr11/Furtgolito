<%-- 
    Document   : ListaCampos
    Created on : 8 oct. 2021, 21:44:27
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/css/estilos.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Listado de campos</title>
    </head>
    <header>
        <%@include file = "LoginLogout.jsp" %>
        <%@include file = "Navbar.jsp" %>
    </header>
    <body class="fondo campos">
        <div class="contenedor-listados campos">
            <h1>
                Listado de campos
            </h1>
            <c:choose>
                <c:when test="${gestor.cantidadCampos == 0}">
                    No se han cargado campos aún.
                </c:when>
                <c:otherwise>
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">
                                    Campos
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${gestor.listadoCampos}" var="listadoCampos">
                                <tr>
                                    <td>
                                        ${listadoCampos.nombre}
                                    </td>
                                    <td>
                                        <a href="/Furtgolito/ModificarCampoServlet?idCampo=${listadoCampos.idCampo}">
                                            <button class="modificar">
                                                Modificar
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
                <a href="/Furtgolito/AltaCampoServlet">
                    <button class="nuevo-partido">
                        Nuevo campo
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
