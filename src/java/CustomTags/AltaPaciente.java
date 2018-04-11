/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import Dao.*;
/**
 *
 * @author Uriel Villegas
 */
public class AltaPaciente extends TagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        Paciente pa=new Paciente();
        
        pa.setNombre((String)getValue("nombre"));
        pa.setPaterno((String)getValue("paterno"));
        pa.setMaterno((String)getValue("materno"));
        pa.setEdad((int)getValue("edad"));
        pa.setEmail((String)getValue("email"));
        pa.setTelefono((String)getValue("telefono"));
        try {
            
            PacienteDao pd = new PacienteDao();
            boolean esCorrecto=pd.alta(pa);
            out.print(esCorrecto);
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
        return SKIP_BODY;
    }
    
}
