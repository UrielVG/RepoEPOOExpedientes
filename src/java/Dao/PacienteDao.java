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
public class PacienteDao implements Dao{

    @Override
    public boolean alta(Object o) {
        boolean b=false;
       try
       {
           Connection c=new DataSource().getConexion();
           String sql="insert into paciente";
           PreparedStatement ps=c.prepareStatement(sql);
           Paciente pac=(Paciente)o;
           
           
           int r=ps.executeUpdate();
           if(r>0)
               b=true;
           String sql2="select top 1 idPersona from persona order by 1 desc";
           Statement s=c.createStatement();
           ResultSet rs=s.executeQuery(sql);
           int idpersona=rs.getInt("idpersona");
           rs.close();
           
           String sql3="select top 1 idpaciente from paciente order by 1 desc";
           Statement s1=c.createStatement();
           ResultSet rs2=s.executeQuery(sql);
           int idpaciente=rs.getInt("idpaciente");
           rs2.close();
           
           String sql1="insert into personapaciente(idpaciente,idpersona) values(?,?)";
           PreparedStatement ps1=c.prepareStatement(sql);
           ps1.setInt(1, idpaciente);
           ps1.setInt(2, idpersona);
           int r2=ps1.executeUpdate();
           b=false;
           if(r2>0)
               b=true;
           ps1.close();
           
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
        ArrayList<Persona> lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select * from paciente pa join personapaciente pp on pp.idpaciente=pa.idpaciente"
                    + "join persona p on p.id=idpersona=pp.idpersona";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            lista=new ArrayList();
            while(r.next())
            {
                Paciente pac=new Paciente();
                
                pac.setIdPaciente(r.getInt("idpaciente"));
                pac.setIdPersona(r.getInt("idpersona"));
                pac.setNombre(r.getString("nombre"));
                pac.setPaterno(r.getString("apaterno"));
                pac.setMaterno(r.getString("aMaterno"));
                pac.setEmail( r.getString("email"));
                pac.setTelefono(r.getString("telefono"));
                lista.add(pac);
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
