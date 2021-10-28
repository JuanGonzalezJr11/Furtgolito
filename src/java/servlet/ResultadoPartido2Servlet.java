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
import modelo.Jugador;
import modelo.Partido;
import modelo.TarjetaAmarilla;

/**
 *
 * @author JuanG
 */
@WebServlet(name = "ResultadoPartido2Servlet", urlPatterns = {"/ResultadoPartido2Servlet"})
public class ResultadoPartido2Servlet extends HttpServlet {

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
            out.println("<title>Servlet ResultadoPartido2Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResultadoPartido2Servlet at " + request.getContextPath() + "</h1>");
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
        ArrayList<Jugador> j = g.obtenerJugadorPorPartido(idPartido);
        request.setAttribute("mvp", j);
        // Tarjeta amarilla:
        request.setAttribute("amonestado", j);
        
        // Redirección:
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ResultadoPartido2.jsp");
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
        String idMvp = request.getParameter("cboMvp");
        Jugador mvp = g.obtenerMvp(Integer.parseInt(idMvp));
        g.resultadoPartido(new Partido(idPartido, mvp, resultadoEquipoLocal, resultadoEquipoVisitante));
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
