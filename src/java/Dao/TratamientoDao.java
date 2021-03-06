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
public class TratamientoDao implements Dao{

    @Override
    public boolean alta(Object o) {
         boolean b=false;
       try
       {
           Connection c=new DataSource().getConexion();
           String sql="insert into tratamiento(idMedicamento,idDiagnostico,fecha) values(?,?,now())";
           PreparedStatement ps=c.prepareStatement(sql);
           Tratamiento tratamiento=(Tratamiento)o;
           ps.setInt(1, tratamiento.getIdMedicamento());
           ps.setInt(2, tratamiento.getIdDiagnostico());
           
           
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
    public ArrayList consulta() {
        ArrayList<Tratamiento> tratamientos=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select * from Tratamiento t join diagnostico d on d.iddiagnostico=t.iddiagnostico"
                    + " join medicamento m on m.idmedicamento=t.idmedicamento";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            tratamientos=new ArrayList();
            while(r.next())
            {
                Tratamiento tratamiento=new Tratamiento();
                tratamiento.setIdTratamiento(r.getInt("idTratamiento"));
                tratamiento.setIdDiagnostico(r.getInt("idDiagnostico"));
                tratamiento.setIdMedicamento(r.getInt("idMedicamento"));
                tratamiento.setDiagnostico(r.getString("d.nombre"));
                tratamiento.setMedicamento(r.getString("m.nombre"));
                tratamiento.setFecha(r.getString("fecha"));
                tratamientos.add(tratamiento);
            }
            r.close();
            ps.close();
            c.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return tratamientos;
    }

    @Override
    public void actualiza(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
