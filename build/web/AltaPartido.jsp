<%-- 
    Document   : AltaPartido
    Created on : 16 oct. 2021, 12:46:11
    Author     : JuanG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de partido</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/AltaPartidoServlet">
            <div>
                <h1>
                    Nuevo partido
                </h1>
            </div>
            <div>
                <label>
                    Jornada:
                </label>
                <input type="text" name="txtJornada" required/>
            </div>
            <div>
                <label>
                    Fecha:
                </label>
                <input type="text" name="txtFecha" required/>
            </div>
            <div>
                <label>
                    Hora:
                </label>
                <input type="text" name="txtHora" required/>
            </div>
            <div>
                <label>
                    Equipo local:
                </label>
                <c:choose>
                    <c:when test="${gestor.cantidadEquipos == 0}">
                        No hay equipos cargados aún.
                    </c:when>
                    <c:otherwise>
                        <select name="cboEquipoLocal" id="cboEquipoLocal">
                            <c:forEach var="el" items="${gestor.equipoLocalVisitante}">
                                <option value="${el.idEquipo}">
                                    ${el.nombre}
                                </option>
                            </c:forEach>
                        </select>
                    </c:otherwise>
                </c:choose>
            </div>
            <div>
                <label>
                    Equipo visitante:
                </label>
                <c:choose>
                    <c:when test="${gestor.cantidadEquipos == 0}">
                        No hay equipos cargados aún.
                    </c:when>
                    <c:otherwise>
                        <select name="cboEquipoVisitante" id="cboEquipoVisitante">
                            <c:forEach var="ev" items="${gestor.equipoLocalVisitante}">
                                <option value="${ev.idEquipo}">
                                    ${ev.nombre}
                                </option>
                            </c:forEach>
                        </select>
                    </c:otherwise>
                </c:choose>
            </div>
            <div>
                <label>
                    Arbitro:
                </label>
                <c:choose>
                    <c:when test="${gestor.cantidadArbitros == 0}">
                        No hay árbitros cargados aún.
                    </c:when>
                    <c:otherwise>
                        <select name="cboArbitro" class="form-control" id="cboArbitro">
                            <c:forEach var="ar" items="${gestor.arbitros}">
                                <option value="${ar.idArbitro}">
                                    ${ar.nombre} ${ar.apellido}
                                </option>
                            </c:forEach>
                        </select>
                    </c:otherwise>
                </c:choose>
            </div>
            <div>
                <label>
                    Campo:
                </label>
                <c:choose>
                    <c:when test="${gestor.cantidadCampos == 0}">
                        No hay campos cargados aún.
                    </c:when>
                    <c:otherwise>
                        <select name="cboCampo" class="form-control" id="cboCampo">
                            <c:forEach var="c" items="${gestor.campos}">
                                <option value="${c.idCampo}">
                                    ${c.nombre}
                                </option>
                            </c:forEach>
                        </select>
                    </c:otherwise>
                </c:choose>
            </div>
            <c:if test="${gestor.cantidadArbitros != 0 || gestor.cantidadCampos != 0 || gestor.cantidadEquipos != 0}">
                <button type="submit">
                    Agregar
                </button>
            </c:if>
        </form>
        <c:if test="${gestor.cantidadArbitros == 0 || gestor.cantidadCampos == 0 || gestor.cantidadEquipos == 0}">
            <a href="/Furtgolito/ListaPartidos.jsp">
                <button>
                    Volver
                </button> 
            </a>
        </c:if>
    </body>
</html>
