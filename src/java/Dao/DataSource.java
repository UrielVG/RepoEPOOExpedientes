/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Unitec
 */
public class DataSource {
    public Connection getConexion()
    {
        Connection c=null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("conectando...");
                c=DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicaDB","root","root");
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("Error en conexion");
            }
            return c;
    }
}
