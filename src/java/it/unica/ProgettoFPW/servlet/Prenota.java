/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.ProgettoFPW.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unica.ProgettoFPW.model.Prenotazione;
import it.unica.ProgettoFPW.model.PrenotazioneFactory;
import it.unica.ProgettoFPW.model.PostazioneFactory;
import java.text.ParseException;

/**
 *
 * @author fpw
 */
@WebServlet(name = "Prenota", urlPatterns = {"/Prenota"})
public class Prenota extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws it.unica.ProgettoFPW.servlet.InvalidParamException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidParamException{
        response.setContentType("text/html;charset=UTF-8");
        
        int id_u = new Integer(request.getParameter("id_u"));
        int id_p = new Integer(request.getParameter("id_p"));
        int posti = new Integer(request.getParameter("prenotaposti"));
        int posti_sera = new Integer(request.getParameter("posti_sera"));
        int posti_mattina = new Integer(request.getParameter("posti_mattina"));
        String fascia = request.getParameter("fascia");
        
        
        try{
        String message = "Prenotazione effettuata";
        
        int posti_max=0;
        if(fascia.equals("sera")){
                posti_max = posti_sera;
            
        }
        if(fascia.equals("mattina")){
                posti_max = posti_mattina;             
        }
        if(posti>posti_max){
            throw new InvalidParamException("Non puoi prenotare più posti di quanti sono quelli disponibili");
        }
        int posti_restanti = posti_max - posti;
        
        if(fascia!= null && posti_max!=0){
            PrenotazioneFactory.getInstance().prenota(id_u,id_p,posti,posti_max,fascia);
            PostazioneFactory.getInstance().updateSlot(posti_restanti,id_p,fascia);
        }
        response.sendRedirect("ListPostazioni");
        } catch(InvalidParamException e){
           
            request.setAttribute("errorMessage", e.getMessage());
            
            request.getRequestDispatcher("errorParam.jsp").forward(request,response);
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
        try {
            processRequest(request, response);
        } catch (InvalidParamException ex) {
            Logger.getLogger(Prenota.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (InvalidParamException ex) {
            Logger.getLogger(Prenota.class.getName()).log(Level.SEVERE, null, ex);
        }
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
