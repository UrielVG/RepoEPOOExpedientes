/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Unitec
 */
public class PersonaDao implements Dao{

    @Override
    public boolean alta(Object o) {
        boolean b=false;
       try
       {
           Connection c=new DataSource().getConexion();
           String sqlper="insert into persona(nombre,aPaterno,aMaterno,email,telefono,edad) values(?,?,?,?,?,?)";
           PreparedStatement psper=c.prepareStatement(sqlper);
           Persona per=(Persona)o;
           psper.setString(1,per.getNombre());
           psper.setString(2, per.getPaterno());
           psper.setString(3, per.getMaterno());
           psper.setString(4, per.getEmail());
           psper.setString(5, per.getTelefono());
           psper.setInt(6, per.getEdad());
           int r=psper.executeUpdate();
           if(r>0)
               b=true;
           psper.close();
           c.close();
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       return b;
    }

    @Override
    public ArrayList consulta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualiza(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
