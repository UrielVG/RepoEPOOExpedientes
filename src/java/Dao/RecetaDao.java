/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Unitec
 */
public class RecetaDao implements Dao{

    @Override
    public boolean alta(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList consulta() {
        
        ArrayList<Receta> recetas=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select idreceta,p1.nombre,p.nombre,fecha,t.idtratamiento,observaciones,p.idpaciente,p1.iddoctor from receta r"
                    + "join personapaciente pp on pp.idpaciente=r.idpaciente"
                    + "join persona p on p.idpersona=pp.idpersona"
                    + "join personadoctor pd on pd.iddoctor=r.iddoctor"
                    + "join persona p1 on p1.idpersona=pd.idpersona"
                    + "join tratamiento t on t.idtratamiento=r.idtratamiento"
                    + "join diagnostico d on d.iddiagnostico=t.iddiagnostico"
                    + "join medicamento m on m.idmedicamento=t.idmedicamento";
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sql);
            recetas=new ArrayList();
            while(rs.next())
            {
                Receta receta=new Receta();
                receta.setIdReceta(rs.getInt("idreceta"));
                receta.setnPaciente(rs.getString("p.nombre"));
                receta.setnDoctor(rs.getString("p1.nombre"));
                receta.setFecha(rs.getString("fecha"));
                receta.setIdTratamiento(rs.getInt("t.idtratamiento"));
                receta.setObservacones(rs.getString("observaciones"));
                receta.setIdPaciente(rs.getInt("p.idpaciente"));
                receta.setIdDoctor(rs.getInt("p1.iddoctor"));
                recetas.add(receta);           
            }
            rs.close();
            s.close();
            c.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return recetas;
    }

    @Override
    public void actualiza(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
