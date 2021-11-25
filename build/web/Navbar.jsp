<%-- 
    Document   : Navbar
    Created on : 19 oct. 2021, 13:10:10
    Author     : JuanG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="navbar">
            <h1 class="logo">
                Furtgolito
            </h1>
            <ul>
                <c:choose>
                    <c:when test="${!empty usuario}">
                        <li>
                            <a href="/Furtgolito/Principal.jsp">
                                Inicio
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaUsuarios.jsp">
                                Usuarios
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaPartidos.jsp">
                                Jornadas y partidos
                            </a>
                        </li>
                        <li>
                            <a href="">
                                Tabla posiciones
                            </a> 
                        </li>
                        <li>
                            <a href="/Furtgolito/TablaGoleadores.jsp">
                                Tabla goleadores
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaEquipos.jsp">
                                Equipos
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaJugadores.jsp">
                                Jugadores
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaArbitros.jsp">
                                Arbitros
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaCampos.jsp">
                                Campos
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaNovedades.jsp">
                                Novedades
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="/Furtgolito/Principal.jsp">
                                Inicio
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaPartidos.jsp">
                                Jornadas y partidos
                            </a>
                        </li>
                        <li>
                            <a href="">
                                Tabla posiciones
                            </a> 
                        </li>
                        <li>
                            <a href="/Furtgolito/TablaGoleadores.jsp">
                                Tabla goleadores
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaEquipos.jsp">
                                Equipos
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaJugadores.jsp">
                                Jugadores
                            </a>
                        </li>
                        <li>
                            <a href="/Furtgolito/ListaArbitros.jsp">
                                Arbitros
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </body>
</html>
