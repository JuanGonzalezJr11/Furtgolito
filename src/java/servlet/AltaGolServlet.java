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
import modelo.Gol;
import modelo.Jugador;
import modelo.Partido;

/**
 *
 * @author JuanG
 */
@WebServlet(name = "AltaGolServlet", urlPatterns = {"/AltaGolServlet"})
public class AltaGolServlet extends HttpServlet {

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
            out.println("<title>Servlet AltaGolServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaGolServlet at " + request.getContextPath() + "</h1>");
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
        String idPartido = (String) request.getParameter("idPartido");
        int partido = Integer.parseInt(idPartido);
        Partido p = new Partido();
        p = g.obtenerPartidoPorId(partido);
        request.setAttribute("partido", p);
        ArrayList<Jugador> j = g.obtenerJugadorPorPartido(partido);
        request.setAttribute("jugador", j);
        ArrayList<Gol> gol = g.listaGolesPorPartido(partido);
        request.setAttribute("gol", gol);
        int cantidadGoles = g.cantidadGoles(partido);
        request.setAttribute("cantidadGoles", cantidadGoles);
        int cantidadGolesLocalYVisitante = g.cantidadGolesLocalYVisitante(partido);
        request.setAttribute("cantidadGolesLYV", cantidadGolesLocalYVisitante);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AltaGol.jsp");
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
        String idJugador = request.getParameter("cboJugador");
        Jugador jugador = g.obtenerJugadorPorId(Integer.parseInt(idJugador));
        int minuto = Integer.parseInt((String) request.getParameter("txtMinuto"));
        String idPartido = request.getParameter("txtIdPartido");
        Partido partido = g.obtenerPartidoPorId(Integer.parseInt(idPartido));
        String[] contra = request.getParameterValues("chkContra");
        if(contra != null){
            boolean contra2 = false;
        }
        else{
            boolean contra2 = true;
        }
        g.altaGol(new Gol(jugador, minuto, partido, contra));
        response.sendRedirect("/Furtgolito/AltaGolServlet?idPartido="+idPartido);
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
