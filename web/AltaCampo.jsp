<%-- 
    Document   : AltaCampo
    Created on : 8 oct. 2021, 21:41:04
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de campo</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/AltaCampoServlet">
            <div>
                <h1>
                    Nuevo campo
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
