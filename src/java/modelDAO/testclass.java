package modelDAO;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author JonaC
 */
public class testclass extends conexion{   
    Connection conect;
    PreparedStatement pre =null; 
    //PARA ALMACENAR EL RESULTADO DE LA CONSULTA
    ResultSet rs =null;
    public boolean LogIn(String Email,String Pass) 
    {
        try 
        {
        String query="SELECT * FROM usuarios WHERE email=? AND password=?";
        conect=conexion.getConnection();
        pre= conect.prepareStatement(query);
        pre.setString(1, Email);
        pre.setString(2, Pass);
        rs = pre.executeQuery();
        if(rs.absolute(1))
        {
            return true;
        }
        }
        catch (SQLException e)
        {
            System.err.println("Error: "+e);
        }
        finally
        {
            try {
                if(conexion.getConnection()!=null)conexion.getConnection().close();
                if (pre !=null) pre.close();
                if(rs !=null) rs.close();
            } catch (SQLException ex) {
                System.err.println("Error: "+ex);
            }
        }
        return false;
    }

    public boolean registrar(String nom,String ape, String user, String email,String pass,int tipo,String foto)
      {
          //PreparedStatement pre=null;
          try 
          {
              String query="INSERT INTO usuarios (nombres, apellidos, user_name,email,password,tipo_usuario,foto_perfil) VALUES (?,?,?,?,?,?,?)";
              conect=conexion.getConnection();
              pre = conect.prepareStatement(query);
              pre.setString(1, nom);
              pre.setString(2, ape);
              pre.setString(3,user);
              pre.setString(4,email);
              pre.setString(5,pass);
              pre.setInt(6,tipo);
              pre.setString(7, foto);
              if (pre.executeUpdate()==1) 
              {
                return true;
              }
          } 
          catch (SQLException e) 
          {
            System.err.println("Error: "+e);
          }
                  finally
        {
            try {
                if(conexion.getConnection()!=null) conexion.getConnection().close();
                if (pre !=null) pre.close();
            } catch (SQLException ex) {
                System.err.println("Error: "+ex);
            }
        }
          return false;
      }
      public static void main(String[] args) {
        // TODO code application logic here
       testclass us = new testclass();
       //COMO EL METODO LogIn RETORNA UN BOOLEANO, LO PODEMOS IMPRIMIR
       System.out.println(us.LogIn("JonathanCastillo@hotmail.com", "12345"));
       if(us.LogIn("JonathanCastillo@hotmail.com", "12345")==true)
       {
           System.out.println("EL USUARIO SI EXISTE EN EL SISTEMA");
       }
       else
       {
           System.out.println("EL USUARIO NO EXISTE EN EL SISTEMA O LOS DATOS SON INCORRECTOS");
       }
    }
    
}
