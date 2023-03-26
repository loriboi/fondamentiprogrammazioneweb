/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.ProgettoFPW.model;

import it.unica.ProgettoFPW.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author fpw
 */
public class PostazioneFactory {
    private static PostazioneFactory instance;
    private PostazioneFactory(){}
    public static PostazioneFactory getInstance(){
        if(instance == null)
            instance = new PostazioneFactory();
        return instance;
    }
    public void addSlot(java.sql.Date data, int id_bagnino, int posti_mattina, int posti_sera){
        Connection conn = null;
        PreparedStatement stmt = null;
       
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            
            String query = "INSERT INTO prenotazione VALUES"
                    + "(default,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setDate(1, data);
            stmt.setInt(2, id_bagnino);
            stmt.setInt(3, posti_mattina);
            stmt.setInt(4, posti_sera);
            
            int i = stmt.executeUpdate();
           
            
        } catch(SQLException r){
            Logger.getLogger(PostazioneFactory.class.getName()).log(Level.SEVERE, null,r);
            
        }finally{
            
            try{ stmt.close();} catch(SQLException r){}
            try{ conn.close();} catch(SQLException r){}
        }
        
    }
    
    public static Postazione getSlotById(int id){
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet set = null;
        Postazione postazione = new Postazione();
        try{
        conn = DatabaseManager.getInstance().getDbConnection();
        String query ="SELECT * FROM prenotazione WHERE id_prenotazione =?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        set = stmt.executeQuery();
        if(set.next()){
        postazione.setId_bagnino(set.getInt("id_bagnino"));
        postazione.setData(set.getDate("data"));
        postazione.setId_prenotazione(set.getInt("id_prenotazione"));
        postazione.setPosti_mattina(set.getInt("posti_mattina"));
        postazione.setPosti_sera(set.getInt("posti_sera"));            
        return postazione;
        }
        } catch(SQLException e){
            Logger.getLogger(PostazioneFactory.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try{set.close();} catch (Exception e) {}
            try{stmt.close();} catch (Exception e) {}
            try{conn.close();} catch (Exception e) {}
        }
        return null;
        
    }
    public List<Postazione> getAllPostazioni(){
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet set = null; List<Postazione> prenotazioni = new ArrayList<>();
        try{
        conn = DatabaseManager.getInstance().getDbConnection();
        String query ="SELECT * FROM prenotazione";
        stmt = conn.prepareStatement(query);
        set = stmt.executeQuery();
        while(set.next()){
            Postazione prenotazione = new Postazione();
            prenotazione.setId_bagnino(set.getInt("id_bagnino"));
            prenotazione.setData(set.getDate("data"));
            prenotazione.setId_prenotazione(set.getInt("id_prenotazione"));
            prenotazione.setPosti_mattina(set.getInt("posti_mattina"));
            prenotazione.setPosti_sera(set.getInt("posti_sera"));
            prenotazioni.add(prenotazione);
            
        }
        return prenotazioni;
        } catch(SQLException e){
            Logger.getLogger(PostazioneFactory.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try{set.close();} catch (Exception e) {}
            try{stmt.close();} catch (Exception e) {}
            try{conn.close();} catch (Exception e) {}
        }
        return null;
        
        }
    
    public void updateSlot(int posti, int id_slot, String fascia){
        /*Togliere i posti dalla disponibilità*/
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        String col = null;
        
        if(fascia.equals("sera")){
            col = "posti_sera";
        }
        else if(fascia.equals("mattina")){
            col = "posti_mattina";
        }
        try{
            String query;
            conn = DatabaseManager.getInstance().getDbConnection();
            query = "UPDATE prenotazione SET "+col+" = "+posti+" WHERE id_prenotazione = ?";
            stmt = conn.prepareStatement(query);
            
            stmt.setInt(1,id_slot);
            
            int i = stmt.executeUpdate();
            
        } catch(SQLException r){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null,r);
            
        }finally{
            try{ set.close();} catch(Exception r){}
            try{ stmt.close();} catch(Exception r){}
            try{ conn.close();} catch(Exception r){}
        }
    
    }
}
