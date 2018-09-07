/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.module.medici.model.dao.beans;

import it.gesan.module.anagrafica.vo.AnagraficaVO;
import it.gesan.module.medici.vo.MedicoVO;
import it.gesan.module.medici.vo.SpecializzazioneMedicoVO;
import it.gesan.module.strutture.vo.StrutturaVO;
import it.gesan.rdb.abstracts.BaseVO;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author sistoandolfi
 */
public class MedicoBean extends BaseVO {

    
    AnagraficaVO anagrafica = new AnagraficaVO();
    MedicoVO medico = new MedicoVO();
    StrutturaVO struttura = new StrutturaVO();
    SpecializzazioneMedicoVO specializzazioneMedico = new SpecializzazioneMedicoVO();
    String idUtente = null;

    @JsonIgnore
    public AnagraficaVO getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(AnagraficaVO anagrafica) {
        this.anagrafica = anagrafica;
    }

    @JsonIgnore
    public MedicoVO getMedico() {
        return medico;
    }

    public void setMedico(MedicoVO medico) {
        this.medico = medico;
    }

    public String getCognome() {
        return this.anagrafica.getCognome();
    }

    public void setCognome(String cognome) {
        this.anagrafica.setCognome(cognome);
    }

    public String getNome() {
        return this.anagrafica.getNome();
    }

    public void setNome(String nome) {
        this.anagrafica.setNome(nome);
    }

    public String getCodiceFiscale() {
        return this.anagrafica.getCodiceFiscale();
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.anagrafica.setCodiceFiscale(codiceFiscale);
    }

    public Date getDataNascita() {
        return this.anagrafica.getDataNascita();
    }

    public void setDataNascita(Date dataNascita) {
        this.anagrafica.setDataNascita(dataNascita);
    }

    public String getProvinciaNascita() {
        return this.anagrafica.getProvinciaNascita();
    }

    public void setProvinciaNascita(String provinciaNascita) {
        this.anagrafica.setProvinciaNascita(provinciaNascita);
    }

    public String getLocalitaNascita() {
        return this.anagrafica.getLocalitaNascita();
    }

    public void setLocalitaNascita(String localitaNascita) {
        this.anagrafica.setLocalitaNascita(localitaNascita);
    }

    public String getDenominazione() {
        return this.struttura.getDenominazione();
    }

    public void setDenominazione(String denominazione) {
        this.struttura.setDenominazione(denominazione);
    }

    public String getIdSpecializzazione() {
        return this.specializzazioneMedico.getId();
    }

    public void setIdSpecializzazione(String idSpecializzazione) {
        this.medico.setIdSpecializzazione(idSpecializzazione);
        this.specializzazioneMedico.setId(idSpecializzazione);
    }

    public String getIdAnagrafica() {
        return this.anagrafica.getId();
    }

    public void setIdAnagrafica(String idAnagrafica) {
        this.anagrafica.setId(idAnagrafica);
        this.anagrafica.setPrimaryKey(idAnagrafica);
    }

    public String getIdStruttura() {
        return this.struttura.getId();
    }

    public void setIdStruttura(String idStruttura) {
        this.medico.setIdStruttura(idStruttura);
        this.struttura.setId(idStruttura);
    }

    public String getNumeroOrdine() {
        return this.medico.getNumeroOrdine();
    }

    public void setNumeroOrdine(String numeroOrdine) {
        this.medico.setNumeroOrdine(numeroOrdine);
    }

    public String getDescrizione() {
        return this.specializzazioneMedico.getDescrizione();
    }

    public void setDescrizione(String descrizione) {
        this.specializzazioneMedico.setDescrizione(descrizione);
    }

    public String getSesso() {
        return "";
    }

    public void setSesso(String sesso) {
        //this.specializzazioneMedico.setDescrizione(sesso);
    }

    public void setId(String id){
        this.medico.setId(id);
    }

    public String getId(){
        return this.medico.getId();
    }

    public void setEmail(String email){
        this.medico.setEmail(email);
    }

    public String getEmail(){
        return this.medico.getEmail();
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }
    
    
}
