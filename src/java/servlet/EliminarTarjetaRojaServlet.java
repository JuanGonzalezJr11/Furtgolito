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
@WebServlet(name = "EliminarTarjetaRojaServlet", urlPatterns = {"/EliminarTarjetaRojaServlet"})
public class EliminarTarjetaRojaServlet extends HttpServlet {

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
            String borrarIdTarjetaRoja = (String) request.getParameter("idTarjetaRoja");
            int idTarjetaRoja = Integer.parseInt(borrarIdTarjetaRoja);
            GestorBaseDatos g = new GestorBaseDatos();
            TarjetaRoja tr = g.obtenerTarjetaRojaPorId(idTarjetaRoja);
            int opcion = 1;
            g.jugadorSuspendido(tr.getJugador().getIdJugador(), opcion);
            ArrayList<TarjetaAmarilla> ta = g.listaTarjetasAmarillasPorPartido(Integer.parseInt(idPartido));
            for (TarjetaAmarilla tarjetaAmarilla : ta) {
                if(tarjetaAmarilla.getJugador().getIdJugador() == tr.getJugador().getIdJugador() && tarjetaAmarilla.getMinuto() == tr.getMinuto()){
                    g.eliminarTarjetaAmarilla(tarjetaAmarilla.getIdTarjetaAmarilla());
                }
            }
            g.eliminarTarjetaRoja(idTarjetaRoja);
            response.sendRedirect("/Furtgolito/CargarDetallesResultadoPartidoServlet?idPartido="+idPartido);
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
