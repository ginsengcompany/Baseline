package it.baseline.dao;

import it.baseline.model.Paziente;

public interface PazienteDao {

    Paziente cercaCodiceFiscale(String codiceFiscale);
}
