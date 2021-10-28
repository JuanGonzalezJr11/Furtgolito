<%-- 
    Document   : ModificarUsuario
    Created on : 30 sept. 2021, 21:56:06
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar usuario</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/ModificarUsuarioServlet">
            <div>
                <h1>
                    Modificar usuario
                </h1>
            </div>
            <input type="hidden" name="txtIdUsuario" value="${usuario.idUsuario}"/>
            <div>
                <label>
                    Usuario:
                </label>
                <input type="text" class="form-control" name="txtUsuario" id="txtUsuario" value="${usuario.usuario}" required/>
            </div>
            <div>
                <label>
                    Contraseña:
                </label>
                <input type="text" class="form-control" name="txtContrasena" id="txtContrasena" value="${usuario.contrasena}" required/>
            </div>
            <button type="submit">
                Aceptar
            </button>
        </form>
    </body>
</html>
