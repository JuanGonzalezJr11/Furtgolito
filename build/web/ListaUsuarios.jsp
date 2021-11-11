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
        <%@include file = "LoginLogout.jsp" %>
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
                        <c:if test="${listadoUsuarios.usuario == usuario}">
                            <td>
                                <a href="/Furtgolito/ModificarUsuarioServlet?idUsuario=${listadoUsuarios.idUsuario}">
                                    <button>
                                        Modificar
                                    </button>
                                </a>
                            </td>
                            <c:if test="${listadoUsuarios.idUsuario != 1}">
                                <td>
                                    <a href="/Furtgolito/EliminarUsuarioServlet?idUsuario=${listadoUsuarios.idUsuario}">
                                        <button>
                                            Eliminar
                                        </button>
                                    </a>
                                </td>
                            </c:if>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:forEach items="${gestor.listadoUsuarios}" var="u">
            <c:if test="${u.usuario == usuario && u.idUsuario == 1}">
                <a href="/Furtgolito/AltaUsuarioServlet">
                    <button>
                        Nuevo usuario
                    </button>
                </a>
            </c:if>
        </c:forEach>
    </body>
</html>
