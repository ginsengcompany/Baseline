/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.module.dispositivi.vo;

import it.gesan.rdb.abstracts.BaseVO;


/**
 *
 * @author sistoandolfi
 */
public class DispositivoVO extends BaseVO{
    private String id;
    private String codiceUtente;
    private String tipoDispositivo;
    private String clientId;
    private String descrizione;
    private String impronta;
    private String tipo;
    private boolean attivo;
    private String applicazione;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodiceUtente() {
        return codiceUtente;
    }

    public void setCodiceUtente(String codiceAzienda) {
        this.codiceUtente = codiceAzienda;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImpronta() {
        return impronta;
    }

    public void setImpronta(String impronta) {
        this.impronta = impronta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public String getApplicazione() {
        return applicazione;
    }

    public void setApplicazione(String applicazione) {
        this.applicazione = applicazione;
    }

    
}
