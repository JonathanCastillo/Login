/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author JonaC
 */
public interface categoria {
    public List listar();
    public boolean add (categoria cat);
    public boolean edit (categoria cat);
    public boolean disable (int id);
}
