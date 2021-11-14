<%-- 
    Document   : Navbar
    Created on : 19 oct. 2021, 13:10:10
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <nav class="nav">
        <h1 id="titulo-iniciar-sesion">
            Furtgolito
        </h1>
        <c:choose>
            <c:when test="${!empty usuario}">
                <div class="nav-con-logeo">
                    <a href="/Furtgolito/Principal.jsp">
                        Inicio
                    </a>
                    <a href="/Furtgolito/ListaUsuarios.jsp">
                        Usuarios
                    </a>
                    <a href="/Furtgolito/ListaPartidos.jsp">
                        Jornadas y partidos
                    </a>
                    <a href="">
                        Tabla posiciones
                    </a>
                    <a href="/Furtgolito/TablaGoleadores.jsp">
                        Tabla goleadores
                    </a>
                    <a href="/Furtgolito/ListaEquipos.jsp">
                        Equipos
                    </a>
                    <a href="/Furtgolito/ListaJugadores.jsp">
                        Jugadores
                    </a>
                    <a href="/Furtgolito/ListaArbitros.jsp">
                        Arbitros
                    </a>
                    <a href="/Furtgolito/ListaCampos.jsp">
                        Campos
                    </a>
                    <a href="/Furtgolito/ListaNovedades.jsp">
                        Novedades
                    </a>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <a href="/Furtgolito/Principal.jsp">
                        Inicio
                    </a>
                    <a href="/Furtgolito/ListaPartidos.jsp">
                        Jornadas y partidos
                    </a>
                    <a href="">
                        Tabla posiciones
                    </a>
                    <a href="/Furtgolito/TablaGoleadores.jsp">
                        Tabla goleadores
                    </a>
                    <a href="/Furtgolito/ListaEquipos.jsp">
                        Equipos
                    </a>
                    <a href="/Furtgolito/ListaJugadores.jsp">
                        Jugadores
                    </a>
                    <a href="/Furtgolito/ListaArbitros.jsp">
                        Arbitros
                    </a>
                </div>
            </c:otherwise>
        </c:choose>
    </nav>
</html>
