/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.categorias;
import interfaces.categoria;

/**
 *
 * @author JonaC
 */
public class categoriasDAO implements categoria{
    Connection conect;
    conexion con = new conexion();
    PreparedStatement ps = null;
    ResultSet rs;

    @Override
    public List listar() {
        ArrayList <categorias> list = new ArrayList<>();
        //Creamos la consulta a la base de datos
        String query="SELECT * FROM categorias";
        try 
        {
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) 
            {
                System.out.println("LLEGANDO A MOSTRAR TIPO DE USUARIO");
                categorias cat = new categorias();
                cat.setId_categoria(rs.getInt("Id_Categoria"));
                cat.setNombre_categoria(rs.getString("Nombre_Categoria"));
                cat.setDescripcion(rs.getString("Descripcion"));
                cat.setEstado(rs.getInt("Estado"));
                list.add(cat);
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
    public boolean disable(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(categoria cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(categoria cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
