/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.ProgettoFPW.servlet;

import it.unica.ProgettoFPW.model.Utente;
import it.unica.ProgettoFPW.model.UtenteFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

/**
 *
 * @author fpw
 */
@WebServlet(name = "SigninServlet", urlPatterns = {"/SigninServlet"})
public class SigninServlet extends HttpServlet {

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
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String email = request.getParameter("email");
            String datastr = request.getParameter("datanasc");
            String cf = request.getParameter("CF");
            String sesso = request.getParameter("sesso");
            String telefono = request.getParameter("telefono");
            String sceltaf = request.getParameter("sceltaf");
            String foto = request.getParameter("foto");
            
            java.sql.Date sqlData = Utils.convertStringDataSQL(datastr);
            
            
            UtenteFactory.getInstance().signUtente(user,pass,nome,cognome,email,sqlData,cf,sesso,telefono,sceltaf,foto);
            response.sendRedirect("login.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SigninServlet.class.getName()).log(Level.SEVERE, null, ex);
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
