<%-- 
    Document   : ModificarPartido
    Created on : 23 oct. 2021, 12:14:11
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar partido</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/ModificarPartidoServlet">
            <div>
                <h1>
                    Modificar partido
                </h1>
            </div>
            <input type="hidden" name="txtIdPartido" value="${partido.idPartido}"/>
            <div>
                <label>
                    Jornada:
                </label>
                <input type="number" name="txtJornada" id="txtJornada" value="${partido.jornada}" required/>
            </div>
            <div>
                <label>
                    Fecha:
                </label>
                <input type="text" name="txtFecha" id="txtFecha" value="${partido.fecha}" required/>
            </div>
            <div>
                <label>
                    Hora:
                </label>
                <input type="text" name="txtHora" id="txtHora" value="${partido.hora}" required/>
            </div>
            <div>
                <label>
                    Equipo local:
                </label>
                <select name="cboEquipoLocal" id="cboEquipoLocal">
                    <c:forEach var="el" items="${gestor.equipos}">
                        <option value="${el.idEquipo}" <c:if test="${el.idEquipo == partido.equipoLocal.idEquipo}"> selected </c:if>>
                            ${el.nombre}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>
                    Equipo visitante:
                </label>
                <select name="cboEquipoVisitante" id="cboEquipoVisitante">
                    <c:forEach var="ev" items="${gestor.equipos}">
                        <option value="${ev.idEquipo}" <c:if test="${ev.idEquipo == partido.equipoVisitante.idEquipo}"> selected </c:if>>
                            ${ev.nombre}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>
                    Arbitro:
                </label>
                <select name="cboArbitro" id="cboArbitro">
                    <c:forEach var="a" items="${gestor.arbitros}">
                        <option value="${a.idArbitro}" <c:if test="${a.idArbitro == partido.arbitro.idArbitro}"> selected </c:if>>
                            ${a.nombre} ${a.apellido}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>
                    Campo:
                </label>
                <select name="cboCampo" id="cboCampo">
                    <c:forEach var="c" items="${gestor.campos}">
                        <option value="${c.idCampo}" <c:if test="${c.idCampo == partido.campo.idCampo}"> selected </c:if>>
                            ${c.nombre}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit">
                Aceptar
            </button>
        </form>
    </body>
</html>
