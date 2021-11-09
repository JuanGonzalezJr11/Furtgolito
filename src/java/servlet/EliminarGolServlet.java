/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.GestorBaseDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Equipo;
import modelo.Gol;
import modelo.Partido;

/**
 *
 * @author JuanG
 */
@WebServlet(name = "EliminarGolServlet", urlPatterns = {"/EliminarGolServlet"})
public class EliminarGolServlet extends HttpServlet {

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
            String borrarIdGol = (String) request.getParameter("idGol");
            int idGol = Integer.parseInt(borrarIdGol);
            GestorBaseDatos g = new GestorBaseDatos();
            Partido p = new Partido();
            p = g.obtenerPartidoPorId(Integer.parseInt(idPartido));
            Equipo equipoLocal = p.getEquipoLocal();
            Equipo equipoVisitante = p.getEquipoVisitante();
            Gol gol = new Gol();
            gol = g.obtenerGolPorId(idGol);
            if(gol.getJugador().getEquipo().getIdEquipo() == equipoLocal.getIdEquipo() && gol.isContra() == false || gol.getJugador().getEquipo().getIdEquipo() == equipoVisitante.getIdEquipo() && gol.isContra() == true){
                int golesFavorLocal = equipoLocal.getGolesFavor();
                int nuevoGolesFavorLocal = golesFavorLocal - 1;
                g.golesFavor(equipoLocal.getIdEquipo(), nuevoGolesFavorLocal);
                int golesContraVisitante = equipoVisitante.getGolesContra();
                int nuevoGolesContraVisitante = golesContraVisitante - 1;
                g.golesContra(equipoVisitante.getIdEquipo(), nuevoGolesContraVisitante);
                g.diferenciaGoles(equipoLocal.getIdEquipo());
                g.diferenciaGoles(equipoVisitante.getIdEquipo());
            }
            if(gol.getJugador().getEquipo().getIdEquipo() == equipoVisitante.getIdEquipo() && gol.isContra() == false || gol.getJugador().getEquipo().getIdEquipo() == equipoLocal.getIdEquipo() && gol.isContra() == true){
                int golesContraLocal = equipoLocal.getGolesContra();
                int nuevoGolesContraLocal = golesContraLocal - 1;
                g.golesContra(equipoLocal.getIdEquipo(), nuevoGolesContraLocal);
                int golesFavorVisitante = equipoVisitante.getGolesFavor();
                int nuevoGolesFavorVisitante = golesFavorVisitante - 1;
                g.golesFavor(equipoVisitante.getIdEquipo(), nuevoGolesFavorVisitante);
                g.diferenciaGoles(equipoLocal.getIdEquipo());
                g.diferenciaGoles(equipoVisitante.getIdEquipo());
            }
            g.eliminarGol(idGol);
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
