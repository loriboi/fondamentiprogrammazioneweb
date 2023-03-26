/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.ProgettoFPW.model;

import java.sql.Date;

/**
 *
 * @author fpw
 */
public class Postazione {
    private int id_prenotazione, id_bagnino, posti_mattina, posti_sera; 
    private Date data;

    public int getId_prenotazione() {
        return id_prenotazione;
    }

    public void setId_prenotazione(int id_prenotazione) {
        this.id_prenotazione = id_prenotazione;
    }

    public int getId_bagnino() {
        return id_bagnino;
    }

    public void setId_bagnino(int id_bagnino) {
        this.id_bagnino = id_bagnino;
    }

    public int getPosti_mattina() {
        return posti_mattina;
    }

    public void setPosti_mattina(int posti_mattina) {
        this.posti_mattina = posti_mattina;
    }

    public int getPosti_sera() {
        return posti_sera;
    }

    public void setPosti_sera(int posti_sera) {
        this.posti_sera = posti_sera;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
