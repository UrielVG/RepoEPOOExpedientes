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
public class ConsultaReceta extends TagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        ArrayList<Receta> recetas=new ArrayList();
        RecetaDao rd=new RecetaDao();
        recetas=rd.consulta();
        try {
            if(recetas.isEmpty())
                System.out.println("No hay recetas rgistradas");
            else
            {
                for(Receta r:recetas)
                {
                    out.println("<tr>");
                    out.println("<td>"+r.getIdReceta());
                    out.println("<td>"+r.getnPaciente());
                    out.println("<td>"+r.getnDoctor());
                    out.println("<td>"+r.getMedicamento());
                    out.println("<td>"+r.getDiagnostico());
                    out.println("<td>"+r.getObservacones());
                    out.println("<td>"+r.getFecha());
                    out.println("</tr>");
                    
                    
                }
                
            }
            
        } catch (Exception ex) {
            throw new JspException("Error in ConsultaReceta tag", ex);
        }
        return SKIP_BODY;
    }
    
}
