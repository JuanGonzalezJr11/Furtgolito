/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.GestorBaseDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Equipo;
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
            g.eliminarGolesPorPartido(idPartido);
            g.eliminarTarjetasAmarillasPorPartido(idPartido);
            g.eliminarTarjetasRojasPorPartido(idPartido);
            Partido p = new Partido();
            p = g.obtenerPartidoPorId(idPartido);
            Equipo equipoGanador = p.getEquipoGanador();
            if(equipoGanador != null){
                int puntosEquipoGanador = equipoGanador.getPuntos();
                int puntosNuevosEquipoGanador = puntosEquipoGanador - 3;
                g.asignarPuntos(equipoGanador.getIdEquipo(), puntosNuevosEquipoGanador);
            }
            if(equipoGanador == null && p.getEquipoLocal().getPuntos() != 0 && p.getEquipoVisitante().getPuntos() != 0){
                int puntosEquipoLocal = p.getEquipoLocal().getPuntos();
                int puntosEquipoVisitante = p.getEquipoVisitante().getPuntos();
                int puntosNuevosEquipoLocal = puntosEquipoLocal - 1;
                int puntosNuevosEquipoVisitante = puntosEquipoVisitante - 1;
                g.asignarPuntos(p.getEquipoLocal().getIdEquipo(), puntosNuevosEquipoLocal);
                g.asignarPuntos(p.getEquipoVisitante().getIdEquipo(), puntosNuevosEquipoVisitante);
            }
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
