/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.ProgettoFPW.servlet;

import it.unica.ProgettoFPW.model.UtenteFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 *
 * @author fpw
 */
@WebServlet(name = "ModificaInformazioniUser", urlPatterns = {"/ModificaInformazioniUser"})
public class ModificaInformazioniUser extends HttpServlet {

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
        try {
            
            String passNew;
            String nomeNew;
            String cognomeNew;
            String emailNew;
            String dataStrNew;
            String cfNew;
            String telefonoNew;
            String sessoNew;
            String sceltafNew;
            String fotoNew;
            
            
            int id = new Integer(request.getParameter("id"));
            
            String passOld = request.getParameter("passwordOld");
            String nomeOld = request.getParameter("nomeOld");
            String cognomeOld = request.getParameter("cognomeOld");
            String emailOld = request.getParameter("emailOld");
            String dataStrOld = request.getParameter("dataOld");
            java.sql.Date dataOld = Utils.convertStringDataSQL(dataStrOld);
            String cfOld = request.getParameter("cfOld");
            String sessoOld = request.getParameter("sessoOld");
            String telefonoOld = request.getParameter("telefonoOld");
            String sceltafOld = request.getParameter("fatturaOld");
            String fotoOld = request.getParameter("fotoOld");
            
            passNew = request.getParameter("passwordNew");
            nomeNew = request.getParameter("nomeNew");
            cognomeNew = request.getParameter("cognomeNew");         
            emailNew = request.getParameter("emailNew");
            dataStrNew = request.getParameter("dataNew");
            cfNew = request.getParameter("cfNew");
            sessoNew = request.getParameter("sessoNew");
            telefonoNew = request.getParameter("telefonoNew");  
            sceltafNew = request.getParameter("fatturaNew");
            fotoNew = request.getParameter("fotoNew");
            
            
            if(!(passNew.isEmpty())){UtenteFactory.getInstance().modifyParameterUser("password",passNew,id);}
            if(!(nomeNew.isEmpty())){UtenteFactory.getInstance().modifyParameterUser("nome",nomeNew,id);}
            if(!(cognomeNew.isEmpty())){UtenteFactory.getInstance().modifyParameterUser("cognome",cognomeNew,id);}
            if(!(emailNew.isEmpty())){UtenteFactory.getInstance().modifyParameterUser("email",emailNew,id);}
             
            if(!(dataStrNew.isEmpty())){
                java.sql.Date dataNew = Utils.convertStringDataSQL(dataStrNew);
                UtenteFactory.getInstance().modifyParameterUser(dataNew,id);
            }
       
            if(!(cfNew.isEmpty())){UtenteFactory.getInstance().modifyParameterUser("cf",cfNew,id);}
            if(!(sessoNew==null)){UtenteFactory.getInstance().modifyParameterUser("sesso",sessoNew,id);}
            if(!(telefonoNew.isEmpty())){UtenteFactory.getInstance().modifyParameterUser("telefono",telefonoNew,id);}
            if(!(sceltafNew==null)){UtenteFactory.getInstance().modifyParameterUser("fattura_elett",sceltafNew,id);}
            if(!(fotoNew.isEmpty())){UtenteFactory.getInstance().modifyParameterUser("foto",fotoNew,id);}
            
            response.sendRedirect("InformazioniPersonali");
                
        } catch (ParseException ex) {
            Logger.getLogger(ModificaInformazioniUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
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
