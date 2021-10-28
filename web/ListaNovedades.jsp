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
        <title>Listado de novedades</title>
    </head>
    <body>
        <%@include file = "Navbar.jsp" %>
        <br>
        <h1>
            Listado de novedades
        </h1>
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
                        <td>
                            ${listadoNovedades.titulo}
                        </td>
                        <td>
                            ${listadoNovedades.descripcion}
                        </td>
                        <td>
                            <a href="/Furtgolito/ModificarNovedadServlet?idNovedad=${listadoNovedades.idNovedad}">
                                <button>
                                    Modificar
                                </button>
                            </a>
                        </td>
                        <td>
                            <a href="/Furtgolito/EliminarNovedadServlet?idNovedad=${listadoNovedades.idNovedad}">
                                <button>
                                    Eliminar
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/Furtgolito/AltaNovedadServlet">
            <button>
                Nueva novedad
            </button>
        </a>
    </body>
</html>
