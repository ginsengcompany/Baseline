package it.baseline.dao.paziente;

import it.baseline.dao.AbstractDao;
import it.baseline.model.Paziente;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("pazienteDao")
public class PazienteDaoImpl extends AbstractDao<Integer, Paziente> implements PazienteDao {

    public Paziente cercaCodiceFiscale(String codiceFiscale){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("codiceFiscale", codiceFiscale));
        return (Paziente) crit.uniqueResult();
    }

    @Override
    public List<Paziente> getPazienti() {
        Criteria crit = createEntityCriteria();

        List<Paziente> pazienti = new ArrayList<Paziente>();

        pazienti = crit.list();

        return pazienti;
    }

    @Override
    public Boolean updatePaziente(Paziente paziente) {
        try {
            getSession().update(paziente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean deletePaziente(Paziente paziente) {
        try {
            getSession().delete(paziente);
            if(paziente.getCodiceFiscale()==null){
                return false;
            }else{
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
