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
        if(pagina.equals("login"))
        {
            
            Doctor existe=login(request.getParameter("usuario"),request.getParameter("contrasena"));
            if(existe!=null){
                request.setAttribute("usuario", existe);
                response.sendRedirect("pages/Principal.jsp");
            }
            
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
                response.sendRedirect("login.html");
            else
                response.sendRedirect("AltaPaciente.jsp");
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
