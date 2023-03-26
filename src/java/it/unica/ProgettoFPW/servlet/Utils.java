/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.ProgettoFPW.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author fpw
 */
@WebServlet(name = "Utils", urlPatterns = {"/Utils"})
public class Utils extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Utils</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Utils at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    public static String convertTime(long time){
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.setTimeInMillis(time);
        return (cal.get(Calendar.YEAR)+ "_"+(cal.get(Calendar.MONTH)+1)+"_"+cal.get(Calendar.DAY_OF_MONTH)+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
    }
    
    public static java.sql.Date dateOfToday(){
        long miliseconds = System.currentTimeMillis();
        java.sql.Date data = new java.sql.Date(miliseconds);
        return data;
    }
    public static java.sql.Date dateOfTomorrow(){
        long miliseconds = System.currentTimeMillis();
        java.sql.Date data = new java.sql.Date(miliseconds+(1000*60*60*24));
        return data;
    }
    public static void checkDates(java.sql.Date today, java.sql.Date dataPrenotazione) throws InvalidParamException{
        if(today.after(dataPrenotazione)){
            throw new InvalidParamException("La data della prenotazione non può essere prima della data odierna");
        }
    }
    public static void checkString(String param, int min, int max) throws InvalidParamException{
        if(param == null){
            throw new InvalidParamException("Parametro nullo");
        }
        if(param.length()<min||param.length()>max){
            throw new InvalidParamException("Stringa non valida, la dimensione deve essere compresa tra " + max +" e " +min);
        }
    }
    public static void checkString(String param, int length) throws InvalidParamException{
        if(param == null){
            throw new InvalidParamException("Parametro nullo");
        }
        if(param.length()!=length){
            throw new InvalidParamException("Stringa non valida, la dimensione deve essere di "+length+" caratteri");
        }
    }
    
    public static void checkInt(int number, int max, int min) throws InvalidParamException{
        if(number>max){
            throw new InvalidParamException("Non può essere più di" + max);
        }
        if(number<min){
            throw new InvalidParamException("Non può essere meno di" + min);
        }
    }
    public static java.sql.Date convertStringDataSQL(String dataStr) throws ParseException{
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date utilData = dateFormat.parse(dataStr);
         java.sql.Date sqlData = new java.sql.Date(utilData.getTime());
         return sqlData;
    }

}
