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

/**
 *
 * @author JuanG
 */
@WebServlet(name = "ModificarArbitroServlet", urlPatterns = {"/ModificarArbitroServlet"})
public class ModificarArbitroServlet extends HttpServlet {

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
            out.println("<title>Servlet ModificarArbitro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarArbitro at " + request.getContextPath() + "</h1>");
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
        String modificarIdArbitro = (String) request.getParameter("idArbitro");
        int idArbitro = Integer.parseInt(modificarIdArbitro);
        Arbitro a = new Arbitro();
        a = g.obtenerArbitroPorId(idArbitro);
        request.setAttribute("arbitro", a);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ModificarArbitro.jsp");
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
        int idArbitro = Integer.parseInt((String) request.getParameter("txtIdArbitro"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");
        g.modificarArbitro(new Arbitro(idArbitro, nombre, apellido,telefono, email));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListaArbitros.jsp");
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
