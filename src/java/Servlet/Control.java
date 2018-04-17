/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.*;
/**
 *
 * @author Unitec
 */
@WebServlet(name = "Control", urlPatterns = {"/control"})
public class Control extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina=request.getParameter("pagina");
        if(pagina.equals("login")||pagina.equals("loginError"))
        {
            
            Doctor existe=login(request.getParameter("usuario"),request.getParameter("contrasena"));
            if(existe!=null){
                request.setAttribute("usuario", existe);
                ControlLoginDao cl=new  ControlLoginDao();
                cl.alta(existe);
                response.sendRedirect("pages/Principal.jsp");
            }
            else
                response.sendRedirect("pages/loginError.jsp");
            
        }
        if(pagina.equals("altaReceta"))
        {
            Receta r=new Receta();
            r.setnDoctor(request.getParameter("doctor"));
            r.setnPaciente(request.getParameter("paciente"));
            r.setDiagnostico(request.getParameter("tratamiento"));
            
            r.setObservacones(request.getParameter("observaciones"));
            ArrayList<Doctor> doc=new ArrayList<Doctor>();
            ArrayList<Paciente> pac=new ArrayList<Paciente>();
            ArrayList<Tratamiento> tra=new ArrayList<Tratamiento>();
            DoctorDao dd=new DoctorDao();
            doc=dd.consulta();
            for(Doctor d:doc)
            {
                if(d.getNombre().equals(r.getnDoctor()))
                    r.setIdDoctor(d.getIdDoctor());
            }
            PacienteDao pd=new PacienteDao();
            pac=pd.consulta();
            for(Paciente d:pac)
            {
                if(d.getNombre().equals(r.getnPaciente()))
                    r.setIdPaciente(d.getIdPaciente());
            }
            TratamientoDao td=new TratamientoDao();
            tra=td.consulta();
            for(Tratamiento d:tra)
            {
                if(d.getDiagnostico().equals(r.getDiagnostico()))
                    r.setIdTratamiento(d.getIdTratamiento());
            }
            RecetaDao rd=new RecetaDao();
            boolean correcto=rd.alta(r);
            if(correcto)
                response.sendRedirect("pages/Principal.jsp");
            else
                response.sendRedirect("pages/AltaReceta.jsp");
        }
        if(pagina.equals("altaTratamiento"))
        {
            Tratamiento t=new Tratamiento();
            t.setDiagnostico(request.getParameter("diagnostico"));
            t.setMedicamento(request.getParameter("medicamento"));
            MedicamentoDao md=new MedicamentoDao();
            DiagnosticoDao dd=new DiagnosticoDao();
            ArrayList<Medicamento> medi=new ArrayList();
            ArrayList<Diagnostico> dia=new ArrayList();
            medi=md.consulta();
            dia=dd.consulta();
            for(Medicamento m:medi)
            {
                if(m.getNombre().equals(t.getMedicamento()))
                    t.setIdMedicamento(m.getIdMedicamento());
            }
            for(Diagnostico d:dia)
            {
                if(d.getNombre().equals(t.getDiagnostico()))
                    t.setIdDiagnostico(d.getIdDiagnostico());
            }
            TratamientoDao td=new TratamientoDao();
            boolean correcto=td.alta(t);
            if(correcto)
                response.sendRedirect("pages/Principal.jsp");
            else
                response.sendRedirect("pages/AltaTratamiento.jsp");
        }
        if(pagina.equals("altaDoctor"))
        {
            Doctor doc=new Doctor();
            doc.setNombre(request.getParameter("nombre"));
            doc.setPaterno(request.getParameter("paterno"));
            doc.setMaterno(request.getParameter("materno"));
            doc.setEdad(Integer.parseInt(request.getParameter("edad")));
            doc.setEmail(request.getParameter("email"));
            doc.setCedula(request.getParameter("cedula"));
            doc.setClave(request.getParameter("contra"));
            doc.setUsuario(request.getParameter("usuario"));
            doc.setTelefono(request.getParameter("telefono"));
            
            DoctorDao dd=new DoctorDao();
            boolean correcto=dd.alta(doc);
            if(correcto)
                response.sendRedirect("pages/login.html");
            else
                response.sendRedirect("pages/AltaDoctor.jsp");
        }
        if(pagina.equals("altaMedicamento"))
        {
            Medicamento med=new Medicamento();
            med.setNombre(request.getParameter("nombre"));
            med.setMarca(request.getParameter("marca"));
            med.setSubstancia(request.getParameter("substancia"));
            MedicamentoDao md=new MedicamentoDao();
            boolean correcto=md.alta(med);
            if(correcto)
                response.sendRedirect("pages/Principal.jsp");
            else
                response.sendRedirect("pages/AltaMedicamento.jsp");
        }
        if(pagina.equals("altaDiagnostico"))
        {
            Diagnostico dia=new Diagnostico();
            dia.setNombre(request.getParameter("nombre"));
            
            DiagnosticoDao dd=new DiagnosticoDao();
            boolean correcto=dd.alta(dia);
            if(correcto)
                response.sendRedirect("pages/Principal.jsp");
            else
                response.sendRedirect("pages/AltaDiagnostico.jsp");
        }
        if(pagina.equals("altaPaciente"))
        {
            Paciente pa=new Paciente();
            
            pa.setNombre(request.getParameter("nombre"));
            pa.setPaterno(request.getParameter("paterno"));
            pa.setMaterno(request.getParameter("materno"));
            pa.setEdad(Integer.parseInt(request.getParameter("edad")));
            pa.setEmail(request.getParameter("email"));
            pa.setTelefono(request.getParameter("telefono"));
            PacienteDao pd= new PacienteDao();
            boolean correcto=pd.alta(pa);
            if(correcto)
                response.sendRedirect("pages/Principal.jsp");
            else
                response.sendRedirect("pages/AltaPaciente.jsp");
        }
    }
    public Doctor login(String usuario,String contrasena)
    {
        Doctor existe=null;
        Doctor doc=new Doctor();
        doc.setUsuario(usuario);
        doc.setClave(contrasena);
        DoctorDao daodoc=new DoctorDao();
        ArrayList<Doctor> doctores;
        doctores = daodoc.consulta();
        
        
        for(Doctor doctor:doctores)
        {
            if(doctor.getUsuario().equals(doc.getUsuario())&&doctor.getClave().equals(doc.getClave()))
            {
                existe=doctor;
                
            }
        }
        return existe;
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
