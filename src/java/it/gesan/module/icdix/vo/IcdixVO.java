package it.gesan.module.icdix.vo;

import it.gesan.rdb.abstracts.BaseVO;


public class IcdixVO  extends BaseVO {
    private String fineNodo;
    private String codiceIcdix;
    private int liv3;
    private String tipoNodo;
    private int liv1;
    private int id;
    private int liv2;
    private String descrizioneIcdix;
    private String nota;
    private String diagnosiReport;

    public String getFineNodo() {
        return fineNodo;
    }

    public void setFineNodo(String fineNodo) {
        this.fineNodo = fineNodo;
    }

    public String getCodiceIcdix() {
        return codiceIcdix;
    }

    public void setCodiceIcdix(String codiceIcdix) {
        this.codiceIcdix = codiceIcdix;
    }

    public int getLiv3() {
        return liv3;
    }

    public void setLiv3(int liv3) {
        this.liv3 = liv3;
    }

    public String getTipoNodo() {
        return tipoNodo;
    }

    public void setTipoNodo(String tipoNodo) {
        this.tipoNodo = tipoNodo;
    }

    public int getLiv1() {
        return liv1;
    }

    public void setLiv1(int liv1) {
        this.liv1 = liv1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLiv2() {
        return liv2;
    }

    public void setLiv2(int liv2) {
        this.liv2 = liv2;
    }

    public String getDescrizioneIcdix() {
        return descrizioneIcdix;
    }

    public void setDescrizioneIcdix(String descrizioneIcdix) {
        this.descrizioneIcdix = descrizioneIcdix;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDiagnosiReport() {
        return diagnosiReport;
    }

    public void setDiagnosiReport(String diagnosiReport) {
        this.diagnosiReport = diagnosiReport;
    }

};
