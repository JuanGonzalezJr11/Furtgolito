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
import modelo.Partido;
import modelo.TarjetaAmarilla;
import modelo.TarjetaRoja;

/**
 *
 * @author JuanG
 */
@WebServlet(name = "DetallesPartidoServlet", urlPatterns = {"/DetallesPartidoServlet"})
public class DetallesPartidoServlet extends HttpServlet {

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
            out.println("<title>Servlet DetallesPartidoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetallesPartidoServlet at " + request.getContextPath() + "</h1>");
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
        String IdPartido = (String) request.getParameter("idPartido");
        int idPartido = Integer.parseInt(IdPartido);
        Partido p = new Partido();
        p = g.obtenerPartidoPorId(idPartido);
        request.setAttribute("partido", p);
        ArrayList<Gol> gol = g.listaGolesPorPartido(idPartido);
        request.setAttribute("gol", gol);
        int cantidadGoles = g.cantidadGoles(idPartido);
        request.setAttribute("cantidadGoles", cantidadGoles);
        ArrayList<TarjetaAmarilla> ta = g.listaTarjetasAmarillasPorPartido(idPartido);
        request.setAttribute("tarjetaAmarilla", ta);
        int cantidadTarjetasAmarillas = g.cantidadTarjetasAmarillas(idPartido);
        request.setAttribute("cantidadTarjetasAmarillas", cantidadTarjetasAmarillas);
        ArrayList<TarjetaRoja> tr = g.listaTarjetasRojasPorPartido(idPartido);
        request.setAttribute("tarjetaRoja", tr);
        int cantidadTarjetasRojas = g.cantidadTarjetasRojas(idPartido);
        request.setAttribute("cantidadTarjetasRojas", cantidadTarjetasRojas);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/DetallesPartido.jsp");
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
