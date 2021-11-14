<%-- 
    Document   : LoginLogout
    Created on : 10 nov. 2021, 14:51:35
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="loginLogout">
            <c:choose>
                <c:when test="${!empty usuario}">
                    <a href="/Furtgolito/CierreSesionServlet">
                        Cerrar sesión
                    </a>
                    <%= " ¡Hola " + request.getSession().getAttribute("usuario") + "! "%>
                </c:when>
                <c:otherwise>
                    <a href="/Furtgolito/InicioSesionServlet">
                        Iniciar sesión
                    </a>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
