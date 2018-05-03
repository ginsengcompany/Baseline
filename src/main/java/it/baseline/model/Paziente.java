package it.baseline.model;


import javax.persistence.*;

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

    @Override
    public String toString() {

        return "{" +
                " 'codiceFiscale':'" + codiceFiscale + '\'' +
                ", 'nome':'" + nome + '\'' +
                ", 'cognome':'" + cognome + '\'' +
                '}';
    }
}
