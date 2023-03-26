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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fpw
 */
public class PrenotazioneFactory {
    private static PrenotazioneFactory instance;
    
    private PrenotazioneFactory(){}
    
    public static PrenotazioneFactory getInstance(){
        if(instance == null)
            instance = new PrenotazioneFactory();
        return instance;
    }
    
    public void prenota(int id_utente, int id_prenotazione, int posti, int postiMax, String fasciaOraria){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        /*Aggiungere in prenotazioneutente*/
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO prenotazioneutente VALUES"
                    + "(default,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id_utente);
            stmt.setInt(2, id_prenotazione);
            stmt.setInt(3, posti);
            stmt.setString(4,"no");
            
            int i = stmt.executeUpdate();
        } catch(SQLException r){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null,r);
        }finally{
            try{ set.close();} catch(Exception r){}
            try{ stmt.close();} catch(Exception r){}
            try{ conn.close();} catch(Exception r){}
        }
    }
    
    public List<Prenotazione> getAllPrenotazioni(){
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet set = null; List<Prenotazione> prenotazioni = new ArrayList<>();
        try{
        conn = DatabaseManager.getInstance().getDbConnection();
        String query ="SELECT * FROM prenotazioneutente WHERE processata = 'no' ";
        stmt = conn.prepareStatement(query);
        set = stmt.executeQuery();
        while(set.next()){
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setId(set.getInt("id"));
            prenotazione.setId_utente(set.getInt("id_utente"));
            prenotazione.setId_prenotazione(set.getInt("id_prenotazione"));
            prenotazione.setNumero_posti(set.getInt("posti_prenotati"));
            String prenotata = set.getString("processata");
            if(prenotata.equals("no")){prenotazione.setProcessata(false);}
            else{prenotazione.setProcessata(true);}
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
    
    public void removeFromListById(int id_prenotazione){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        try{
            String query;
            conn = DatabaseManager.getInstance().getDbConnection();
        
            query = "DELETE FROM prenotazioneutente WHERE id = ?";
            stmt = conn.prepareStatement(query);
            
            stmt.setInt(1,id_prenotazione);
            
            int i = stmt.executeUpdate();
            
        } catch(SQLException r){
            Logger.getLogger(PrenotazioneFactory.class.getName()).log(Level.SEVERE, null,r);
            
        }finally{
            try{ set.close();} catch(Exception r){}
            try{ stmt.close();} catch(Exception r){}
            try{ conn.close();} catch(Exception r){}
        }
    }
}
