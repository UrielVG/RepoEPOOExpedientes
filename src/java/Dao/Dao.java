/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Unitec
 */
import java.util.*;
public interface Dao {
    public boolean alta(Object o);
    public ArrayList consulta();
    public void actualiza(Object o);
    
}
