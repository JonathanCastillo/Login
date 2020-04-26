package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.usuario;
import modelDAO.usuarioDAO;

/**
 *
 * @author JonaC
 */
@WebServlet(urlPatterns = {"/users"})
public class users extends HttpServlet {
    String view="view/master/view_users.jsp";
    String edit="view/master/edit_users.jsp";
    String add="view/master/add_user.jsp";
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //RequestDispatcher vista = request.getRequestDispatcher(accion);
        //vista.forward(request, response);
        //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);

        /*
          String access="";
        String accion=request.getParameter("accion");
        System.out.println("LLEGANDO A CONTROLADOR");
        if (accion.equals("listar")) 
        {
            access=view;
           // request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
        }
        //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
        RequestDispatcher vista =request.getRequestDispatcher(accion);
        vista.forward(request, response);
        */
     
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
        int id;
        String access="";
        //Instanciamos la clase usuario y la clase DAO tambien
        usuario user = new usuario();
        usuarioDAO dao=new usuarioDAO();
        String accion=request.getParameter("accion");
        switch (accion) {
              case "home":
                {   
                    RequestDispatcher vista = request.getRequestDispatcher("home.jsp");
                    vista.forward(request, response);
                    //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
                    break;
                }
                
            case "listar":
                {
                    RequestDispatcher vista = request.getRequestDispatcher("view/master/view_users.jsp");
                    vista.forward(request, response);
                    //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
                    break;
                }
            case "agregar":
                {
                    RequestDispatcher vista = request.getRequestDispatcher("view/master/add_user.jsp");
                    vista.forward(request, response);
                    //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
                    break;
                }
            case "Adduser":
                {
                    String nombres=request.getParameter("nombres");
                    String apellidos=request.getParameter("apellidos");
                    String username=request.getParameter("username");
                    String email=request.getParameter("email");
                    String password=request.getParameter("password");
                    String tipo=request.getParameter("tipo");
                    String foto=request.getParameter("foto");
                    //Llenamos la clase usuario
                    user.setNombres(nombres);
                    user.setApellidos(apellidos);
                    user.setUser_name(username);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setTipo(Integer.parseInt(tipo));
                    user.setFoto(foto);
                    //
                    dao.add(user);
                    RequestDispatcher vista = request.getRequestDispatcher("view/master/view_users.jsp");
                    vista.forward(request, response);
                    //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
                    break;
                }
            case "edit":
                {
                    request.setAttribute("id", request.getParameter("id"));
                    RequestDispatcher vista = request.getRequestDispatcher("view/master/edit_users.jsp");
                    vista.forward(request, response);
                    //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
                    break;
                }
            case "Actualizar":
                {
                    //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
                    id=Integer.parseInt(request.getParameter("idusuario"));
                    String nombres=request.getParameter("nombres");
                    String apellidos=request.getParameter("apellidos");
                    String username=request.getParameter("username");
                    String email=request.getParameter("email");
                    String password=request.getParameter("password");
                    String tipo=request.getParameter("tipo");
                    String foto=request.getParameter("foto");
                    //Llenamos la clase usuario
                    user.setId_usuario(id);
                    user.setNombres(nombres);
                    user.setApellidos(apellidos);
                    user.setUser_name(username);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setTipo(Integer.parseInt(tipo));
                    user.setFoto(foto);
                    dao.edit(user);
                    RequestDispatcher vista = request.getRequestDispatcher("view/master/view_users.jsp");
                    vista.forward(request, response);
                    break;
                }
            case "delete":
                {   
                    id=Integer.parseInt(request.getParameter("id"));
                    user.setId_usuario(id);
                    dao.delete(id);
                    RequestDispatcher vista = request.getRequestDispatcher("view/master/view_users.jsp");
                    vista.forward(request, response);
                    System.out.println("LLEGANDO A DELETE: " +id);
                    break;
                }
          
            default:
                break;
        }
        
        
        
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
