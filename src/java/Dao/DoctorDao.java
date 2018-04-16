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
           String sql="insert into doctor(cedula,usuario,contraseña) values(?,?,?)";
           PreparedStatement ps=c.prepareStatement(sql);
           Doctor doc=(Doctor)o;
           ps.setString(1,doc.getCedula());
           ps.setString(2, doc.getUsuario());
           ps.setString(3, doc.getClave());
           
           int r=ps.executeUpdate();
           if(r>0)
               b=true;
           b=false;
           
           String sqlper="insert into persona(nombre,aPaterno,aMaterno,email,telefono,edad) values(?,?,?,?,?,?)";
           PreparedStatement psper=c.prepareStatement(sqlper);
           
           psper.setString(1,doc.getNombre());
           psper.setString(2, doc.getPaterno());
           psper.setString(3, doc.getMaterno());
           psper.setString(4, doc.getEmail());
           psper.setString(5, doc.getTelefono());
           psper.setInt(6, doc.getEdad());
           int r3=psper.executeUpdate();
           if(r3>0)
               b=true;
           String sql2="select idPersona from persona order by 1 desc limit 1";
           Statement s=c.createStatement();
           ResultSet rs=s.executeQuery(sql2);
           rs.next();
           int idpersona=rs.getInt("idpersona");
           
           
           String sql3="select iddoctor from doctor order by 1 desc limit 1";
           Statement s1=c.createStatement();
           ResultSet rs2=s.executeQuery(sql3);
           rs2.next();
           int iddoctor=rs2.getInt("iddoctor");
           
           
           String sql1="insert into personadoctor(iddoctor,idpersona) values(?,?)";
           PreparedStatement ps1=c.prepareStatement(sql1);
           ps1.setInt(1, iddoctor);
           ps1.setInt(2, idpersona);
           int r2=ps1.executeUpdate();
           b=false;
           if(r2>0)
               b=true;
           ps1.close();
           rs.close();
           rs2.close();
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
            String sql="select p.idpersona,d.iddoctor,p.nombre,p.apaterno,p.amaterno,cedula,telefono,usuario,contraseña,email,edad from Doctor d join personadoctor pd on pd.iddoctor=d.iddoctor join persona p on p.idpersona=pd.idpersona";
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
                doc.setUsuario(r.getString("usuario"));
                doc.setClave(r.getString("contraseña"));
                doc.setEdad(r.getInt("edad"));
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
