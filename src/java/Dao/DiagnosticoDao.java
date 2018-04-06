/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Unitec
 */
public class DiagnosticoDao implements Dao{

    @Override
    public boolean alta(Object o) {
        boolean b=false;
       try
       {
           Connection c=new DataSource().getConexion();
           String sql="insert into Diagnostico(nombre) values(?)";
           PreparedStatement ps=c.prepareStatement(sql);
           Diagnostico dia=(Diagnostico)o;
           ps.setString(1, dia.getNombre());
          
           
           int r=ps.executeUpdate();
           if(r>0)
               b=true;
           
           
           ps.close();
           c.close();
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       return b;
    }

    @Override
    public ArrayList consulta(int id) {
        ArrayList<Diagnostico> lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select * from diagnostico";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            lista=new ArrayList();
            while(r.next())
            {
                Diagnostico diagnostico=new Diagnostico();
                
                diagnostico.setIdDiagnostico(r.getInt("idDiagnostico"));
                diagnostico.setNombre(r.getString("nombre"));
                
                lista.add(diagnostico);
            }
            r.close();
            ps.close();
            c.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualiza(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
