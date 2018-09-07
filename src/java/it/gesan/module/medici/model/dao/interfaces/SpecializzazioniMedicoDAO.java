package it.gesan.module.medici.model.dao.interfaces;

import it.gesan.module.medici.exception.DataException;
import it.gesan.module.medici.vo.SpecializzazioneMedicoVO;
import it.gesan.rdb.beans.EsitoBean;


public interface SpecializzazioniMedicoDAO {
    public EsitoBean getLista(SpecializzazioneMedicoVO specializzazioneMedicoVO) throws DataException;
    public EsitoBean getLista(String filtroId, String proprietario) throws DataException;
    public EsitoBean getSpecializzazioneMedicoById(String id) throws DataException;
    public EsitoBean salva(SpecializzazioneMedicoVO specializzazioneMedicoVO) throws DataException;
    public EsitoBean delete(SpecializzazioneMedicoVO specializzazioneMedicoVO) throws DataException;
};
