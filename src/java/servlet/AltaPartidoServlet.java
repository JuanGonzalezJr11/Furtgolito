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
import modelo.Arbitro;
import modelo.Campo;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Partido;

/**
 *
 * @author JuanG
 */
@WebServlet(name = "AltaPartidoServlet", urlPatterns = {"/AltaPartidoServlet"})
public class AltaPartidoServlet extends HttpServlet {

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
            out.println("<title>Servlet AltaPartidoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaPartidoServlet at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AltaPartido.jsp");
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
        int jornada = Integer.parseInt(request.getParameter("txtJornada"));
        String fecha = request.getParameter("txtFecha");
        String hora = request.getParameter("txtHora");
        String idEquipoLocal = request.getParameter("cboEquipoLocal");
        Equipo equipoLocal = g.obtenerEquipo(Integer.parseInt(idEquipoLocal));
        String idEquipoVisitante = request.getParameter("cboEquipoVisitante");
        Equipo equipoVisitante = g.obtenerEquipo(Integer.parseInt(idEquipoVisitante));
        String idArbitro = request.getParameter("cboArbitro");
        Arbitro arbitro = g.obtenerArbitro(Integer.parseInt(idArbitro));
        String idCampo = request.getParameter("cboCampo");
        Campo campo = g.obtenerCampo(Integer.parseInt(idCampo));
        g.altaPartido(new Partido(fecha, hora, equipoLocal, equipoVisitante, arbitro, campo, jornada));
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
