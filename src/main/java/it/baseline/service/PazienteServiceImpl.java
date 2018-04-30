package it.baseline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.baseline.model.Paziente;
import it.baseline.dao.PazienteDao;


@Service("pazienteService")
@Transactional
public class PazienteServiceImpl implements PazienteService {

    @Autowired
    private PazienteDao dao;

    public Paziente cercaCodiceFiscale(String codiceFiscale){
        return dao.cercaCodiceFiscale(codiceFiscale);
    }
}
