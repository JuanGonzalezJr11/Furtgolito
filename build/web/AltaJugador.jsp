<%-- 
    Document   : AltaJugador
    Created on : 2 oct. 2021, 11:02:46
    Author     : JuanG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de jugador</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/AltaJugadorServlet">
            <div>
                <h1>
                    Nuevo jugador
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
                    Edad:
                </label>
                <input type="number" name="txtEdad"/>
            </div>
            <div>
                <label>
                    Posición:
                </label>
                <select name="cboPosicionJugador" class="form-control" id="cboPosicionJugador">
                    <c:forEach var="pj" items="${gestor.posicionesJugadores}">
                        <option value="${pj.idPosicionJugador}">
                            ${pj.posicionJugador}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>
                    Dorsal:
                </label>
                <input type="number" name="txtDorsal"/>
            </div>
            <div>
                <label>
                    Equipo:
                </label>
                <select name="cboEquipo" class="form-control" id="cboEquipo">
                    <c:forEach var="e" items="${gestor.equipos}">
                        <option value="${e.idEquipo}">
                            ${e.nombre}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>
                    Capitán:
                </label>
                <select name="cboCapitan" class="form-control" id="cboCapitan">
                    <option value=false>
                        No
                    </option>
                    <option value=true>
                        Si
                    </option>
                </select>
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


