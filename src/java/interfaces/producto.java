/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.productos;

/**
 *
 * @author JonaC
 */
public interface producto {
    public List listar();
    public productos list (int id);
    public boolean add (productos pro);
    public boolean edit (productos pro);
    public boolean delete (int id);
    public List buscar(String busqueda);
}
