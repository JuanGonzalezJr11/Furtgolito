<%-- 
    Document   : ModificarCampo
    Created on : 8 oct. 2021, 21:48:16
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar campo</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/ModificarCampoServlet">
            <div>
                <h1>
                    Modificar campo
                </h1>
            </div>
            <input type="hidden" name="txtIdCampo" value="${campo.idCampo}"/>
            <div>
                <label>
                    Nombre:
                </label>
                <input type="text" class="form-control" name="txtNombre" id="txtNombre" value="${campo.nombre}" required/>
            </div>
            <button type="submit">
                Aceptar
            </button>
        </form>
    </body>
</html>
