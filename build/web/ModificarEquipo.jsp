<%-- 
    Document   : ModificarEquipo
    Created on : 8 oct. 2021, 20:17:42
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar equipo</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/ModificarEquipoServlet">
            <div>
                <h1>
                    Modificar equipo
                </h1>
            </div>
            <input type="hidden" name="txtIdEquipo" value="${equipo.idEquipo}"/>
            <div>
                <label>
                    Nombre:
                </label>
                <input type="text" class="form-control" name="txtNombre" id="txtNombre" value="${equipo.nombre}" required/>
            </div>
            <button type="submit">
                Aceptar
            </button>
        </form>
    </body>
</html>
