/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.GestorBaseDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Partido;

/**
 *
 * @author JuanG
 */
@WebServlet(name = "ResultadoPartidoServlet", urlPatterns = {"/ResultadoPartidoServlet"})
public class ResultadoPartidoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultadoPartidoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResultadoPartidoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorBaseDatos g = new GestorBaseDatos();
        String resultadoIdPartido = (String) request.getParameter("idPartido");
        int idPartido = Integer.parseInt(resultadoIdPartido);
        Partido p = new Partido();
        p = g.obtenerPartidoPorId(idPartido);
        request.setAttribute("partido", p);
        /*ArrayList<Jugador> j = g.obtenerJugadorPorPartido(idPartido);
        request.setAttribute("mvp", j);*/
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ResultadoPartido.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorBaseDatos g = new GestorBaseDatos();
        int idPartido = Integer.parseInt((String) request.getParameter("txtIdPartido"));
        int resultadoEquipoLocal = Integer.parseInt((String) request.getParameter("txtResultadoEquipoLocal"));
        int resultadoEquipoVisitante = Integer.parseInt((String) request.getParameter("txtResultadoEquipoVisitante"));
        /*String idMvp = request.getParameter("cboMvp");
        Jugador mvp = g.obtenerMvp(Integer.parseInt(idMvp));*/
        Partido p = new Partido();
        p = g.obtenerPartidoPorId(idPartido);
        Equipo equipoGanador = null;
        Equipo equipoPerdedor = null;
        /* if (resultadoEquipoLocal > resultadoEquipoVisitante) {
            equipoGanador = p.getEquipoLocal();
            equipoPerdedor = p.getEquipoVisitante();
            int puntosEquipoGanador = equipoGanador.getPuntos();
            int puntosEquipoPerdedor = equipoPerdedor.getPuntos();
            int puntosNuevosEquipoGanador = puntosEquipoGanador + 3;
            int puntosNuevosEquipoPerdedor = puntosEquipoPerdedor + 0;
            g.asignarPuntos(equipoGanador.getIdEquipo(), puntosNuevosEquipoGanador);
            g.asignarPuntos(equipoPerdedor.getIdEquipo(), puntosNuevosEquipoPerdedor);
            g.resultadoPartido(new Partido(idPartido, mvp, resultadoEquipoLocal, resultadoEquipoVisitante, equipoGanador, equipoPerdedor));
        }
        if (resultadoEquipoLocal < resultadoEquipoVisitante) {
            equipoGanador = p.getEquipoVisitante();
            equipoPerdedor = p.getEquipoLocal();
            int puntosEquipoGanador = equipoGanador.getPuntos();
            int puntosEquipoPerdedor = equipoPerdedor.getPuntos();
            int puntosNuevosEquipoGanador = puntosEquipoGanador + 3;
            int puntosNuevosEquipoPerdedor = puntosEquipoPerdedor + 0;
            g.asignarPuntos(equipoGanador.getIdEquipo(), puntosNuevosEquipoGanador);
            g.asignarPuntos(equipoPerdedor.getIdEquipo(), puntosNuevosEquipoPerdedor);
            g.resultadoPartido(new Partido(idPartido, mvp, resultadoEquipoLocal, resultadoEquipoVisitante, equipoGanador, equipoPerdedor));
        }
        if (resultadoEquipoLocal == resultadoEquipoVisitante) {
            equipoGanador = null;
            equipoPerdedor = null;
            int puntosEquipoLocal = p.getEquipoLocal().getPuntos();
            int puntosEquipoVisitante = p.getEquipoVisitante().getPuntos();
            int puntosNuevosEquipoLocal = puntosEquipoLocal + 1;
            int puntosNuevosEquipoVisitante = puntosEquipoVisitante + 1;
            g.asignarPuntos(p.getEquipoLocal().getIdEquipo(), puntosNuevosEquipoLocal);
            g.asignarPuntos(p.getEquipoVisitante().getIdEquipo(), puntosNuevosEquipoVisitante);
            g.resultadoPartidoSinGanador(new Partido(idPartido, mvp, resultadoEquipoLocal, resultadoEquipoVisitante));
        }*/
        
        //EDICION:XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        if (resultadoEquipoLocal > resultadoEquipoVisitante) {
            equipoGanador = p.getEquipoLocal();
            equipoPerdedor = p.getEquipoVisitante();
            int partidosJugadosLocal = equipoGanador.getPartidosJugados();
            int nuevoPartidoJugadoLocal = partidosJugadosLocal + 1;
            int partidosJugadosVisitante = equipoPerdedor.getPartidosJugados();
            int nuevoPartidoJugadoVisitante = partidosJugadosVisitante + 1;
            int partidosGanadosLocal = equipoGanador.getPartidosGanados();
            int nuevoPartidoGanadoLocal = partidosGanadosLocal + 1;
            int partidosPerdidosVisitante = equipoPerdedor.getPartidosPerdidos();
            int nuevoPartidoPerdidoVisitante = partidosPerdidosVisitante +1;
            int puntosEquipoGanador = equipoGanador.getPuntos();
            int puntosNuevosEquipoGanador = puntosEquipoGanador + 3;
            int puntosEquipoPerdedor = equipoPerdedor.getPuntos();
            int puntosNuevosEquipoPerdedor = puntosEquipoPerdedor + 0;
            g.partidoJugado(p.getEquipoLocal().getIdEquipo(), nuevoPartidoJugadoLocal);
            g.partidoJugado(p.getEquipoVisitante().getIdEquipo(), nuevoPartidoJugadoVisitante);
            g.partidoGanado(equipoGanador.getIdEquipo(), nuevoPartidoGanadoLocal);
            g.partidoPerdido(equipoPerdedor.getIdEquipo(), nuevoPartidoPerdidoVisitante);
            g.asignarPuntos(equipoGanador.getIdEquipo(), puntosNuevosEquipoGanador);
            g.asignarPuntos(equipoPerdedor.getIdEquipo(), puntosNuevosEquipoPerdedor);
            g.resultadoPartido(new Partido(idPartido, resultadoEquipoLocal, resultadoEquipoVisitante, equipoGanador, equipoPerdedor));
        }
        if (resultadoEquipoLocal < resultadoEquipoVisitante) {
            equipoGanador = p.getEquipoVisitante();
            equipoPerdedor = p.getEquipoLocal();
            int partidosJugadosLocal = equipoPerdedor.getPartidosJugados();
            int nuevoPartidoJugadoLocal = partidosJugadosLocal + 1;
            int partidosJugadosVisitante = equipoGanador.getPartidosJugados();
            int nuevoPartidoJugadoVisitante = partidosJugadosVisitante + 1;
            int partidosPerdidosLocal = equipoPerdedor.getPartidosPerdidos();
            int nuevoPartidoPerdidoLocal = partidosPerdidosLocal + 1;
            int partidosGanadosVisitante = equipoGanador.getPartidosGanados();
            int nuevoPartidoGanadoVisitante = partidosGanadosVisitante +1;
            int puntosEquipoGanador = equipoGanador.getPuntos();
            int puntosNuevosEquipoGanador = puntosEquipoGanador + 3;
            int puntosEquipoPerdedor = equipoPerdedor.getPuntos();
            int puntosNuevosEquipoPerdedor = puntosEquipoPerdedor + 0;
            g.partidoJugado(p.getEquipoLocal().getIdEquipo(), nuevoPartidoJugadoLocal);
            g.partidoJugado(p.getEquipoVisitante().getIdEquipo(), nuevoPartidoJugadoVisitante);
            g.partidoGanado(equipoGanador.getIdEquipo(), nuevoPartidoGanadoVisitante);
            g.partidoPerdido(equipoPerdedor.getIdEquipo(), nuevoPartidoPerdidoLocal);
            g.asignarPuntos(equipoGanador.getIdEquipo(), puntosNuevosEquipoGanador);
            g.asignarPuntos(equipoPerdedor.getIdEquipo(), puntosNuevosEquipoPerdedor);
            g.resultadoPartido(new Partido(idPartido, resultadoEquipoLocal, resultadoEquipoVisitante, equipoGanador, equipoPerdedor));
        }
        if (resultadoEquipoLocal == resultadoEquipoVisitante) {
            equipoGanador = null;
            equipoPerdedor = null;
            int partidoJugadoLocal = p.getEquipoLocal().getPartidosJugados();
            int nuevoPartidoJugadoLocal = partidoJugadoLocal + 1;
            int partidoJugadoVisitante = p.getEquipoVisitante().getPartidosJugados();
            int nuevoPartidoJugadoVisitante = partidoJugadoVisitante + 1;
            int partidosEmpatadosLocal = p.getEquipoLocal().getPartidosEmpatados();
            int nuevoPartidoEmpatadoLocal = partidosEmpatadosLocal + 1;
            int partidosEmpatadosVisitante = p.getEquipoVisitante().getPartidosEmpatados();
            int nuevoPartidoEmpatadoVisitante = partidosEmpatadosVisitante + 1;
            int puntosEquipoLocal = p.getEquipoLocal().getPuntos();
            int puntosNuevosEquipoLocal = puntosEquipoLocal + 1;
            int puntosEquipoVisitante = p.getEquipoVisitante().getPuntos();
            int puntosNuevosEquipoVisitante = puntosEquipoVisitante + 1;
            g.partidoJugado(p.getEquipoLocal().getIdEquipo(), nuevoPartidoJugadoLocal);
            g.partidoJugado(p.getEquipoVisitante().getIdEquipo(), nuevoPartidoJugadoVisitante);
            g.partidoEmpatado(p.getEquipoLocal().getIdEquipo(), nuevoPartidoEmpatadoLocal);
            g.partidoEmpatado(p.getEquipoVisitante().getIdEquipo(), nuevoPartidoEmpatadoVisitante);
            g.asignarPuntos(p.getEquipoLocal().getIdEquipo(), puntosNuevosEquipoLocal);
            g.asignarPuntos(p.getEquipoVisitante().getIdEquipo(), puntosNuevosEquipoVisitante);
            g.resultadoPartidoSinGanador(new Partido(idPartido, resultadoEquipoLocal, resultadoEquipoVisitante));
        }
        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListaPartidos.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
