/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.inquinamento.parsingclass;

/**
 *
 * @author Fabrizio
 */
public class So2 {
    private String stazione;
    private String comune;
    private String provincia;
    private String um;
    private double mediaGiornaliera;
    private double massimoOrario;
    private String latitudine, longitudine;
    private double IQA;
    private final int limite = 350;
    private String color;

    /**
     * @return the stazione
     */
    public String getStazione() {
        return stazione;
    }

    /**
     * @param stazione the stazione to set
     */
    public void setStazione(String stazione) {
        this.stazione = stazione;
    }

    /**
     * @return the comune
     */
    public String getComune() {
        return comune;
    }

    /**
     * @param comune the comune to set
     */
    public void setComune(String comune) {
        this.comune = comune;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the um
     */
    public String getUm() {
        return um;
    }

    /**
     * @param um the um to set
     */
    public void setUm(String um) {
        this.um = um;
    }

    /**
     * @return the mediaGiornaliera
     */
    public double getMediaGiornaliera() {
        return mediaGiornaliera;
    }

    /**
     * @param mediaGiornaliera the mediaGiornaliera to set
     */
    public void setMediaGiornaliera(String mediaGiornaliera) {
        this.mediaGiornaliera = Double.parseDouble(mediaGiornaliera);
    }

    /**
     * @return the massimoOrario
     */
    public double getMassimoOrario() {
        return massimoOrario;
    }

    /**
     * @param massimoOrario the massimoOrario to set
     */
    public void setMassimoOrario(String massimoOrario) {
        this.massimoOrario = Double.parseDouble(massimoOrario);
        this.IQA = (this.massimoOrario / this.limite) * 100;
        this.setColor();
    }

    /**
     * @return the latitudine
     */
    public String getLatitudine() {
        return latitudine;
    }

    /**
     * @param latitudine the latitudine to set
     */
    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    /**
     * @return the longitudine
     */
    public String getLongitudine() {
        return longitudine;
    }

    /**
     * @param longitudine the longitudine to set
     */
    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }
    
    public double getIQA(){
        return this.IQA;
    }
    
    public String getColor(){
        return this.color;
    }
    
    private void setColor(){
        if(IQA <= 33)
            this.color = "#0000ff";
        else if(IQA > 33 && IQA <= 66)
            this.color = "#009900";
        else if(IQA > 66 && IQA <= 99)
            this.color = "#ffff00";
        else if(IQA > 99 && IQA <= 150)
            this.color = "#ff0000";
        else
            this.color = "#cc0099";
    }
}
