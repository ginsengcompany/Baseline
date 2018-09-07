package it.gesan.module.anagraficatipo.model.dao.interfaces;

import it.gesan.module.anagraficatipo.exception.DataException;
import it.gesan.module.anagraficatipo.vo.AnagraficaTipoVO;
import it.gesan.rdb.beans.EsitoBean;


public interface AnagraficaTipoDAO {
    public EsitoBean getLista(AnagraficaTipoVO anagraficaTipoVO) throws DataException;
    public EsitoBean getAnagraficaTipoById(String id) throws DataException;
    public EsitoBean salva(AnagraficaTipoVO anagraficaTipoVO) throws DataException;
    public EsitoBean delete(AnagraficaTipoVO anagraficaTipoVO) throws DataException;
};
