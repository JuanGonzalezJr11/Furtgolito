<%-- 
    Document   : AltaNovedad
    Created on : 9 oct. 2021, 13:36:20
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de novedad</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/AltaNovedadServlet">
            <div>
                <h1>
                    Nueva novedad
                </h1>
            </div>
            <div>
                <label>
                    Título:
                </label>
                <input type="text" name="txtTitulo"/>
            </div>
            <div>
                <label>
                    Descripción:
                </label>
                <textarea type="text" name="txtDescripcion" rows="4" cols="40"></textarea>
            </div>
            <button type="submit">
                Agregar
            </button>
        </form>
    </body>
</html>
