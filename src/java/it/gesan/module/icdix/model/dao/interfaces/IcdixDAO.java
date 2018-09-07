package it.gesan.module.icdix.model.dao.interfaces;

import it.gesan.module.icdix.exception.DataException;
import it.gesan.module.icdix.vo.IcdixVO;
import it.gesan.rdb.beans.EsitoBean;


public interface IcdixDAO {
    public EsitoBean getLista(IcdixVO icdixVO) throws DataException;
    public EsitoBean getIcdixById(String id) throws DataException;
    public EsitoBean salva(IcdixVO icdixVO) throws DataException;
    public EsitoBean delete(IcdixVO icdixVO) throws DataException;
};
