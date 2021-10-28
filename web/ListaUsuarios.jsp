<%-- 
    Document   : ListaUsuarios
    Created on : 29 sept. 2021, 21:37:07
    Author     : JuanG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de usuarios</title>
    </head>
    <body>
        <%@include file = "Navbar.jsp" %>
        <br>
        <h1>
            Listado de usuarios
        </h1>
        <table>
            <thead>
                <tr>
                    <th>
                        Usuario
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${gestor.listadoUsuarios}" var="listadoUsuarios">
                    <tr>
                        <td>
                            ${listadoUsuarios.usuario}
                        </td>
                        <td>
                            <a href="/Furtgolito/ModificarUsuarioServlet?idUsuario=${listadoUsuarios.idUsuario}">
                                <button>
                                    Modificar
                                </button>
                            </a>
                        </td>
                        <td>
                            <a href="/Furtgolito/EliminarUsuarioServlet?idUsuario=${listadoUsuarios.idUsuario}">
                                <button>
                                    Eliminar
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/Furtgolito/AltaUsuarioServlet">
            <button>
                Nuevo usuario
            </button>
        </a>
    </body>
</html>
