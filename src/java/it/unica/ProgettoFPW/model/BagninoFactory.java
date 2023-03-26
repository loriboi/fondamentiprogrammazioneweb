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
public class BagninoFactory {
    private static BagninoFactory instance;
    private BagninoFactory(){}
    public static BagninoFactory getInstance(){
        if(instance == null)
            instance = new BagninoFactory();
        return instance;
    }
    public void addBagnino(String nome, String cognome, String email, String attestati, String cellulare){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            
            String query = "INSERT INTO bagnino VALUES"
                    + "(default,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, email);
            stmt.setString(4, attestati);
            stmt.setString(5, cellulare);
            int i = stmt.executeUpdate();
           
            
        } catch(SQLException r){
            Logger.getLogger(BagninoFactory.class.getName()).log(Level.SEVERE, null,r);
            
        }finally{
          
            try{ stmt.close();} catch(SQLException r){}
            try{ conn.close();} catch(SQLException r){}
        }
        
    }
    public List<Bagnino> getAllBagnini(){
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet set = null; List<Bagnino> bagnini = new ArrayList<>();
        try{
        conn = DatabaseManager.getInstance().getDbConnection();
        String query ="SELECT * FROM bagnino";
        stmt = conn.prepareStatement(query);
        set = stmt.executeQuery();
        while(set.next()){
            Bagnino bagnino = new Bagnino();
            bagnino.setId(set.getInt("id_bagnino"));
            bagnino.setNome(set.getString("nome"));
            bagnino.setCognome(set.getString("cognome"));
            bagnino.setEmail(set.getString("email"));
            bagnino.setAttestati(set.getString("attestati"));
            bagnino.setCellulare(set.getString("cellulare"));
            bagnini.add(bagnino);
           
        }
        return bagnini;
        } catch(SQLException e){
            Logger.getLogger(BagninoFactory.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try{set.close();} catch (Exception e) {}
            try{stmt.close();} catch (Exception e) {}
            try{conn.close();} catch (Exception e) {}
        }
        return null;
        
        }
}
