package it.gesan.module.strutture.vo;

import it.gesan.rdb.abstracts.BaseVO;


public class StrutturaVO  extends BaseVO {
    private String codiceSys;
    private boolean abilitata;
    private String indirizzo;
    private String codiceDistretto;
    private String provincia;
    private String codiceStruttura;
    private String comune;
    private String legaleRappresentante;
    private String denominazione;
    private String id;
    private String codiceRegione;
    private String telefono;
    private String fax;
    private String email;
    private String partitaIva;

    public String getCodiceSys() {
        return codiceSys;
    }

    public void setCodiceSys(String codiceSys) {
        this.codiceSys = codiceSys;
    }

    public boolean isAbilitata() {
        return abilitata;
    }

    public void setAbilitata(boolean abilitata) {
        this.abilitata = abilitata;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCodiceDistretto() {
        return codiceDistretto;
    }

    public void setCodiceDistretto(String codiceDistretto) {
        this.codiceDistretto = codiceDistretto;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodiceStruttura() {
        return codiceStruttura;
    }

    public void setCodiceStruttura(String codiceStruttura) {
        this.codiceStruttura = codiceStruttura;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getLegaleRappresentante() {
        return legaleRappresentante;
    }

    public void setLegaleRappresentante(String legaleRappresentante) {
        this.legaleRappresentante = legaleRappresentante;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodiceRegione() {
        return codiceRegione;
    }

    public void setCodiceRegione(String codiceRegione) {
        this.codiceRegione = codiceRegione;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

};
