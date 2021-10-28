<%-- 
    Document   : ResultadoPartido2
    Created on : 26 oct. 2021, 10:12:46
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="controlador.GestorBaseDatos"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado partido</title>
    </head>
    <body>
        <form method="post" action="/Furtgolito/ResultadoPartido2Servlet">
            <div>
                <h1>
                    Resultado partido
                </h1>
                <h2>
                    Información del partido
                </h2>
            </div>
            <input type="hidden" name="txtIdPartido" value="${partido.idPartido}"/>
            <div>
                <label>
                    Jornada: ${partido.jornada}
                </label>
            </div>
            <div>
                <label>
                    Fecha: ${partido.fecha}
                </label>
            </div>
            <div>
                <label>
                    Hora: ${partido.hora}
                </label>
            </div>
            <div>
                <label>
                    Equipo local: ${partido.equipoLocal}
                </label>
            </div>
            <div>
                <label>
                    Equipo visitante: ${partido.equipoVisitante}
                </label>
            </div>
            <div>
                <label>
                    Arbitro: ${partido.arbitro}
                </label>
            </div>
            <div>
                <label>
                    Campo: ${partido.campo}
                </label>
            </div>
            <h2>
                 Detalles del partido   
            </h2>
            <h3>
                 Resultado:   
            </h3>
            <div>
                <label>
                    Resultado ${partido.equipoLocal} (local):
                </label>
                <input type="number" name="txtResultadoEquipoLocal" id="txtResultadoEquipoLocal" value="${partido.resultadoEquipoLocal}" required/>
            </div>
            <div>
                <label>
                    Resultado ${partido.equipoVisitante} (visitante):
                </label>
                <input type="text" name="txtResultadoEquipoVisitante" id="txtResultadoEquipoVisitante" value="${partido.resultadoEquipoVisitante}" required/>
            </div>
            <br>
            <div>
                <label>
                    <b>MVP:</b>
                </label>
                <select name="cboMvp" id="cboMvp">
                    <c:forEach var="m" items="${mvp}">
                        <option value="${m.idJugador}"<c:if test="${m.idJugador == partido.mvp.idJugador}"> selected </c:if>>
                            ${m.dorsal}. ${m.nombre} ${m.apellido} (${m.posicionJugador}) - ${m.equipo}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <!-- <div>
                <h3>
                    Gol/es:
                </h3>
                <div>
                    <label>
                        Jugador:
                    </label>
                </div>
                <div>
                    <label>
                        Minuto:
                    </label>
                </div>
            </div>
            <div>
                <h3>
                    Tarjetas amarillas:
                </h3>
                <div>
                    <label>
                        Jugador:
                    </label>
                    <select name="cboTarjetaAmarilla" id="cboTarjetaAmarilla">
                        <c:forEach var="a" items="${amonestado}">
                            <option value="${a.idJugador}">
                                ${a.dorsal}. ${a.nombre} ${a.apellido} (${a.posicionJugador}) - ${a.equipo}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label>
                        Minuto:
                    </label>
                    <input type="number" name="txtMinutoTarjetaAmarilla" id="txtMinutoTarjetaAmarilla"/>
                </div>
            </div>
            <div>
                <h3>
                    Tarjetas rojas:
                </h3>
                <div>
                    <label>
                        Jugador:
                    </label>
                </div>
                <div>
                    <label>
                        Minuto:
                    </label>
                </div>
            </div> -->
            <button type="submit">
                Aceptar
            </button>
        </form>
    </body>
</html>
