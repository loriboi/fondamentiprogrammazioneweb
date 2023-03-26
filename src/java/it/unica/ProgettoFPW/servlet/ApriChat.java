/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.ProgettoFPW.servlet;

import it.unica.ProgettoFPW.model.Fattura;
import it.unica.ProgettoFPW.model.FatturaFactory;
import it.unica.ProgettoFPW.model.Messaggio;
import it.unica.ProgettoFPW.model.MessaggioFactory;
import it.unica.ProgettoFPW.model.Utente;
import it.unica.ProgettoFPW.model.UtenteFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.lang.Boolean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fpw
 */
@WebServlet(name = "ApriChat", urlPatterns = {"/ApriChat"})
public class ApriChat extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        int id_user = new Integer(request.getParameter("users"));
        List<Messaggio> messaggi = MessaggioFactory.getInstance().getMessaggiForAdmin(id_user);
        if(messaggi.isEmpty()){
            Messaggio messaggio= new Messaggio();
            messaggio.setClasse("other");
            messaggio.setDestinatario("user");
            messaggio.setLetto("no");
            messaggio.setTesto("Non hai nessun messaggio");
            messaggio.setId_user(id_user);
            messaggio.setId_messaggio(1);
            messaggi.add(messaggio);
        }
        int fattura; 
        Utente utente = UtenteFactory.getInstance().getUtenteById(id_user);
        if(utente.getFattura().equals("si")){
            fattura = 1;
        }
        else{
            fattura = 0;
        }
        boolean domani = false;
        
       
        request.setAttribute("domani",domani);
        request.setAttribute("fattura",fattura);
        request.setAttribute("utente",utente);
        request.setAttribute("id_user",id_user);
        request.setAttribute("messaggi", messaggi);
        request.getRequestDispatcher("messaggi_adm.jsp").forward(request,response);
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
