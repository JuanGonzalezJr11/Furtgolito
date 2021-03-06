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
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="login-logout">
            <c:choose>
                <c:when test="${!empty usuario}">
                    <div>
                        <%= " ¡Hola " + request.getSession().getAttribute("usuario") + "! "%>
                        <a href="/Furtgolito/CierreSesionServlet">
                            Cerrar sesión
                        </a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div>
                        <a href="/Furtgolito/InicioSesionServlet">
                            Iniciar sesión
                        </a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
