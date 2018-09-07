package it.gesan.module.servizi.model.dao.interfaces;

import it.gesan.module.servizi.exception.DataException;
import it.gesan.module.servizi.vo.ServizioVO;
import it.gesan.rdb.beans.EsitoBean;


public interface ServiziDAO {
    public EsitoBean getLista(ServizioVO servizioVO) throws DataException;
    public EsitoBean getServizioById(String id) throws DataException;
    public EsitoBean salva(ServizioVO servizioVO) throws DataException;
    public EsitoBean delete(ServizioVO servizioVO) throws DataException;
};
