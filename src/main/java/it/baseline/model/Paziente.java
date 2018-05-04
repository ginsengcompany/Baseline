package it.baseline.model;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "PAZIENTE")
public class Paziente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "CODICE_FISCALE", nullable=false)
    private String codiceFiscale;

    @Column(name = "NOME", nullable=false)
    private String nome;

    @Column(name = "COGNOME", nullable=false)
    private String cognome;

    @Column(name = "DATA_NASCITA", nullable=false)
    private Date dataNascita;

    @Column(name = "LUOGO_NASCITA", nullable=false)
    private String luogoNascita;

    @Column(name = "ALTEZZA", nullable=false)
    private String altezza;

    @Column(name = "CITTADINANZA", nullable=false)
    private String cittadinanza;

    @Column(name = "RESIDENZA", nullable=false)
    private String residenza;

    @Column(name = "SESSO", nullable=false)
    private String sesso;

    @Column(name = "PROVINCIA", nullable=false)
    private String provincia;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getAltezza() {
        return altezza;
    }

    public void setAltezza(String altezza) {
        this.altezza = altezza;
    }

    public String getCittadinanza() {
        return cittadinanza;
    }

    public void setCittadinanza(String cittadinanza) {
        this.cittadinanza = cittadinanza;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        return "{" +
                "'codiceFiscale':'" + codiceFiscale + '\'' +
                ", 'nome':'" + nome + '\'' +
                ", 'cognome':'" + cognome + '\'' +
                ", 'dataNascita':'" + df.format(dataNascita) + '\'' +
                ", 'luogoNascita':'" + luogoNascita + '\'' +
                ", 'altezza':'" + altezza + '\'' +
                ", 'cittadinanza':'" + cittadinanza + '\'' +
                ", 'residenza':'" + residenza + '\'' +
                ", 'sesso':'" + sesso + '\'' +
                ", 'provincia':'" + provincia + '\'' +
                '}';
    }

}
