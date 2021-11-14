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
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
        <title>Inicio sesión</title>
    </head>
    <body class="fondo-inicio-sesion">
        <h1 class="titulo-inicio-sesion">
            Furtgolito
        </h1>
        <div class="contenedor-inicio-sesion">
            <form method="post" action="/Furtgolito/InicioSesionServlet">
                <h1>
                    Inicio de sesión
                </h1>
                <label>
                    Nombre/Usuario:
                </label>
                <input type="text" name="txtUsuario" id="txtUsuario" required/>
                <label>
                    Contraseña:
                </label>
                <input type="password" name="txtContrasena" id="txtContrasena" required/>
                <br>
                <button type="submit" class="boton-inicio-sesion">
                    Iniciar sesión
                </button>
                <c:if test="${not empty error}">
                    <div class="mensaje-error-iniciar-sesion">
                        <p>
                            <strong>${error}</strong>
                        </p>
                    </div>
                </c:if>
            </form>
        </div>
        <footer>
            <p>
                Design by Juan Gonzalez | 2021
            </p>
        </footer>
    </body>
</html>
