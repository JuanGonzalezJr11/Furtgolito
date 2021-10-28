<%-- 
    Document   : AltaArbitro
    Created on : 7 oct. 2021, 16:51:47
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de arbitro</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/AltaArbitroServlet">
            <div>
                <h1>
                    Nuevo arbitro
                </h1>
            </div>
            <div>
                <label>
                    Nombre:
                </label>
                <input type="text" name="txtNombre"/>
            </div>
            <div>
                <label>
                    Apellido:
                </label>
                <input type="text" name="txtApellido"/>
            </div>
            <div>
                <label>
                    Teléfono:
                </label>
                <input type="number" name="txtTelefono"/>
            </div>
            <div>
                <label>
                    E-mail:
                </label>
                <input type="text" name="txtEmail"/>
            </div>
            <button type="submit">
                Agregar
            </button>
        </form>
    </body>
</html>
