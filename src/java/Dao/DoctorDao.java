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
import java.sql.*;

/**
 *
 * @author Unitec
 */
public class DoctorDao implements Dao{

    @Override
    public boolean alta(Object o) {
        boolean b=false;
       try
       {
           Connection c=new DataSource().getConexion();
           String sql="insert into doctor(cedula,clave) values(?,?)";
           PreparedStatement ps=c.prepareStatement(sql);
           Doctor doc=(Doctor)o;
           ps.setString(1,doc.getCedula());
           ps.setString(2, doc.getClave());
           
           int r=ps.executeUpdate();
           if(r>0)
               b=true;
           String sql2="select top 1 idPersona from persona order by 1 desc";
           Statement s=c.createStatement();
           ResultSet rs=s.executeQuery(sql);
           int idpersona=rs.getInt("idpersona");
           rs.close();
           
           String sql3="select top 1 iddoctor from doctor order by 1 desc";
           Statement s1=c.createStatement();
           ResultSet rs2=s.executeQuery(sql);
           int iddoctor=rs.getInt("iddoctor");
           rs2.close();
           
           String sql1="insert into personadoctor(iddoctor,idpersona) values(?,?)";
           PreparedStatement ps1=c.prepareStatement(sql);
           ps1.setInt(1, iddoctor);
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
    public ArrayList consulta(int id) {
        ArrayList<Persona> lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select * from Doctor join personadoctor pd on pd.iddoctor=d.iddoctor"
                    + "join persona p on p.id=idpersona=pd.idpersona";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            lista=new ArrayList();
            while(r.next())
            {
                Doctor doc=new Doctor();
                doc.setCedula(r.getString("cedula"));
                doc.setIdDoctor(r.getInt("iddoctor"));
                doc.setIdPersona(r.getInt("idpersona"));
                doc.setNombre(r.getString("nombre"));
                doc.setPaterno(r.getString("apaterno"));
                doc.setMaterno(r.getString("aMaterno"));
                doc.setEmail( r.getString("email"));
                doc.setTelefono(r.getString("telefono"));
                lista.add(doc);
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
