package it.baseline.dao.paziente;

import it.baseline.model.Paziente;

import java.util.List;

public interface PazienteDao {

    Paziente cercaCodiceFiscale(String codiceFiscale);

    List<Paziente> getPazienti();

    Boolean updatePaziente(Paziente paziente);

    Boolean deletePaziente(Paziente paziente);
}
