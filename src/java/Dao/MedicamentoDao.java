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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Unitec
 */
public class MedicamentoDao implements Dao{

    @Override
    public boolean alta(Object o) {
         boolean b=false;
       try
       {
           Connection c=new DataSource().getConexion();
           String sql="insert into Medicamento(nombre,marca,substancia) values(?,?,?)";
           PreparedStatement ps=c.prepareStatement(sql);
           Medicamento med=(Medicamento)o;
           ps.setString(1, med.getNombre());
           ps.setString(2, med.getMarca());
           ps.setString(3, med.getSubstancia());
           
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
        ArrayList<Medicamento> lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select * from medicamento";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            lista=new ArrayList();
            while(r.next())
            {
                Medicamento med=new Medicamento();
                
                med.setIdMedicamento(r.getInt("idmedicamento"));
                med.setNombre(r.getString("nombre"));
                med.setMarca(r.getString("marca"));
                med.setSubstancia(r.getString("substancia"));
                lista.add(med);
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
