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
        <title>Listado de campos</title>
    </head>
    <body>
        <%@include file = "Navbar.jsp" %>
        <br>
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
                            <th>
                                Nombre
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
                                        <button>
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
        <a href="/Furtgolito/AltaCampoServlet">
            <button>
                Nuevo campo
            </button>
        </a>
    </body>
</html>
