package it.gesan.module.servizi.vo;

import it.gesan.rdb.abstracts.BaseVO;


public class ServizioVO extends BaseVO {
    private String descrizioneServizio;
    private String codiceAzienda;
    private String id;
    private String codiceServizio;

    public String getDescrizioneServizio() {
        return descrizioneServizio;
    }

    public void setDescrizioneServizio(String descrizioneServizio) {
        this.descrizioneServizio = descrizioneServizio;
    }

    public String getCodiceAzienda() {
        return codiceAzienda;
    }

    public void setCodiceAzienda(String codiceAzienda) {
        this.codiceAzienda = codiceAzienda;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodiceServizio() {
        return codiceServizio;
    }

    public void setCodiceServizio(String codiceServizio) {
        this.codiceServizio = codiceServizio;
    }
};
