package it.baseline.dao;

import it.baseline.model.Paziente;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("pazienteDao")
public class PazienteDaoImpl extends AbstractDao<Integer, Paziente> implements PazienteDao {

    public Paziente cercaCodiceFiscale(String codiceFiscale){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codiceFiscale", codiceFiscale));
        return (Paziente) crit.uniqueResult();
    }
}
