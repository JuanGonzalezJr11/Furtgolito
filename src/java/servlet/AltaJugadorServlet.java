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
import modelo.Jugador;
import modelo.PosicionJugador;

/**
 *
 * @author JuanG
 */
@WebServlet(name = "AltaJugadorServlet", urlPatterns = {"/AltaJugadorServlet"})
public class AltaJugadorServlet extends HttpServlet {

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
            out.println("<title>Servlet AltaJugadorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaJugadorServlet at " + request.getContextPath() + "</h1>");
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
        String idEquipo = (String) request.getParameter("idEquipo");
        int equipo = Integer.parseInt(idEquipo);
        Equipo e = new Equipo();
        e = g.obtenerEquipo(equipo);
        request.setAttribute("equipo", e);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AltaJugador.jsp");
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
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int edad = Integer.parseInt(request.getParameter("txtEdad"));
        String idPosicionJugador = request.getParameter("cboPosicionJugador");
        PosicionJugador posicionJugador = g.obtenerPosicionJugador(Integer.parseInt(idPosicionJugador));
        int dorsal = Integer.parseInt(request.getParameter("txtDorsal"));
        int idEquipo = Integer.parseInt(request.getParameter("cboEquipo"));
        Equipo equipo = g.obtenerEquipo(idEquipo);
        boolean capitan = Boolean.parseBoolean(request.getParameter("cboCapitan"));
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");
        g.altaJugador(new Jugador(nombre, apellido, edad, posicionJugador, dorsal, equipo, capitan, telefono, email));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListaJugadores.jsp");
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
