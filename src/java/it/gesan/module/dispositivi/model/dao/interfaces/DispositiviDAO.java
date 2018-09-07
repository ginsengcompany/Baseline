package it.gesan.module.dispositivi.model.dao.interfaces;

import it.gesan.module.dispositivi.exception.DataException;
import it.gesan.module.dispositivi.model.dao.beans.EsitoBean;
import it.gesan.module.dispositivi.vo.DispositivoVO;


public interface DispositiviDAO {
    public EsitoBean getLista(DispositivoVO dispositivoVO) throws DataException;
    public EsitoBean getDispositivoByClientId(String clientId, String codiceAzienda) throws DataException;
    public EsitoBean getDispositivoById(String id) throws DataException;
    public EsitoBean getMaster(String codiceAzienda) throws DataException;
    public EsitoBean salva(DispositivoVO dispositivoVO) throws DataException;
    public EsitoBean delete(DispositivoVO dispositivoVO) throws DataException;
}
