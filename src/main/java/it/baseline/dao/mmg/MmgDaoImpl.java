package it.baseline.dao.mmg;

import it.baseline.dao.AbstractDao;
import it.baseline.model.Mmg;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: Antonio Biondillo
 * Date: 26/04/2018
 * Time: 12:54 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Repository("mmgDao")
public class MmgDaoImpl extends AbstractDao<Integer, Mmg> implements MmgDao{

    @Override
    public Mmg cercaPaziente(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("idPaziente", id));
        return (Mmg) crit.uniqueResult();
    }

    @Override
    public Mmg insertPaziente(int idPaziente, int idMedico) {
        Mmg mmg = new Mmg();
        mmg.setIdMedico(idMedico);
        mmg.setIdPaziente(idPaziente);
        getSession().save(mmg);
        return mmg;
    }
}
