package it.gesan.module.allegati.model.dao.interfaces;

import it.gesan.module.allegati.exception.DataException;
import it.gesan.module.allegati.vo.AllegatoVO;
import it.gesan.rdb.beans.EsitoBean;


public interface AllegatiDAO {
    public EsitoBean getLista(AllegatoVO allegatoVO) throws DataException;
    public EsitoBean getLista(String idRisorsa, String tipoRisorsa) throws DataException;
    public EsitoBean getAllegatoById(String ids) throws DataException;
    public EsitoBean salva(AllegatoVO allegatoVO) throws DataException;
    public EsitoBean delete(AllegatoVO allegatoVO) throws DataException;
};
