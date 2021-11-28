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
        <link href="/css/estilos.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Alta de campo</title>
    </head>
    <header>
        <%@include file = "LoginLogout.jsp" %>
        <%@include file = "Navbar.jsp" %>
    </header>
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
