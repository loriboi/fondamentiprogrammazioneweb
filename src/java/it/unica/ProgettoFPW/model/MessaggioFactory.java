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
public class MessaggioFactory {
    private static MessaggioFactory instance;
    private MessaggioFactory(){}
    public static MessaggioFactory getInstance(){
        if(instance == null)
            instance = new MessaggioFactory();
        return instance;
    }
    public void sendMessage(int id_user, String destination, String letto, String testo){
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO messaggio (id,id_user,destinatario,letto,testo) values (default,?,?,?,?)";
            stmt=conn.prepareStatement(query);
            stmt.setInt(1,id_user);
            stmt.setString(2, destination);
            stmt.setString(3, letto);
            stmt.setString(4,testo);
            int i = stmt.executeUpdate();
        } catch(SQLException r){
            Logger.getLogger(MessaggioFactory.class.getName()).log(Level.SEVERE, null,r);
        }finally{
            try{ stmt.close();} catch(SQLException r){}
            try{ conn.close();} catch(SQLException r){}
        }
    }
    public void readMessagesForAdmin(int id_user){
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "UPDATE messaggio SET letto='si' WHERE id_user=? AND destinatario='admin' AND letto='no'";
            
            stmt=conn.prepareStatement(query);
            stmt.setInt(1, id_user);
            int i = stmt.executeUpdate();
        } catch(SQLException r){
            Logger.getLogger(MessaggioFactory.class.getName()).log(Level.SEVERE, null,r);
        }finally{
            try{ stmt.close();} catch(SQLException r){}
            try{ conn.close();} catch(SQLException r){}
        }
    }
    public void readMessagesForUser(int id_user){
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "UPDATE messaggio SET letto='si' WHERE id_user=? AND destinatario='user' AND letto='no'";
            
            stmt=conn.prepareStatement(query);
            stmt.setInt(1, id_user);
            int i = stmt.executeUpdate();
        } catch(SQLException r){
            Logger.getLogger(MessaggioFactory.class.getName()).log(Level.SEVERE, null,r);
        }finally{
            try{ stmt.close();} catch(SQLException r){}
            try{ conn.close();} catch(SQLException r){}
        }
    }
    public List<Messaggio> getMessaggiForUser(int id_user){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null; List<Messaggio> messaggi = new ArrayList<>();
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM messaggio WHERE id_user = ? ORDER BY id ASC";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,id_user);
            set = stmt.executeQuery();
            while(set.next()){
                Messaggio messaggio = new Messaggio();
                messaggio.setId_messaggio(set.getInt("id"));
                messaggio.setId_user(set.getInt("id_user"));
                messaggio.setDestinatario(set.getString("destinatario"));
                if(messaggio.getDestinatario().equals("admin")){
                    messaggio.setLetto("si");
                }
                else{
                messaggio.setLetto(set.getString("letto"));
                }
                messaggio.setTesto(set.getString("testo"));
                if(messaggio.getDestinatario().equals("admin")){
                    messaggio.setClasse("sender");
                }else{
                    messaggio.setClasse("other");
                }
                messaggi.add(messaggio);
            }
            return messaggi;
        }catch(SQLException r){
            Logger.getLogger(MessaggioFactory.class.getName()).log(Level.SEVERE, null,r);
        }finally{
            try{set.close();} catch (Exception e) {}
            try{stmt.close();} catch (Exception e) {}
            try{conn.close();} catch (Exception e) {}
        }
        return null;
        
    }
    public List<Messaggio> getMessaggiForAdmin(int id_user){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null; List<Messaggio> messaggi = new ArrayList<>();
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM messaggio WHERE id_user = ? ORDER BY id ASC";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,id_user);
            set = stmt.executeQuery();
            while(set.next()){
                Messaggio messaggio = new Messaggio();
                messaggio.setId_messaggio(set.getInt("id"));
                messaggio.setId_user(set.getInt("id_user"));
                messaggio.setDestinatario(set.getString("destinatario"));
                if(messaggio.getDestinatario().equals("user")){
                    messaggio.setLetto("si");
                }
                else{
                messaggio.setLetto(set.getString("letto"));
                }
                messaggio.setTesto(set.getString("testo"));
                if(messaggio.getDestinatario().equals("user")){
                    messaggio.setClasse("sender");
                }else{
                    messaggio.setClasse("other");
                }
                messaggi.add(messaggio);
            }
            return messaggi;
        }catch(SQLException r){
            Logger.getLogger(MessaggioFactory.class.getName()).log(Level.SEVERE, null,r);
        }finally{
            try{set.close();} catch (Exception e) {}
            try{stmt.close();} catch (Exception e) {}
            try{conn.close();} catch (Exception e) {}
        }
        return null;   
    }
    
    public List<Utente> getListaConversazioniNotRead(){
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet set = null; List<Utente> utenti = new ArrayList<>();
        try{
        String query;
        conn = DatabaseManager.getInstance().getDbConnection();
        query="SELECT utente.nome,utente.cognome FROM utente JOIN messaggio ON utente.id_utente = messaggio.id_user "
                + "WHERE letto='no' AND destinatario='admin' GROUP BY utente.id_utente;";
        stmt = conn.prepareStatement(query);
        set = stmt.executeQuery();
        
        while(set.next()){
            Utente utente = new Utente();
            utente.setNome(set.getString("nome"));
            utente.setCognome(set.getString("cognome"));
            utenti.add(utente);
        }
        return utenti;
        } catch(SQLException e){
            Logger.getLogger(PostazioneFactory.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try{set.close();} catch (Exception e) {}
            try{stmt.close();} catch (Exception e) {}
            try{conn.close();} catch (Exception e) {}
        }
        return null;
    }
}
