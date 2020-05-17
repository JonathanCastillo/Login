/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import config.conexion;
import interfaces.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.productos;
import model.usuario;

/**
 *
 * @author JonaC
 */
public class productosDAO implements producto{
    Connection conect;
    conexion con=new conexion();
    PreparedStatement ps=null;
    ResultSet rs;
    productos pro = new productos();

    @Override
    public List listar() {
        String query="SELECT cat.Nombre_Categoria,\n" +
        "prov.Empresa,pro.Id_Producto, pro.Nombre,pro.Precio_Venta, pro.Descripcion, pro.Imagen, pro.Disponibles, pro.Stock  FROM productos pro INNER JOIN proveedores prov ON pro.Id_Proveedor=prov.Id_Proveedor INNER JOIN categorias cat ON pro.Id_Categoria=cat.Id_Categoria";
        ArrayList <productos> list = new ArrayList<>();
        //Creamos la consulta a la base de datos
       
        try 
        {
            
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) 
            {
                System.out.println("LLEGANDO A LISTAR PRODUCTOS");
                productos pro = new productos();
                pro.setId_producto(rs.getInt("pro.Id_Producto"));
                pro.setCategoria(rs.getString("cat.Nombre_Categoria"));
                pro.setNombre(rs.getString("pro.Nombre"));
                pro.setImagen(rs.getString("pro.Imagen"));
                pro.setDescripcion(rs.getString("pro.Descripcion"));
                pro.setPrecio_venta(rs.getFloat("pro.Precio_Venta"));
                pro.setDisponibles(rs.getString("pro.Disponibles"));
                pro.setStock(rs.getInt("pro.Stock"));
                pro.setEmpresa(rs.getString("prov.Empresa"));
                //System.out.println(rs.getString("Nombres"));
                list.add(pro);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR:" +e);
        }
        return list;
    
    
    }

    @Override
    public productos list(int id) {
        String query="SELECT cat.Nombre_Categoria,\n" +
        "prov.Empresa,pro.Id_Producto, pro.Nombre,pro.Precio_Venta, pro.Descripcion, pro.Imagen, pro.Disponibles, pro.Stock  FROM productos pro  INNER JOIN proveedores prov ON pro.Id_Proveedor=prov.Id_Proveedor INNER JOIN categorias cat ON pro.Id_Categoria=cat.Id_Categoria WHERE pro.Id_Producto="+id;
        try 
        {
            
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) 
            {
                System.out.println("LLEGANDO A LISTAR PRODUCTOS");
                pro.setId_producto(rs.getInt("pro.Id_Producto"));
                pro.setCategoria(rs.getString("cat.Nombre_Categoria"));
                pro.setNombre(rs.getString("pro.Nombre"));
                pro.setImagen(rs.getString("pro.Imagen"));
                pro.setDescripcion(rs.getString("pro.Descripcion"));
                pro.setPrecio_compra(rs.getFloat("pro.Precio_Compra"));
                pro.setPrecio_venta(rs.getFloat("pro.Precio_Venta"));
                pro.setDisponibles(rs.getString("pro.Disponibles"));
                pro.setStock(rs.getInt("pro.Stock"));
                pro.setEmpresa(rs.getString("prov.Empresa"));
                //System.out.println(rs.getString("Nombres"));
                //list.add(pro);
                System.out.println("DATOS OBTENIDOS DE METODO EDITAR PRODUCTOS" +rs.getString("pro.Nombre"));
                System.out.println("DATOS OBTENIDOS DE METODO EDITAR PRODUCTOSDAO" +pro.getNombre());
            }
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR:" +e);
        }
        return pro;
    }

    @Override
    public boolean add(productos pro) 
    {
        conect=conexion.getConnection();
        int r=0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query="INSERT INTO productos (id_categoria,nombre,imagen,descripcion,precio_compra,precio_venta,disponibles,stock,id_proveedor) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            
            //conect=con.getConnection();
            ps=conect.prepareStatement(query);
            ps.setInt(1, pro.getId_categoria());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getImagen());
            ps.setString(4, pro.getDescripcion());
            ps.setFloat(5, pro.getPrecio_compra());
            ps.setFloat(6, pro.getPrecio_venta());
            ps.setString(7, pro.getDisponibles());
            ps.setInt(8, pro.getStock());
            ps.setInt(9, pro.getId_proveedor());
            ps.executeUpdate();
            System.out.println("LLEGANDO A METODO EN PRODUCTO DAO");
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
    public boolean edit(productos pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List buscar(String busqueda) {
            List <productos> list = new ArrayList<>();
            String query = "SELECT * FROM productos pro INNER JOIN categorias cat ON pro.Id_Categoria=cat.Id_Categoria INNER JOIN proveedores prov ON pro.Id_Proveedor=prov.Id_Proveedor WHERE pro.nombre LIKE '%"+busqueda+"%' OR  cat.Nombre_Categoria LIKE '%"+busqueda+"%'";
       
            try 
        {
            
            conect=conexion.getConnection();
            ps=conect.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) 
            {
                System.out.println("LLEGANDO A BUSCAR PRODUCTOS");
                productos pro = new productos();
                pro.setId_producto(rs.getInt("pro.Id_Producto"));
                pro.setCategoria(rs.getString("cat.Nombre_Categoria"));
                pro.setNombre(rs.getString("pro.Nombre"));
                pro.setImagen(rs.getString("pro.Imagen"));
                pro.setDescripcion(rs.getString("pro.Descripcion"));
                pro.setPrecio_venta(rs.getFloat("pro.Precio_Venta"));
                pro.setDisponibles(rs.getString("pro.Disponibles"));
                pro.setStock(rs.getInt("pro.Stock"));
                pro.setEmpresa(rs.getString("prov.Empresa"));
                //System.out.println(rs.getString("Nombres"));
                list.add(pro);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR:" +e);
        }
        return list;
        
        
    }
}
