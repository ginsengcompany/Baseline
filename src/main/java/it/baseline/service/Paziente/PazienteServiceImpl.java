package it.baseline.service.Paziente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.baseline.model.Paziente;
import it.baseline.dao.paziente.PazienteDao;

import java.util.List;


@Service("pazienteService")
@Transactional
public class PazienteServiceImpl implements PazienteService {

    @Autowired
    private PazienteDao dao;

    public Paziente cercaCodiceFiscale(String codiceFiscale){
        return dao.cercaCodiceFiscale(codiceFiscale);
    }

    @Override
    public List<Paziente> getPazienti() {
        return dao.getPazienti();
    }

    @Override
    public Boolean updatePaziente(Paziente paziente) {
        return dao.updatePaziente(paziente);
    }

    @Override
    public Boolean deletePaziente(Paziente paziente) {
        return dao.deletePaziente(paziente);
    }
}
