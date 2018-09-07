package it.gesan.module.anagrafica.model.dao.interfaces;

import it.gesan.module.anagrafica.exception.DataException;
import it.gesan.module.anagrafica.vo.AnagraficaVO;
import it.gesan.rdb.beans.EsitoBean;


public interface AnagraficaDAO {
    public EsitoBean getLista(AnagraficaVO anagraficaVO) throws DataException;
    public EsitoBean getLista(String filtriId, String usernameProprietrio) throws DataException;
    public EsitoBean getAnagraficaById(String id) throws DataException;
    public EsitoBean salva(AnagraficaVO anagraficaVO) throws DataException;
    public EsitoBean delete(AnagraficaVO anagraficaVO) throws DataException;
};
