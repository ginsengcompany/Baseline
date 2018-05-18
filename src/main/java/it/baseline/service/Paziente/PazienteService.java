package it.baseline.service.Paziente;

import it.baseline.model.Paziente;

import java.util.List;

public interface PazienteService {

    Paziente cercaCodiceFiscale(String codiceFiscale);

    List<Paziente> getPazienti();

    Boolean updatePaziente(Paziente paziente);

    Boolean deletePaziente(Paziente paziente);
}
