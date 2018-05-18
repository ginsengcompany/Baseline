package it.baseline.service.mmg;

import it.baseline.dao.mmg.MmgDao;
import it.baseline.model.Mmg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: Antonio Biondillo
 * Date: 26/04/2018
 * Time: 12:54 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Service("mmgService")
@Transactional
public class MmgServiceImpl implements MmgService{

    @Autowired
    private MmgDao dao;

    @Override
    public Mmg cercaPaziente(int id) {
        return dao.cercaPaziente(id);
    }

    @Override
    public Mmg insertPaziente(int idPaziente, int idMedico) {
        return dao.insertPaziente(idPaziente, idMedico);
    }
}
