package it.gesan.module.medici.vo;

import it.gesan.rdb.abstracts.BaseVO;


public class MedicoVO  extends BaseVO {
    private String id;
    private String idAnagrafica;
    private String idSpecializzazione;
    private String idStruttura;
    private String numeroOrdine;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAnagrafica() {
        return idAnagrafica;
    }

    public void setIdAnagrafica(String idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    public String getIdSpecializzazione() {
        return idSpecializzazione;
    }

    public void setIdSpecializzazione(String idSpecializzazione) {
        this.idSpecializzazione = idSpecializzazione;
    }

    public String getIdStruttura() {
        return idStruttura;
    }

    public void setIdStruttura(String idStruttura) {
        this.idStruttura = idStruttura;
    }

    public String getNumeroOrdine() {
        return numeroOrdine;
    }

    public void setNumeroOrdine(String numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
