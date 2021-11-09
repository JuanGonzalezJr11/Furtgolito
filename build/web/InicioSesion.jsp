<%-- 
    Document   : Login
    Created on : 3 nov. 2021, 13:47:39
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio sesión</title>
    </head>
    <body>
        <h1>
            Furtgolito
        </h1>
        <form method="post" action="/Furtgolito/InicioSesionServlet">
            <h2>
                Inicio de sesión
            </h2>
            <div>
                <label>
                    Nombre/Usuario:
                </label>
                <input type="text" name="txtUsuario" id="txtUsuario" />
            </div>
            <div>
                <label>
                    Contraseña:
                </label>
                <input type="password" name="txtContrasena" id="txtContrasena" />
            </div>
            <button type="submit">
                Iniciar sesión
            </button>
            <c:if test="${not empty error}">
                <div>
                    <p>
                        ${error}
                    </p>
                </div>
            </c:if>
        </form>
    </body>
</html>
