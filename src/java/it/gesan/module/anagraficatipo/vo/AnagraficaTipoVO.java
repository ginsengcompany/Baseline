package it.gesan.module.anagraficatipo.vo;

import it.gesan.rdb.abstracts.BaseVO;


public class AnagraficaTipoVO  extends BaseVO {
    private String idTipoAnagrafica;
    private String idAnagrafica;
    private String id;

    public String getIdTipoAnagrafica() {
        return idTipoAnagrafica;
    }

    public void setIdTipoAnagrafica(String idTipoAnagrafica) {
        this.idTipoAnagrafica = idTipoAnagrafica;
    }

    public String getIdAnagrafica() {
        return idAnagrafica;
    }

    public void setIdAnagrafica(String idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

};
