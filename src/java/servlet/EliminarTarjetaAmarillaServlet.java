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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.TarjetaAmarilla;
import modelo.TarjetaRoja;

/**
 *
 * @author JuanG
 */
@WebServlet(name = "EliminarTarjetaAmarillaServlet", urlPatterns = {"/EliminarTarjetaAmarillaServlet"})
public class EliminarTarjetaAmarillaServlet extends HttpServlet {

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
            String idPartido = request.getParameter("idPartido");
            String borrarIdTarjetaAmarilla = (String) request.getParameter("idTarjetaAmarilla");
            int idTarjetaAmarilla = Integer.parseInt(borrarIdTarjetaAmarilla);
            GestorBaseDatos g = new GestorBaseDatos();
            TarjetaAmarilla ta = g.obtenerTarjetaAmarillaPorId(idTarjetaAmarilla);
            ArrayList<TarjetaRoja> ltr = g.listaTarjetasRojasPorPartido(Integer.parseInt(idPartido));
            for (TarjetaRoja tarjetaRoja : ltr) {
                if (ta.getJugador().getIdJugador() == tarjetaRoja.getJugador().getIdJugador() && tarjetaRoja.getMotivo().equals("Doble tarjeta amarilla.")) {
                    int opcion = 1;
                    g.jugadorSuspendido(tarjetaRoja.getJugador().getIdJugador(), opcion);
                    g.eliminarTarjetaRoja(tarjetaRoja.getIdTarjetaRoja());
                }
            }
            g.eliminarTarjetaAmarilla(idTarjetaAmarilla);
            response.sendRedirect("/Furtgolito/CargarDetallesResultadoPartidoServlet?idPartido=" + idPartido);
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
