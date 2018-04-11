/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
import Dao.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author Uriel Villegas
 */
public class ConsultaDoctor extends TagSupport{
    ArrayList<Doctor> doctores;
    @Override
    public int doStartTag() throws JspException {
        System.out.println("estas dentro dostartag de consultadoctor");
        
        DoctorDao dd = new DoctorDao();
        
        doctores = dd.consulta();
        
        JspWriter out=pageContext.getOut();
        
        if(doctores.isEmpty()){
            System.out.println("No hay doctores");
        }else{
            for (Doctor doctor : doctores) {
                System.out.println(doctor.getNombre());
                try {
                    out.println("<tr>");
                    out.println("<td>" + doctor.getIdDoctor() + "</td>");
                    out.println("<td>" + doctor.getNombre()+ "</td>");
                    out.println("<td>" + doctor.getPaterno()+ "</td>");
                    out.println("<td>" + doctor.getMaterno() + "</td>");
                    out.println("<td>" + doctor.getEdad()+ "</td>");
                    out.println("<td>" + doctor.getEmail() + "</td>");
                    out.println("<td>" + doctor.getTelefono() + "</td>");
                    out.println("<td>" + doctor.getCedula()+ "</td>");
                    
                    out.println("</tr>");
    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
                
        return SKIP_BODY;
    }
    
}
