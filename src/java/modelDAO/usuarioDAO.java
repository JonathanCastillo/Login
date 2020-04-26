/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import config.conexion;
import config.conexion;
import model.usuario;
import interfaces.usuarios;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author JonaC
 */
public class usuarioDAO implements usuarios{
    Connection conect;
    conexion con=new conexion();
    PreparedStatement ps=null;
    ResultSet rs;
    usuario user = new usuario();
    //ps=null;
    //ResultSet rs;

    @Override
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
             
            
        } catch (Exception e) {
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
        ArrayList <usuario> list = new ArrayList<>();
        //Creamos la consulta a la base de datos
        String query="SELECT * FROM usuarios WHERE Estado=1";
        try 
        {
            
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) 
            {
                System.out.println("LLEGANDO A LISTAR");
                usuario user = new usuario();
                user.setId_usuario(rs.getInt("Id_Usuario"));
                user.setNombres(rs.getString("Nombres"));
                user.setApellidos(rs.getString("Apellidos"));
                user.setUser_name(rs.getString("User_Name"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setTipo(rs.getInt("Tipo_Usuario"));
                user.setFoto(rs.getString("Foto_Perfil"));
                user.setEstado(rs.getInt("Estado"));
                //System.out.println(rs.getString("Nombres"));
                list.add(user);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR:" +e);
        }
        return list;
    }
    

    @Override
    public usuario list(int id) {
        String query="SELECT * FROM usuarios WHERE id_usuario="+id;
        try 
        {
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) 
            {
                System.out.println("LLEGANDO A LISTAR");
                
                user.setId_usuario(rs.getInt("Id_Usuario"));
                user.setNombres(rs.getString("Nombres"));
                user.setApellidos(rs.getString("Apellidos"));
                user.setUser_name(rs.getString("User_Name"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setTipo(rs.getInt("Tipo_Usuario"));
                user.setFoto(rs.getString("Foto_Perfil"));
                user.setEstado(rs.getInt("Estado"));
                //System.out.println(rs.getString("Nombres"));
            }
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR:" +e);
        }
        return user;
    }

    @Override
    public boolean add(usuario user) {
            int contador=0;
        conect=conexion.getConnection();

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query="INSERT INTO usuarios (nombres,apellidos,user_name,email,password,tipo_usuario,foto_perfil) VALUES (?,?,?,?,?,?,?)";
        try {
            
            //conect=con.getConnection();
            ps=conect.prepareStatement(query);
            ps.setString(1, user.getNombres());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getUser_name());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getTipo());
            ps.setString(7, user.getFoto());
            ps.executeUpdate();
            //System.out.println("LLEGANDO A METODO EN USUARIODAO");
            //rs.last();  
        } 
        catch (Exception e) 
        {
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
        return false;

    }

    @Override
    public boolean edit(usuario user) 
    {
        String query="UPDATE usuarios SET nombres=?,apellidos=?,user_name=?,email=?,password=?,tipo_usuario=?,foto_perfil=? WHERE id_usuario=?";
            try {
            
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            ps.setString(1, user.getNombres());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getUser_name());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getTipo());
            ps.setString(7, user.getFoto());
            ps.setInt(8, user.getId_usuario());
            ps.executeUpdate();
            //System.out.println("LLEGANDO A METODO EN USUARIODAO");
            //rs.last();  
        } 
        catch (Exception e) 
        {
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
        
        return false;
    }

    @Override
    public boolean delete(int id) {
        String query="UPDATE usuarios SET estado='0' WHERE id_usuario="+id;
        try 
        {
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            ps.executeUpdate();
        } 
        catch (Exception e) 
        {
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
        
        return false;
    }
    }