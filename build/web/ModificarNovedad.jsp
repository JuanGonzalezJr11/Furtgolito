<%-- 
    Document   : ModificarNovedad
    Created on : 9 oct. 2021, 13:40:45
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar novedad</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/ModificarNovedadServlet">
            <div>
                <h1>
                    Modificar novedad
                </h1>
            </div>
            <input type="hidden" name="txtIdNovedad" value="${novedad.idNovedad}"/>
            <div>
                <label>
                    Título:
                </label>
                <input type="text" class="form-control" name="txtTitulo" id="txtTitulo" value="${novedad.titulo}" required/>
            </div>
            <div>
                <label>
                    Descripción:
                </label>
                <input type="text" class="form-control" name="txtDescripcion" id="txtDescripcion" value="${novedad.descripcion}" required/>
            </div>
            <c:if test="${!empty usuario}">
                <button type="submit">
                    Aceptar
                </button>
            </c:if>
        </form>
    </body>
</html>
