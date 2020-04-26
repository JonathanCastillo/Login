/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import config.conexion;
import interfaces.usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.person;
import model.usuario;

/**
 *
 * @author JonaC
 */
public class personDAO implements usuarios{
     Connection conect;
    conexion con=new conexion();
    PreparedStatement ps=null;
    ResultSet rs;
    //ps=null;
    //ResultSet rs;

    public int validar(usuario user) 
    {    
        int contador=0;
        conect=conexion.getConnection();

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     String query="SELECT * FROM usuarios WHERE Email=? AND Password=?";
        try {
            contador= contador+1;
            //conect=con.getConnection();
            ps=conect.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            rs=ps.executeQuery();
            System.out.println("LLEGANDO A METODO EN USUARIODAO");
            rs.last();
            if (rs.getRow() > 0) {
                System.out.println("LLEGANDO A WHILE EN USUARIODAO");
                user.setEmail(rs.getString("Email"));
                user.setNombres(rs.getString("Nombres"));
                user.setApellidos(rs.getString("Apellidos"));
                user.setPassword(rs.getString("Password"));
                user.setTipo(rs.getInt("Tipo_Usuario"));
               
                if (contador==1) {
                    System.out.println("LLEGANDO A IF EN USUARIODAO");
                    return 1;
                    
                }
                else
                {
                    return 0;
                }
                
 
            }
             
            
        } catch (SQLException e) {
        System.err.println(e);
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
        return 0;
    }

     @Override
    public List listar() 
    {
        //Creamos un arreglo de la clase usuario
        ArrayList <person> list = new ArrayList<>();
        //Creamos la consulta a la base de datos
        String query="SELECT * FROM usuarios";
        try 
        {
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            rs=ps.executeQuery();
            if (rs.next()) 
            {
                System.out.println("LLEGANDO A LISTAR");
                person user = new person();
                user.setId_usuario(rs.getInt("Id_Usuario"));
                user.setNombres(rs.getString("Nombres"));
                user.setApellidos(rs.getString("Apellidos"));
                user.setUser_name(rs.getString("User_Name"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setTipo(rs.getInt("Tipo_Usuario"));
                user.setFoto(rs.getString("Foto_Perfil"));
                user.setEstado(rs.getInt("Estado"));
                System.out.println(rs.getString("Nombres"));
                list.add(user);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("ERROR:" +e);
        }
        return list;
    }

    public usuario list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean add(usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean edit(usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
