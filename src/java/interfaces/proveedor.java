/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.proveedores;

/**
 *
 * @author JonaC
 */
public interface proveedor {
    public List listar();
    public proveedores list (int id);
    public boolean add (proveedores pro);
    public boolean edit (proveedores pro);
    public boolean delete (int id);
    
}
