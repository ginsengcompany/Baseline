package it.gesan.module.medici.vo;

import it.gesan.rdb.abstracts.BaseVO;


public class SpecializzazioneMedicoVO  extends BaseVO {
    private String id;
    private String descrizione;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

}
