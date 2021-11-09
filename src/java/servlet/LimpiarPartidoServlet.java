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
@WebServlet(name = "LimpiarPartidoServlet", urlPatterns = {"/LimpiarPartidoServlet"})
public class LimpiarPartidoServlet extends HttpServlet {

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
            String limpiarIdPartido = request.getParameter("idPartido");
            int idPartido = Integer.parseInt(limpiarIdPartido);
            GestorBaseDatos g = new GestorBaseDatos();
            g.eliminarTarjetasAmarillasPorPartido(idPartido);
            g.eliminarTarjetasRojasPorPartido(idPartido);
            ArrayList<Jugador> ljs = g.listaJugadoresSuspendidosPorPartido(idPartido);
            for (Jugador lj : ljs) {
                int opcion = 1;
                g.jugadorSuspendido(lj.getIdJugador(), opcion);
            }
            Partido p = new Partido();
            p = g.obtenerPartidoPorId(idPartido);
            Equipo equipoGanador = p.getEquipoGanador();
            Equipo equipoPerdedor = p.getEquipoPerdedor();
            int cantidadGolesPorPartidoEquipoGanador = g.cantidadGolesPorPartidoEquipoGanador(idPartido);
            int cantidadGolesContraPorPartidoEquipoGanador = g.cantidadGolesContraPorPartidoEquipoGanador(idPartido);
            int cantidadGolesPorPartidoEquipoPerdedor = g.cantidadGolesPorPartidoEquipoPerdedor(idPartido);
            int cantidadGolesContraPorPartidoEquipoPerdedor = g.cantidadGolesContraPorPartidoEquipoPerdedor(idPartido);
            int cantidadGolesPorPartidoEquipoLocal = g.cantidadGolesPorPartidoEquipoLocal(idPartido);
            int cantidadGolesContraPorPartidoEquipoLocal = g.cantidadGolesContraPorPartidoEquipoLocal(idPartido);
            int cantidadGolesPorPartidoEquipoVisitante = g.cantidadGolesPorPartidoEquipoVisitante(idPartido);
            int cantidadGolesContraPorPartidoEquipoVisitante = g.cantidadGolesContraPorPartidoEquipoVisitante(idPartido);
            if(equipoGanador != null){
                int puntosEquipoGanador = equipoGanador.getPuntos();
                int puntosNuevosEquipoGanador = puntosEquipoGanador - 3;
                g.asignarPuntos(equipoGanador.getIdEquipo(), puntosNuevosEquipoGanador);
                int partidosJugadosGanador = equipoGanador.getPartidosJugados();
                int nuevoPartidosJugadosGanador = partidosJugadosGanador - 1;
                g.partidoJugado(equipoGanador.getIdEquipo(), nuevoPartidosJugadosGanador);
                int partidosGanadosGanador = equipoGanador.getPartidosGanados();
                int nuevoPartidosGanadosGanador = partidosGanadosGanador - 1;
                g.partidoGanado(equipoGanador.getIdEquipo(), nuevoPartidosGanadosGanador);
                int partidosJugadosPerdedor = equipoPerdedor.getPartidosJugados();
                int nuevoPartidosJugadosPerdedor = partidosJugadosPerdedor - 1;
                g.partidoJugado(equipoPerdedor.getIdEquipo(), nuevoPartidosJugadosPerdedor);
                int partidosPerdidosPerdedor = equipoPerdedor.getPartidosPerdidos();
                int nuevoPartidosPerdidosPerdedor = partidosPerdidosPerdedor - 1;
                g.partidoPerdido(equipoPerdedor.getIdEquipo(), nuevoPartidosPerdidosPerdedor);
                int golesFavorGanador = equipoGanador.getGolesFavor();
                int nuevoGolesFavorGanador = golesFavorGanador - (cantidadGolesPorPartidoEquipoGanador + cantidadGolesContraPorPartidoEquipoPerdedor);
                g.golesFavor(equipoGanador.getIdEquipo(), nuevoGolesFavorGanador);
                int golesContraGanador = equipoGanador.getGolesContra();
                int nuevoGolesContraGanador = golesContraGanador - (cantidadGolesPorPartidoEquipoPerdedor + cantidadGolesContraPorPartidoEquipoGanador);
                g.golesContra(equipoGanador.getIdEquipo(), nuevoGolesContraGanador);
                int golesContraPerdedor = equipoPerdedor.getGolesContra();
                int nuevoGolesContraPerdedor = golesContraPerdedor - (cantidadGolesPorPartidoEquipoGanador + cantidadGolesContraPorPartidoEquipoPerdedor);
                g.golesContra(equipoPerdedor.getIdEquipo(), nuevoGolesContraPerdedor);
                int golesFavorPerdedor = equipoPerdedor.getGolesFavor();
                int nuevoGolesFavorPerdedor = golesFavorPerdedor - (cantidadGolesPorPartidoEquipoPerdedor + cantidadGolesContraPorPartidoEquipoGanador);
                g.golesFavor(equipoPerdedor.getIdEquipo(), nuevoGolesFavorPerdedor);
                g.diferenciaGoles(equipoGanador.getIdEquipo());
                g.diferenciaGoles(equipoPerdedor.getIdEquipo());
            }
            if(equipoGanador == null && p.getEquipoLocal().getPuntos() != 0 && p.getEquipoVisitante().getPuntos() != 0){
                int puntosEquipoLocal = p.getEquipoLocal().getPuntos();
                int puntosEquipoVisitante = p.getEquipoVisitante().getPuntos();
                int puntosNuevosEquipoLocal = puntosEquipoLocal - 1;
                int puntosNuevosEquipoVisitante = puntosEquipoVisitante - 1;
                g.asignarPuntos(p.getEquipoLocal().getIdEquipo(), puntosNuevosEquipoLocal);
                g.asignarPuntos(p.getEquipoVisitante().getIdEquipo(), puntosNuevosEquipoVisitante);
                int partidosJugadosLocal = p.getEquipoLocal().getPartidosJugados();
                int nuevoPartidosJugadosLocal = partidosJugadosLocal - 1;
                g.partidoJugado(p.getEquipoLocal().getIdEquipo(), nuevoPartidosJugadosLocal);
                int partidosJugadosVisitante = p.getEquipoVisitante().getPartidosJugados();
                int nuevoPartidosJugadosVisitante = partidosJugadosVisitante - 1;
                g.partidoJugado(p.getEquipoVisitante().getIdEquipo(), nuevoPartidosJugadosVisitante);
                int partidosEmpatadosLocal = p.getEquipoLocal().getPartidosEmpatados();
                int nuevoPartidosEmpatadosLocal = partidosEmpatadosLocal - 1;
                g.partidoEmpatado(p.getEquipoLocal().getIdEquipo(), nuevoPartidosEmpatadosLocal);
                int partidosEmpatadosVisitante = p.getEquipoVisitante().getPartidosEmpatados();
                int nuevoPartidosEmpatadosVisitante = partidosEmpatadosVisitante - 1;
                g.partidoEmpatado(p.getEquipoVisitante().getIdEquipo(), nuevoPartidosEmpatadosVisitante);
                int golesFavorLocal = p.getEquipoLocal().getGolesFavor();
                int nuevoGolesFavorLocal = golesFavorLocal - (cantidadGolesPorPartidoEquipoLocal + cantidadGolesContraPorPartidoEquipoVisitante);
                g.golesFavor(p.getEquipoLocal().getIdEquipo(), nuevoGolesFavorLocal);
                int golesContraLocal = p.getEquipoLocal().getGolesContra();
                int nuevoGolesContraLocal = golesContraLocal - (cantidadGolesPorPartidoEquipoVisitante + cantidadGolesContraPorPartidoEquipoLocal);
                g.golesContra(p.getEquipoLocal().getIdEquipo(), nuevoGolesContraLocal);
                int golesContraVisitante = p.getEquipoVisitante().getGolesContra();
                int nuevoGolesContraVisitante = golesContraVisitante - (cantidadGolesPorPartidoEquipoLocal + cantidadGolesContraPorPartidoEquipoVisitante);
                g.golesContra(p.getEquipoVisitante().getIdEquipo(), nuevoGolesContraVisitante);
                int golesFavorVisitante = p.getEquipoVisitante().getGolesFavor();
                int nuevoGolesFavorVisitante = golesFavorVisitante - (cantidadGolesPorPartidoEquipoVisitante + cantidadGolesContraPorPartidoEquipoLocal);
                g.golesFavor(p.getEquipoVisitante().getIdEquipo(), nuevoGolesFavorVisitante);
                g.diferenciaGoles(p.getEquipoLocal().getIdEquipo());
                g.diferenciaGoles(p.getEquipoVisitante().getIdEquipo());
            }
            g.eliminarGolesPorPartido(idPartido);
            g.eliminarResultadoPartidoPorPartido(idPartido);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListaPartidos.jsp");
            rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
