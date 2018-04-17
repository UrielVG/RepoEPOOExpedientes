/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.*;
import Dao.*;
import java.util.*;
/**
 *
 * @author Uriel Villegas
 */
public class ConsultaDiagnostico extends TagSupport {

    
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        Diagnostico dia=new Diagnostico();
        DiagnosticoDao dd=new DiagnosticoDao();
        ArrayList<Diagnostico> diagnosticos=new ArrayList();
        
        try {
            
            diagnosticos=dd.consulta();
            if(diagnosticos.isEmpty())
                out.println("<tr><td>No hay registrados</tr>");
            else
            {
                for(Diagnostico d:diagnosticos)
                {
                    out.println("<tr>");
                    out.println("<td>"+d.getIdDiagnostico());
                    out.println("<td>"+d.getNombre());
                    out.println("<td>"+d.getFecha());
                    out.println("</tr>");
                }
            }
            
        } catch (Exception ex) {
            throw new JspException("Error in ConsultaDiagnostico tag", ex);
        }
        return SKIP_BODY;
    }

    
    
}
