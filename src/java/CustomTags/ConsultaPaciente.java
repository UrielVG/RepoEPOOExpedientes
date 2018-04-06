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
 * @author TechM User
 */
public class ConsultaPaciente extends TagSupport{
    ArrayList<Paciente> listapaciente;
    @Override
    public int doStartTag() throws JspException {
        System.out.println("estas dentro dostartag de consultapaciente");
        
        PacienteDao pd = new PacienteDao();
        
        listapaciente = pd.consulta();//aqui te quedaste
        
        JspWriter out=pageContext.getOut();
        
        if(listapaciente.isEmpty()){
            System.out.println("No hay Pacientes");
        }else{
            for (Paciente paciente : listapaciente) {
                System.out.println(paciente.getNombre());
                try {
                    out.println("<tr>");
                    out.println("<td>" + paciente.getIdpaciente()+ "</td>");
                    out.println("<td>" + paciente.getNombre()+ "</td>");
                    out.println("<td>" + paciente.getApellidopaterno()+ "</td>");
                    out.println("<td>" + paciente.getApellidomaterno()+ "</td>");
                    out.println("<td>" + paciente.getDireccion()+ "</td>");
                    out.println("<td>" + paciente.getEdad()+ "</td>");
                    out.println("<td>" + paciente.getPeso()+ "</td>");
                    out.println("</tr>");
    //            <tr>
    //                <td>1</td>
    //                <td>Mark</td>
    //                <td>Otto</td>
    //                <td>@mdo</td>
    //            </tr>
                } catch (IOException ex) {
                    Logger.getLogger(ConsultaDoctor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
                
        return SKIP_BODY;
    }
}
