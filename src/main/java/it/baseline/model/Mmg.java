package it.baseline.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Antonio Biondillo
 * Date: 26/04/2018
 * Time: 12:54 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Entity
@Table(name = "MMG_PLS_STRUTTURE")
public class Mmg {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="ID_PAZIENTE", nullable=false)
    private int idPaziente;

    @Column(name="ID_MEDICO", nullable=false)
    private int idMedico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaziente() {
        return idPaziente;
    }

    public void setIdPaziente(int idPaziente) {
        this.idPaziente = idPaziente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    @Override
    public String toString() {
        return "{" +
                "'id' :'" + id + '\'' +
                ", 'idPaziente':'" + idPaziente + '\'' +
                ", 'idMedico':'" + idMedico + '\'' +
                '}';
    }
}
