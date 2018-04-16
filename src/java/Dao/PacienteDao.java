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
           String sql="insert into paciente values()";
           PreparedStatement ps=c.prepareStatement(sql);
           
           
           
           int r=ps.executeUpdate();
           if(r>0)
               b=true;
           b=false;
           String sqlper="insert into persona(nombre,aPaterno,aMaterno,email,telefono,edad) values(?,?,?,?,?,?)";
           PreparedStatement psper=c.prepareStatement(sqlper);
           Persona per=(Persona)o;
           psper.setString(1,per.getNombre());
           psper.setString(2, per.getPaterno());
           psper.setString(3, per.getMaterno());
           psper.setString(4, per.getEmail());
           psper.setString(5, per.getTelefono());
           psper.setInt(6, per.getEdad());
           int r1=psper.executeUpdate();
           if(r1>0)
               b=true;
           String sql2="select idPersona from persona  order by 1 desc limit 1";
           Statement s=c.createStatement();
           ResultSet rs=s.executeQuery(sql2);
           rs.next();
           int idpersona=rs.getInt("idpersona");
           rs.close();
           
           String sql3="select idpaciente from paciente order by 1 desc limit 1";
           Statement s1=c.createStatement();
           ResultSet rs2=s.executeQuery(sql3);
           rs2.next();
           int idpaciente=rs2.getInt("idpaciente");
           rs2.close();
           
           String sql1="insert into personapaciente(idpaciente,idpersona) values(?,?)";
           PreparedStatement ps1=c.prepareStatement(sql1);
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
        ArrayList<Paciente> lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select * from paciente pa join personapaciente pp on pp.idpaciente=pa.idpaciente"
                    + " join persona p on p.idpersona=pp.idpersona";
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
                pac.setEdad(r.getInt("edad"));
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
