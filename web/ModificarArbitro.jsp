<%-- 
    Document   : ModificarArbitro
    Created on : 7 oct. 2021, 17:20:26
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar arbitro</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/ModificarArbitroServlet">
            <div>
                <h1>
                    Modificar arbitro
                </h1>
            </div>
            <input type="hidden" name="txtIdArbitro" value="${arbitro.idArbitro}"/>
            <div>
                <label>
                    Nombre:
                </label>
                <input type="text" class="form-control" name="txtNombre" id="txtNombre" value="${arbitro.nombre}" required/>
            </div>
            <div>
                <label>
                    Apellido:
                </label>
                <input type="text" class="form-control" name="txtApellido" id="txtApellido" value="${arbitro.apellido}" required/>
            </div>
            <div>
                <label>
                    Telefono:
                </label>
                <input type="number" class="form-control" name="txtTelefono" id="txtTelefono" value="${arbitro.telefono}" required/>
            </div>
            <div>
                <label>
                    E-mail:
                </label>
                <input type="text" class="form-control" name="txtEmail" id="txtEmail" value="${arbitro.email}" required/>
            </div>
            <button type="submit">
                Aceptar
            </button>
        </form>
    </body>
</html>
