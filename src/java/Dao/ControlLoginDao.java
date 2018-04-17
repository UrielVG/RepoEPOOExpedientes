/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Unitec
 */
public class ControlLoginDao implements Dao{

    @Override
    public boolean alta(Object o) {
        boolean correcto=false;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="insert into controllogin(iddoctor,fecha) values(?,now())";
            PreparedStatement ps=c.prepareStatement(sql);
            Doctor d=(Doctor)o;
            ps.setInt(1, d.getIdDoctor());
            int r=ps.executeUpdate();
            if(r>0)
                correcto=true;
            ps.close();
            c.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return correcto;
    }

    @Override
    public ArrayList consulta() {
        ArrayList<ControlLogin> lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select d.iddoctor,p.nombre,p.apaterno,cl.fecha from controllogin cl join Doctor d on d.idDoctor=cl.idDoctor "
                    + "join personadoctor pd on pd.iddoctor=d.iddoctor "
                    + "join persona p on p.idpersona=pd.idpersona";
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sql);
            lista=new ArrayList();
            while(rs.next())
            {
                ControlLogin cl=new ControlLogin();
                cl.setIddoctor(rs.getInt("d.iddoctor"));
                cl.setNombre(rs.getString("p.nombre"));
                cl.setPaterno(rs.getString("p.apaterno"));
                cl.setFecha(rs.getString("cl.fecha"));
                lista.add(cl);
            }
            s.close();
            rs.close();
            c.close();
        }
        catch(SQLException e)
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
