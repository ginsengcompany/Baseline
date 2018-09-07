package it.gesan.module.portale.vo;

import it.gesan.rdb.abstracts.BaseVO;
import java.util.Date;


public class PortalePaginaVO  extends BaseVO {
    private String id;
    private String tipo;
    private String titolo;
    private String body;
    private boolean pubblicato;
    private boolean viewTitolo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isPubblicato() {
        return pubblicato;
    }

    public void setPubblicato(boolean pubblicato) {
        this.pubblicato = pubblicato;
    }

    public boolean isViewTitolo() {
        return viewTitolo;
    }

    public void setViewTitolo(boolean viewTitolo) {
        this.viewTitolo = viewTitolo;
    }

}
