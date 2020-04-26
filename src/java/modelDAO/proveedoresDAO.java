/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import config.conexion;
import interfaces.proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.proveedores;

/**
 *
 * @author JonaC
 */
public class proveedoresDAO implements proveedor{
    Connection conect;
    conexion con = new conexion();
    PreparedStatement ps=null;
    ResultSet rs;
    proveedores pro = new proveedores();
    @Override
    public List listar() {
      ArrayList <proveedores> list = new ArrayList<>();
        //Creamos la consulta a la base de datos
        String query="SELECT * FROM proveedores";
        try 
        {
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) 
            {
                System.out.println("LLEGANDO A MOSTRAR TIPO DE USUARIO");
                proveedores pro = new proveedores();
                pro.setId_proveedor(rs.getInt("Id_Proveedor"));
                pro.setNombres(rs.getString("Nombres"));
                pro.setApellidos(rs.getString("Apellidos"));
                pro.setEmpresa(rs.getString("Empresa"));
                pro.setFoto(rs.getString("Foto"));
                pro.setDireccion(rs.getString("Direccion"));
                pro.setTelefono(rs.getString("Telefono"));
                pro.setEmail(rs.getString("Email"));
                pro.setEstado(rs.getInt("Estado"));
                list.add(pro);
            }
                        
        } 
        catch (SQLException e) 
        {
            System.out.println("ERROR:" +e);
        }
        finally
        {
            try {
                if(conexion.getConnection()!=null) conexion.getConnection().close();
                if (ps !=null) ps.close();
                if(rs !=null) rs.close();
            } catch (SQLException ex) {
                System.err.println("Error: "+ex);
            }
        }
        return list;
    }

    @Override
    public proveedores list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(proveedores pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(proveedores pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
