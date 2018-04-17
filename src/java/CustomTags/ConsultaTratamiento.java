/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.TagSupport;
import Dao.*;
import java.util.ArrayList;
/**
 *
 * @author Uriel Villegas
 */
public class ConsultaTratamiento extends TagSupport {

    
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        ArrayList<Tratamiento> tratamientos=new ArrayList();
        TratamientoDao td=new TratamientoDao();
        tratamientos=td.consulta();
        try {
            if(tratamientos.isEmpty())
                System.out.println("No hay tratamientos registrados");
            else
            {
                for(Tratamiento t:tratamientos)
                {
                    out.println("<tr>");
                    out.println("<td>"+t.getIdTratamiento());
                    out.println("<td>"+t.getDiagnostico());
                    out.println("<td>"+t.getMedicamento());
                    out.println("<td>"+t.getFecha());
                    out.println("</tr>");
                }
                
            }
            
        } catch (Exception ex) {
            throw new JspException("Error in ConsultaTratamiento tag", ex);
        }
        return SKIP_BODY;
    }

    
    
}
