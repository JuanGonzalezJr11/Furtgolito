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
import modelo.TarjetaAmarilla;
import modelo.TarjetaRoja;

/**
 *
 * @author JuanG
 */
@WebServlet(name = "CargarDetallesResultadoPartidoServlet", urlPatterns = {"/CargarDetallesResultadoPartidoServlet"})
public class CargarDetallesResultadoPartidoServlet extends HttpServlet {

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
            out.println("<title>Servlet CargarDetallesResultadoPartidoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CargarDetallesResultadoPartidoServlet at " + request.getContextPath() + "</h1>");
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
        // GOLES:
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
        
        // TARJETAS AMARILLAS:
        ArrayList<TarjetaAmarilla> ta = g.listaTarjetasAmarillasPorPartido(partido);
        request.setAttribute("tarjetaAmarilla", ta);
        int cantidadTarjetasAmarillas = g.cantidadTarjetasAmarillas(partido);
        request.setAttribute("cantidadTarjetasAmarillas", cantidadTarjetasAmarillas);
        
        // TARJETAS ROJAS:
        ArrayList<TarjetaRoja> tr = g.listaTarjetasRojasPorPartido(partido);
        request.setAttribute("tarjetaRoja", tr);
        int cantidadTarjetasRojas = g.cantidadTarjetasRojas(partido);
        request.setAttribute("cantidadTarjetasRojas", cantidadTarjetasRojas);
        
        // MVP:
        ArrayList<Jugador> mvp = g.obtenerMvpPorPartido(partido);
        request.setAttribute("mvp", mvp);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/CargarDetallesResultadoPartido.jsp");
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
