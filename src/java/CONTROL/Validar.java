/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CONTROL;

import MODELO.dao.EmpleadoDAO;
import MODELO.dto.EmpleadoDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class Validar extends HttpServlet {
    EmpleadoDAO edao = new EmpleadoDAO();
    EmpleadoDTO emdto = new EmpleadoDTO();
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
            throws ServletException, IOException{
        String accion = request.getParameter("btn_enviar");
        String flag_login = "true";
        request.setAttribute("error_login", flag_login);
        if (accion.equalsIgnoreCase("Ingresar")){
            String user = request.getParameter("txt_nombre");
            String contra = request.getParameter("txt_password");
            emdto = edao.validar(user, contra);
            String id_empl = emdto.getId()+"";
            
            if(emdto.getUser() != null){
                request.setAttribute("usuario", emdto);
                request.getRequestDispatcher("Controlador?menu=Principal&id="+id_empl).forward(request, response);
            } else {
                flag_login = "false";
                request.setAttribute("error_login", flag_login);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            flag_login = "false";
            request.setAttribute("error_login", flag_login);
        }
        request.setAttribute("error_login", flag_login);
        
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
