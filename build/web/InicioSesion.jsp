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
        <!-- Iconos: -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
        <!-- Adaptación de la pantalla a los distintos dispositivos sin tener que utilizar zoom. -->
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Inicio sesión</title>
    </head>
    <body class="inicio-sesion">
        <h1 class="logo">
            Furtgolito
        </h1>
        <div class="contenedor-inicio-sesion">
            <form method="post" action="/Furtgolito/InicioSesionServlet">
                <h1>
                    Inicio de sesión
                </h1>
                <label>
                    <i class="material-icons icono-inicio-sesion">person</i>
                    Usuario:
                </label>
                <input type="text" name="txtUsuario" id="txtUsuario" required/>
                <label>
                    <i class="material-icons icono-inicio-sesion">lock</i>
                    Contraseña:
                </label>
                <input type="password" name="txtContrasena" id="txtContrasena" required/>
                <br>
                <button type="submit" class="inicio-sesion">
                    Iniciar sesión
                </button>
                <c:if test="${not empty error}">
                    <div>
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
