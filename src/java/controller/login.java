/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.usuario;
import modelDAO.usuarioDAO;

/**
 *
 * @author JonaC
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    usuarioDAO dao= new usuarioDAO();
    usuario user = new usuario();
    int resultado;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion=request.getParameter("accion");
        if(accion.equals("Entrar")){
        String email=request.getParameter("email");
        String pass=request.getParameter("pass");
        System.out.println("LOS DATOS OBTENIDOS SON: "+email+"///"+pass);
        user.setEmail(email);
        user.setPassword(pass);
        resultado=dao.validar(user);
        if (resultado>0) {
            //HttpSession sesion = request.getSession();
            request.getSession().setAttribute("usuario", user.getNombres()+" "+user.getApellidos());
            //sesion.setAttribute("usuario", user.getNombres());
            int tipo=user.getTipo();
            if (tipo==1)
            {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }   
            else if(tipo==2)
            {
                request.getRequestDispatcher("vhome.jsp").forward(request, response);

            }
             else if(tipo==3)
            {
                request.getRequestDispatcher("chome.jsp").forward(request, response);

            }
        }
        else if (resultado<1)
        {
            request.getRequestDispatcher("view/manager/nologin.jsp").forward(request, response);
            //HttpSession sesion = request.getSession();
            //sesion.invalidate();
        }
        }
        else if (accion.equals("salir"))
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
