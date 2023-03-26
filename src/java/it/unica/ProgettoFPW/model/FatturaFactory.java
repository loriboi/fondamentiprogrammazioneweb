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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fpw
 */
public class FatturaFactory {
    private static FatturaFactory instance;
    private FatturaFactory(){}
    public static FatturaFactory getInstance(){
        if(instance == null)
            instance = new FatturaFactory();
        return instance;
    }
    public void addFattura(int posti, Postazione postazione, int id_utente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int prezzo = 4*posti;
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String servizio = "Sdraietta + ombrellone, 4 euro a postazione";
            String query = "INSERT INTO fattura (id,prezzo,data,posti,id_bagnino,descrizione,id_utente)"
                    + "VALUES (default,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, prezzo);
            stmt.setDate(2, postazione.getData());
            stmt.setInt(3, posti);
            stmt.setInt(4, postazione.getId_bagnino());
            stmt.setString(5, servizio);
            stmt.setInt(6, id_utente);
            int i = stmt.executeUpdate();
        } catch(SQLException r){
            Logger.getLogger(FatturaFactory.class.getName()).log(Level.SEVERE, null,r);
        }finally{
            try{ stmt.close();} catch(SQLException r){}
            try{ conn.close();} catch(SQLException r){}
        }
    }
    
    public List<Fattura> getAllFattureUtente(int id_utente){
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet set = null; List<Fattura> fatture = new ArrayList<>();
        try{
        String query;
        conn = DatabaseManager.getInstance().getDbConnection();
        query ="SELECT * FROM fattura WHERE id_utente = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1,id_utente);
        set = stmt.executeQuery();
        
        while(set.next()){
            Fattura fattura = new Fattura();
            fattura.setId(set.getInt("id"));
            fattura.setPrezzo(set.getInt("prezzo"));
            fattura.setData(set.getDate("data"));
            fattura.setPosti(set.getInt("posti"));
            fattura.setId_bagnino(set.getInt("id_bagnino"));
            fattura.setDescrizione(set.getString("descrizione"));
            fattura.setId_utente(set.getInt("id_utente"));
            fatture.add(fattura);
        }
        return fatture;
        } catch(SQLException e){
            Logger.getLogger(FatturaFactory.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try{set.close();} catch (Exception e) {}
            try{stmt.close();} catch (Exception e) {}
            try{conn.close();} catch (Exception e) {}
        }
        return null;
        
        }
}
