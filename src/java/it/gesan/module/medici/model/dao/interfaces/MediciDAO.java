package it.gesan.module.medici.model.dao.interfaces;

import it.gesan.module.medici.model.dao.beans.MedicoBean;
import it.gesan.module.medici.exception.DataException;
import it.gesan.module.medici.vo.MedicoVO;
import it.gesan.rdb.beans.EsitoBean;


public interface MediciDAO {
    public EsitoBean getLista() throws DataException;
    public EsitoBean getListaRegistrati(String username) throws DataException;
    public EsitoBean getLista(String filtroId, String proprietario) throws DataException;
    public EsitoBean getMedicoById(String id) throws DataException;
    public EsitoBean getMedicoByCodiceFiscale(String codiceFiscale) throws DataException;
    public EsitoBean salva(MedicoBean medicoVO) throws DataException;
    public EsitoBean delete(MedicoVO medicoVO) throws DataException;
};
