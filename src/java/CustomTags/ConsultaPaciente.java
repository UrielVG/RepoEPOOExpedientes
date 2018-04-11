/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTags;

import Dao.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * 
 * @author Uriel Villegas
 */
public class ConsultaPaciente extends TagSupport{
    ArrayList<Paciente> pacientes;
    @Override
    public int doStartTag() throws JspException {
        System.out.println("estas dentro dostartag de consultapaciente");
        
        PacienteDao pd = new PacienteDao();
        
        pacientes = pd.consulta();
        
        JspWriter out=pageContext.getOut();
        
        if(pacientes.isEmpty()){
            System.out.println("No hay Pacientes");
        }else{
            for (Paciente paciente : pacientes) {
                System.out.println(paciente.getNombre());
                try {
                    out.println("<tr>");
                    out.println("<td>" + paciente.getIdPaciente()+ "</td>");
                    out.println("<td>" + paciente.getNombre()+ "</td>");
                    out.println("<td>" + paciente.getPaterno()+ "</td>");
                    out.println("<td>" + paciente.getMaterno()+ "</td>");
                    out.println("<td>" + paciente.getEmail()+ "</td>");
                    out.println("<td>" + paciente.getEdad()+ "</td>");
                    out.println("<td>" + paciente.getTelefono()+ "</td>");
                    out.println("</tr>");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
                
        return SKIP_BODY;
    }
}
