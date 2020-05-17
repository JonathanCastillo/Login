/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.productos;
import modelDAO.productosDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author JonaC
 */
public class producto extends HttpServlet {

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
        //processRequest(request, response);
         String accion=request.getParameter("accion");
        productos p = new productos();
        productosDAO pDAO = new productosDAO();
        System.out.println("LLEGANDO A CONTROLADOR PRODUCTO: "+accion);
        
        switch (accion) {
            case "agregar":
                {
                    RequestDispatcher vista = request.getRequestDispatcher("view/master/productos/add_products.jsp");
                    vista.forward(request, response);
                    //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
                    break;
                }
              case "view":
                {
                    RequestDispatcher vista = request.getRequestDispatcher("view/master/productos/view_products.jsp");
                    vista.forward(request, response);
                    //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
                    break;
                }
                      case "edit":
                {
                    request.setAttribute("idp", request.getParameter("idp"));
                    RequestDispatcher vista = request.getRequestDispatcher("view/master/productos/edit_products.jsp");
                    vista.forward(request, response);
                    //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
                    break;
                }
              case "Guardar":
                ArrayList<String> lista = new ArrayList<>();
                try {
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items = fileUpload.parseRequest(request);
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if (!fileItem.isFormField()) {
                            File f = new File("C:\\xampp\\htdocs\\img\\" + fileItem.getName());
                            fileItem.write(f);
                            p.setImagen("http://localhost/img/"+fileItem.getName());
                        } else {
                            lista.add(fileItem.getString());
                        }
                    }
                            
                            p.setNombre(lista.get(0));
                            p.setDescripcion(lista.get(1));
                            p.setPrecio_compra(Float.parseFloat(lista.get(2)));
                            p.setPrecio_venta(Float.parseFloat(lista.get(3)));
                            p.setStock(Integer.parseInt(lista.get(4)));
                            p.setDisponibles(lista.get(5));
                            p.setId_proveedor(Integer.parseInt(lista.get(6)));
                            p.setId_categoria(Integer.parseInt(lista.get(7)));
                            pDAO.add(p);
                            System.out.println("PRODUCTO CARGADO");
                        
                    } catch (Exception e) 
                    {
                    
                    
                    }
                    RequestDispatcher vista = request.getRequestDispatcher("view/master/productos/add_products.jsp");
                    vista.forward(request, response);
                    //request.getRequestDispatcher("view/master/view_users.jsp").forward(request, response);
                    break;
                    case "Search":
                             String parametros =request.getParameter("TxtBuscar");
                             List<productos>list= pDAO.buscar(parametros);
                             request.setAttribute("datos", list);
                             //ACTUALIZACION 
                             request.setAttribute("TxtBuscar", request.getParameter("TxtBuscar"));
                             //request.getSession().setAttribute("busqueda", request.getParameter("TxtBuscar"));
                             request.getRequestDispatcher("view/master/productos/ress.jsp").forward(request, response);
                              
                             System.out.println("Busqueda realizada: "+parametros);
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
