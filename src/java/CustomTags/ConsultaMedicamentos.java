/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import javax.servlet.*;
import Dao.*;
import java.util.*;
/**
 *
 * @author Uriel Villegas
 */
public class ConsultaMedicamentos extends TagSupport{
    ArrayList<Medicamento> medi;

    /**
     *
     * @return
     */
    @Override
    public int doStartTag()
    {
        JspWriter out=pageContext.getOut();
        
        MedicamentoDao md=new MedicamentoDao();
        medi=md.consulta();
        try
        {
            
            
            {
                for(Medicamento m:medi)
                {
                    out.println("<tr>");
                    out.println("<td>"+m.getIdMedicamento());
                    out.println("<td>"+m.getNombre());
                    out.println("<td>"+m.getMarca());
                    out.println("<td>"+m.getSubstancia());
                    out.println("<td>"+m.getFecha());
                    out.println("</tr>");
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return SKIP_BODY;  
    }
}
