package it.baseline.model;

import javax.persistence.*;

@Entity
@Table(name = "paziente")
public class Paziente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
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
        return "Paziente{" +
                "id=" + id +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
