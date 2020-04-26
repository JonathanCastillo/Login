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
import interfaces.tipouser;
import model.tipousuario;

/**
 *
 * @author JonaC
 */
public class tipousuarioDAO implements tipouser{
    Connection conect;
    conexion con=new conexion();
    PreparedStatement ps=null;
    ResultSet rs;
    
    @Override
    public List listar() {
        //Creamos un arreglo de la clase usuario. Dentro de las <> debe escribirse  de forma correcta el nombre de la clase en el model.
        ArrayList <tipousuario> list = new ArrayList<>();
        //Creamos la consulta a la base de datos
        String query="SELECT * FROM tipo_usuario";
        try 
        {
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) 
            {
                System.out.println("LLEGANDO A MOSTRAR TIPO DE USUARIO");
                tipousuario tipo = new tipousuario();
                tipo.setId_tipo(rs.getInt("Id_Tipo"));
                tipo.setNombre(rs.getString("Nombre"));
                tipo.setEstado(rs.getInt("Estado"));
                list.add(tipo);
            }
                        
        } 
        catch (SQLException e) 
        {
            System.out.println("ERROR:" +e);
        }
        return list;
    }

    @Override
    public tipousuario list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
