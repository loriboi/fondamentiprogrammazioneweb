/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.ProgettoFPW.model;

import it.unica.ProgettoFPW.db.DatabaseManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fpw
 */
public class UtenteFactory {
    private static UtenteFactory instance;
    
    private UtenteFactory(){}
    public static UtenteFactory getInstance(){
        if(instance == null)
            instance = new UtenteFactory();
        return instance;
    }
    public Utente getUtenteByUsernamePassword(String username, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            
            String query = "SELECT * FROM utente WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            set = stmt.executeQuery();
            if(set.next()){
                Utente utente = new Utente();
                
                utente.setUsername(set.getString("username"));
                utente.setPassword(set.getString("password"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setE_mail(set.getString("email"));
                utente.setFoto(set.getString("foto"));
                utente.setCf(set.getString("cf"));
                utente.setDataNascita(set.getDate("data_nascita"));
                utente.setFattura(set.getString("fattura_elett"));
                utente.setId(set.getInt("id_utente"));
                utente.setSesso(set.getString("sesso"));
                utente.setTelefono(set.getString("telefono"));
                return utente;
            }
            else{
                return null;
            }
                
            
        } catch(SQLException e){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null,e);
            
        }finally{
            try{ set.close();} catch(Exception e){}
            try{ stmt.close();} catch(Exception e){}
            try{ conn.close();} catch(Exception e){}
        }
        return null;
    }
    
