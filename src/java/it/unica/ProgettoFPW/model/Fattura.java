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
public class Fattura {
    int id;
    int id_utente;
    int id_postazione;
    int prezzo;
    Date data;
    int posti;
    int id_bagnino;
    String descrizione;
    public int getId_utente() {
        return id_utente;
    }

    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }

    public int getId_postazione() {
        return id_postazione;
    }

    public void setId_postazione(int id_postazione) {
        this.id_postazione = id_postazione;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPosti() {
        return posti;
    }

    public void setPosti(int posti) {
        this.posti = posti;
    }

    public int getId_bagnino() {
        return id_bagnino;
    }

    public void setId_bagnino(int id_bagnino) {
        this.id_bagnino = id_bagnino;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
}
