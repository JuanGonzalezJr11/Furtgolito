<%-- 
    Document   : LoginLogout
    Created on : 10 nov. 2021, 14:51:35
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
</html>
