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
/**
 *
 * @author fpw
 */
public class AmministratoreFactory {
    private static AmministratoreFactory instance;
    
    private AmministratoreFactory(){}
    public static AmministratoreFactory getInstance(){
        if(instance == null)
            instance = new AmministratoreFactory();
        return instance;
    }
    public Amministratore getAmministratoreByUsernamePassword(String username, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            
            String query = "SELECT * FROM amministratore WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            set = stmt.executeQuery();
            if(set.next()){
                Amministratore amministratore = new Amministratore();
                amministratore.setUsername(set.getString("username"));
                amministratore.setPassword(set.getString("password"));
                return amministratore;
            }
            else{
                return null;
            }
                
            
        } catch(SQLException e){
            Logger.getLogger(AmministratoreFactory.class.getName()).log(Level.SEVERE, null,e);
            
        }finally{
            try{ set.close();} catch(Exception e){}
            try{ stmt.close();} catch(Exception e){}
            try{ conn.close();} catch(Exception e){}
        }
        return null;
    }
}
