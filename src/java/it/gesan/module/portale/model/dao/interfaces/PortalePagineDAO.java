package it.gesan.module.portale.model.dao.interfaces;

import it.gesan.module.portale.exception.DataException;
import it.gesan.module.portale.vo.PortalePaginaVO;
import it.gesan.rdb.beans.EsitoBean;


public interface PortalePagineDAO {
    public EsitoBean getLista(PortalePaginaVO portalePaginaVO) throws DataException;
    public EsitoBean getLista(String filtroId, String proprietario) throws DataException;
    public EsitoBean getPortalePaginaById(String id) throws DataException;
    public EsitoBean salva(PortalePaginaVO portalePaginaVO) throws DataException;
    public EsitoBean delete(PortalePaginaVO portalePaginaVO) throws DataException;
};