    public void signUtente(String user,String pass,String nome,String cognome,String email,Date nasc,String cf,String sesso,String telefono,String sceltaf,String foto){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO utente VALUES"
                    + "(default,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            stmt.setString(3, nome);
            stmt.setString(4, cognome);
            stmt.setString(5, email);
            stmt.setString(6, cf);
            stmt.setString(7, sesso);
            stmt.setString(8, sceltaf);
            stmt.setString(9, foto);
            stmt.setString(10, telefono);
            stmt.setDate(11, nasc);            
            set = stmt.executeQuery();
        } catch(SQLException r){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null,r);
        }finally{
            try{ set.close();} catch(Exception r){}
            try{ stmt.close();} catch(Exception r){}
            try{ conn.close();} catch(Exception r){}
        }
    }
    
    public List<Utente> getAllIdNomiCognomi(){
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet set = null; List<Utente> utenti = new ArrayList<>();
        try{
        String query;
        conn = DatabaseManager.getInstance().getDbConnection();
        query="SELECT id_utente,nome,cognome FROM utente";
        stmt = conn.prepareStatement(query);
        set = stmt.executeQuery();
        
        while(set.next()){
            Utente utente = new Utente();
            utente.setId(set.getInt("id_utente"));
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
    
    public List<Utente> getAllUtenti(String ord_param,String ordine){
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet set = null; List<Utente> utenti = new ArrayList<>();
        try{
        String query;
        conn = DatabaseManager.getInstance().getDbConnection();
        if(ordine.equals("ASC")){
            query ="SELECT * FROM utente ORDER BY "+ord_param+" ASC";
        }
        else{
            query ="SELECT * FROM utente ORDER BY "+ord_param+" DESC";
        }
        
        stmt = conn.prepareStatement(query);
        
        
        set = stmt.executeQuery();
        
        while(set.next()){
            Utente utente = new Utente();
            utente.setCf(set.getString("cf"));   
            utente.setUsername(set.getString("username"));
            utente.setNome(set.getString("nome"));
            utente.setId(set.getInt("id_utente"));
            utente.setCognome(set.getString("cognome"));
            utente.setDataNascita(set.getDate("data_nascita"));
            utente.setE_mail(set.getString("email"));
            utente.setSesso(set.getString("sesso"));
            utente.setFattura(set.getString("fattura_elett"));
            utente.setTelefono(set.getString("telefono"));
            utente.setTotposti(set.getInt("tot_prenotazioni"));
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
    public Utente getUtenteById(int id){
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet set = null; 
        
        try{
        conn = DatabaseManager.getInstance().getDbConnection();
        String query ="SELECT * FROM utente WHERE id_utente ="+id;
        
        
        stmt = conn.prepareStatement(query);
        set = stmt.executeQuery();
        Utente utente = new Utente();
        while(set.next()){
            
            utente.setCf(set.getString("cf"));   
            utente.setUsername(set.getString("username"));
            utente.setNome(set.getString("nome"));
            utente.setId(set.getInt("id_utente"));
            utente.setCognome(set.getString("cognome"));
            utente.setDataNascita(set.getDate("data_nascita"));
            utente.setE_mail(set.getString("email"));
            utente.setSesso(set.getString("sesso"));
            utente.setFattura(set.getString("fattura_elett"));
            utente.setTelefono(set.getString("telefono"));
            utente.setTotposti(set.getInt("tot_prenotazioni"));
            
        }
            return utente;
        } catch(SQLException e){
            Logger.getLogger(PostazioneFactory.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try{set.close();} catch (Exception e) {}
            try{stmt.close();} catch (Exception e) {}
            try{conn.close();} catch (Exception e) {}
        }
        return null;
        
    }
    
    public Utente getUtenteByNomeCognomeData(String nome, String cognome, Date nasc){
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet set = null; 
        
        try{
        conn = DatabaseManager.getInstance().getDbConnection();
        String query ="SELECT * FROM utente WHERE nome = ? and cognome = ? and data_nascita = ?";
        
        
        stmt = conn.prepareStatement(query);
        stmt.setString(1, nome);
        stmt.setString(2, cognome);
        stmt.setDate(3, nasc);  
        set = stmt.executeQuery();
        Utente utente = new Utente();
        while(set.next()){
            utente.setCf(set.getString("cf"));   
            utente.setUsername(set.getString("username"));
            utente.setNome(set.getString("nome"));
            utente.setId(set.getInt("id_utente"));
            utente.setCognome(set.getString("cognome"));
            utente.setDataNascita(set.getDate("data_nascita"));
            utente.setE_mail(set.getString("email"));
            utente.setSesso(set.getString("sesso"));
            utente.setFattura(set.getString("fattura_elett"));
            utente.setTelefono(set.getString("telefono"));
            utente.setTotposti(set.getInt("tot_prenotazioni"));
        }
            return utente;
        } catch(SQLException e){
            Logger.getLogger(PostazioneFactory.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try{set.close();} catch (Exception e) {}
            try{stmt.close();} catch (Exception e) {}
            try{conn.close();} catch (Exception e) {}
        }
        return null;
        
    }
    public void modifyParameterUser(String col, String newParam, int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        try{
            String query;
            conn = DatabaseManager.getInstance().getDbConnection();
        
            query = "UPDATE utente SET "+col+" = ? WHERE id_utente = ?";
            stmt = conn.prepareStatement(query);
            
            stmt.setString(1,newParam);
            stmt.setInt(2,id);
            
            int i = stmt.executeUpdate();
            
        } catch(SQLException r){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null,r);
            
        }finally{
            try{ set.close();} catch(Exception r){}
            try{ stmt.close();} catch(Exception r){}
            try{ conn.close();} catch(Exception r){}
        }
     
    }
    public void modifyParameterUser(Date newDate, int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "UPDATE utente SET data_nascita = ? WHERE id_utente = ?";
            stmt.setDate(1,newDate);
            stmt.setInt(2,id);
            set = stmt.executeQuery();
         
            
        } catch(SQLException r){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null,r);
            
        }finally{
            try{ set.close();} catch(Exception r){}
            try{ stmt.close();} catch(Exception r){}
            try{ conn.close();} catch(Exception r){}
        }
   
    }
    public void modifyParameterUser(String col, int newParam, int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        try{
            String query;
            conn = DatabaseManager.getInstance().getDbConnection();
        
            query = "UPDATE utente SET "+col+" = ? WHERE id_utente = ?";
            stmt = conn.prepareStatement(query);
            
            stmt.setInt(1,newParam);
            stmt.setInt(2,id);
            
            int i = stmt.executeUpdate();
            
        } catch(SQLException r){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null,r);
            
        }finally{
            try{ set.close();} catch(Exception r){}
            try{ stmt.close();} catch(Exception r){}
            try{ conn.close();} catch(Exception r){}
        }
     
    }
    

    public ArrayList<String> getSuggerimenti() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        
        ArrayList<String> utenti = new ArrayList<>();
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT nome,cognome,data_nascita FROM utente ORDER BY nome";
            stmt = conn.prepareStatement(query);
            set = stmt.executeQuery();
            while(set.next()) {
                utenti.add(set.getString("nome")+ " " +set.getString("cognome")+ " " + set.getDate("data_nascita").toString());
                
            }
            
            return utenti;
        }catch(SQLException e){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try{
                set.close();
            } catch (Exception e){}
            try{
                stmt.close();
            } catch (Exception e){}
            try{
                conn.close();
            } catch (Exception e){}    
      
        }
        
        return null;
    }
}
