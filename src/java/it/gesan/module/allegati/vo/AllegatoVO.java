package it.gesan.module.allegati.vo;

import it.gesan.rdb.abstracts.BaseVO;
import java.util.Date;


public class AllegatoVO extends BaseVO {
    private Date data;
    private String idRiferimento;
    private String descrizioneTipo;
    private String tipoRiferimento;
    private String tipoFile;
    private String estensione;
    private String descrizione;
    private String codiceTipo;
    private String file;
    private String id;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getIdRiferimento() {
        return idRiferimento;
    }

    public void setIdRiferimento(String idRiferimento) {
        this.idRiferimento = idRiferimento;
    }

    public String getDescrizioneTipo() {
        return descrizioneTipo;
    }

    public void setDescrizioneTipo(String descrizioneTipo) {
        this.descrizioneTipo = descrizioneTipo;
    }

    public String getTipoRiferimento() {
        return tipoRiferimento;
    }

    public void setTipoRiferimento(String tipoRiferimento) {
        this.tipoRiferimento = tipoRiferimento;
    }

    public String getTipoFile() {
        return tipoFile;
    }

    public void setTipoFile(String tipoFile) {
        this.tipoFile = tipoFile;
    }


    public String getEstensione() {
        return estensione;
    }

    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCodiceTipo() {
        return codiceTipo;
    }

    public void setCodiceTipo(String codiceTipo) {
        this.codiceTipo = codiceTipo;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

};
