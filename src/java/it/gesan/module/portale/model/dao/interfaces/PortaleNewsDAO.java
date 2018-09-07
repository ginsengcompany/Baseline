package it.gesan.module.portale.model.dao.interfaces;

import it.gesan.module.portale.exception.DataException;
import it.gesan.module.portale.vo.PortaleNewsVO;
import it.gesan.rdb.beans.EsitoBean;


public interface PortaleNewsDAO {
    public EsitoBean getLista(PortaleNewsVO portaleNewsVO) throws DataException;
    public EsitoBean getLista(String filtroId, String proprietario) throws DataException;
    public EsitoBean getPortaleNewsById(String id) throws DataException;
    public EsitoBean salva(PortaleNewsVO portaleNewsVO) throws DataException;
    public EsitoBean delete(PortaleNewsVO portaleNewsVO) throws DataException;
};
