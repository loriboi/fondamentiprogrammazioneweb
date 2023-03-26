/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.ProgettoFPW.model;

/**
 *
 * @author fpw
 */
public class Messaggio {
    private int id_messaggio;
    private int id_user;
    private String destinatario;
    private String letto;
    private String testo;
    private String classe;

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
    public int getId_messaggio() {
        return id_messaggio;
    }

    public void setId_messaggio(int id_messaggio) {
        this.id_messaggio = id_messaggio;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getLetto() {
        return letto;
    }

    public void setLetto(String letto) {
        this.letto = letto;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }
    
}
