<%-- 
    Document   : AltaEquipo
    Created on : 8 oct. 2021, 20:13:44
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de equipo</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/AltaEquipoServlet">
            <div>
                <h1>
                    Nuevo equipo
                </h1>
            </div>
            <div>
                <label>
                    Nombre:
                </label>
                <input type="text" name="txtNombre"/>
            </div>
            <button type="submit">
                Agregar
            </button>
        </form>
    </body>
</html>
