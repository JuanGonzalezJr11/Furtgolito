<%-- 
    Document   : AltaUsuario
    Created on : 28 sept. 2021, 12:28:34
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de usuario</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/AltaUsuarioServlet">
            <div>
                <h1>
                    Nuevo usuario
                </h1>
            </div>
            <div>
                <label>
                    Usuario:
                </label>
                <input type="text" name="txtUsuario"/>
            </div>
            <div>
                <label>
                    Contraseña:
                </label>
                <input type="text" name="txtContrasena"/>
            </div>
            <button type="submit">
                Agregar
            </button>
        </form>
    </body>
</html>
