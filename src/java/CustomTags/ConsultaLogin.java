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
 * @author Unitec
 */
public class ConsultaLogin extends TagSupport {

    

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        ArrayList<ControlLogin> lista=new ArrayList();
        ControlLoginDao cl=new ControlLoginDao();
        lista=cl.consulta();
        try {
            for(ControlLogin l:lista)
            {
                out.println("<tr>");
                out.println("<td>"+l.getIddoctor());
                out.println("<td>"+l.getNombre());
                out.println("<td>"+l.getPaterno());
                out.println("<td>"+l.getFecha());
                out.println("</tr>");
            }
            
            
        } catch (Exception ex) {
            throw new JspException("Error in ConsultaLogin tag", ex);
        }
        return SKIP_BODY;
    }

    
    
}
