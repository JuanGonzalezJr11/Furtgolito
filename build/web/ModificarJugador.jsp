<%-- 
    Document   : ModificarJugador
    Created on : 4 oct. 2021, 20:34:05
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar jugador</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/ModificarJugadorServlet">
            <div>
                <h1>
                    Modificar jugador
                </h1>
            </div>
            <input type="hidden" name="txtIdJugador" value="${jugador.idJugador}"/>
            <div>
                <label>
                    Nombre:
                </label>
                <input type="text" class="form-control" name="txtNombre" id="txtNombre" value="${jugador.nombre}" required/>
            </div>
            <div>
                <label>
                    Apellido:
                </label>
                <input type="text" class="form-control" name="txtApellido" id="txtApellido" value="${jugador.apellido}" required/>
            </div>
            <div>
                <label>
                    Edad:
                </label>
                <input type="number" class="form-control" name="txtEdad" id="txtEdad" value="${jugador.edad}" required/>
            </div>
            <div>
                <label>
                    Equipo: ${jugador.equipo}
                </label>
                <!-- <input type="hidden" name="cboEquipo" id="cboEquipo" value="${jugador.equipo.idEquipo}"/> -->
                <select name="cboEquipo" class="form-control" id="cboEquipo">
                    <c:forEach var="e" items="${gestor.equipos}">
                        <option value="${e.idEquipo}" <c:if test="${e.idEquipo == jugador.equipo.idEquipo}"> selected </c:if>>
                            ${e.nombre}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>
                    Dorsal:
                </label>
                <input type="number" class="form-control" name="txtDorsal" id="txtDorsal" value="${jugador.dorsal}" required/>
            </div>
            <div>
                <label>
                    Posición:
                </label>
                <select name="cboPosicionJugador" class="form-control" id="cboPosicionJugador">
                    <c:forEach var="pj" items="${gestor.posicionesJugadores}">
                        <option value="${pj.idPosicionJugador}" <c:if test="${pj.idPosicionJugador == jugador.posicionJugador.idPosicionJugador}"> selected</c:if>>
                            ${pj.posicionJugador}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>
                    Capitán:
                </label>
                <select name="cboCapitan" id="cboCapitan">
                    <option value=false <c:if test="${jugador.capitan == false}"> selected</c:if>>
                        No
                    </option>
                    <option value=true <c:if test="${jugador.capitan == true}"> selected</c:if>>
                        Si
                    </option>
                </select>
            </div>
            <div>
                <label>
                    Telefono:
                </label>
                <input type="number" class="form-control" name="txtTelefono" id="txtTelefono" value="${jugador.telefono}" required/>
            </div>
            <div>
                <label>
                    E-mail:
                </label>
                <input type="text" class="form-control" name="txtEmail" id="txtEmail" value="${jugador.email}" required/>
            </div>
            <button type="submit">
                Aceptar
            </button>
        </form>
    </body>
</html>
