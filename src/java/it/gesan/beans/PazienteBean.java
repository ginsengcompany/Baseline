/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.beans;

import it.gesan.module.allegati.vo.AllegatoVO;
import it.gesan.utility.DateAndTimeDeserialize;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 *
 * @author sistoandolfi
 */
@XmlRootElement
public class PazienteBean {

    String codiceFiscale;
    String codiceFiscaleMadre;
    String codiceFiscalePadre;
    String cognome;
    String cognomeMadre;
    String cognomePadre;
    
    @JsonDeserialize(using=DateAndTimeDeserialize.class)
    Date dataNascita;
    
    @JsonDeserialize(using=DateAndTimeDeserialize.class)
    Date dataNascitaMadre;
    
    @JsonDeserialize(using=DateAndTimeDeserialize.class)
    Date dataNascitaPadre;
    String id;
    String luogoNascita;
    String luogoNascitaMadre;
    String luogoNascitaPadre;
    String nome;
    String nomeMadre;
    String nomePadre;
    String provinciaNascita;
    String provinciaNascitaMadre;
    String provinciaNascitaPadre;
    String sesso;
    String sessoMadre;
    String sessoPadre;
    String descrizioneIcdix;
    String codiceIcdix;
    List<AllegatoVO> documenti = new ArrayList<>();

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceFiscaleMadre() {
        return codiceFiscaleMadre;
    }

    public void setCodiceFiscaleMadre(String codiceFiscaleMadre) {
        this.codiceFiscaleMadre = codiceFiscaleMadre;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognomeMadre() {
        return cognomeMadre;
    }

    public void setCognomeMadre(String cognomeMadre) {
        this.cognomeMadre = cognomeMadre;
    }

    public String getCognomePadre() {
        return cognomePadre;
    }

    public void setCognomePadre(String cognomePadre) {
        this.cognomePadre = cognomePadre;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Date getDataNascitaMadre() {
        return dataNascitaMadre;
    }

    public void setDataNascitaMadre(Date dataNascitaMadre) {
        this.dataNascitaMadre = dataNascitaMadre;
    }

    public Date getDataNascitaPadre() {
        return dataNascitaPadre;
    }

    public void setDataNascitaPadre(Date dataNascitaPadre) {
        this.dataNascitaPadre = dataNascitaPadre;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getLuogoNascitaMadre() {
        return luogoNascitaMadre;
    }

    public void setLuogoNascitaMadre(String luogoNascitaMadre) {
        this.luogoNascitaMadre = luogoNascitaMadre;
    }

    public String getLuogoNascitaPadre() {
        return luogoNascitaPadre;
    }

    public void setLuogoNascitaPadre(String luogoNascitaPadre) {
        this.luogoNascitaPadre = luogoNascitaPadre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMadre() {
        return nomeMadre;
    }

    public void setNomeMadre(String nomeMadre) {
        this.nomeMadre = nomeMadre;
    }

    public String getNomePadre() {
        return nomePadre;
    }

    public void setNomePadre(String nomePadre) {
        this.nomePadre = nomePadre;
    }

    public String getProvinciaNascita() {
        return provinciaNascita;
    }

    public void setProvinciaNascita(String provinciaNascita) {
        this.provinciaNascita = provinciaNascita;
    }

    public String getProvinciaNascitaMadre() {
        return provinciaNascitaMadre;
    }

    public void setProvinciaNascitaMadre(String provinciaNascitaMadre) {
        this.provinciaNascitaMadre = provinciaNascitaMadre;
    }

    public String getProvinciaNascitaPadre() {
        return provinciaNascitaPadre;
    }

    public void setProvinciaNascitaPadre(String provinciaNascitaPadre) {
        this.provinciaNascitaPadre = provinciaNascitaPadre;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getSessoMadre() {
        return sessoMadre;
    }

    public void setSessoMadre(String sessoMadre) {
        this.sessoMadre = sessoMadre;
    }

    public String getSessoPadre() {
        return sessoPadre;
    }

    public void setSessoPadre(String sessoPadre) {
        this.sessoPadre = sessoPadre;
    }

    public String getCodiceFiscalePadre() {
        return codiceFiscalePadre;
    }

    public void setCodiceFiscalePadre(String codiceFiscalePadre) {
        this.codiceFiscalePadre = codiceFiscalePadre;
    }

    public String getDescrizioneIcdix() {
        return descrizioneIcdix;
    }

    public void setDescrizioneIcdix(String descrizioneIcdix) {
        this.descrizioneIcdix = descrizioneIcdix;
    }

    public String getCodiceIcdix() {
        return codiceIcdix;
    }

    public void setCodiceIcdix(String codiceIcdix) {
        this.codiceIcdix = codiceIcdix;
    }

    public List<AllegatoVO> getDocumenti() {
        return documenti;
    }

    public void setDocumenti(List<AllegatoVO> documenti) {
        this.documenti = documenti;
    }
    
    
}
