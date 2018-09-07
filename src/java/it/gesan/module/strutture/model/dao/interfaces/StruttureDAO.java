package it.gesan.module.strutture.model.dao.interfaces;

import it.gesan.module.strutture.exception.DataException;
import it.gesan.module.strutture.vo.StrutturaVO;
import it.gesan.rdb.beans.EsitoBean;


public interface StruttureDAO {
    public EsitoBean getLista(StrutturaVO strutturaVO) throws DataException;
    public EsitoBean getStrutturaById(String id) throws DataException;
    public EsitoBean getStrutturaByCodiceStruttura(String codiceStruttura) throws DataException;
    public EsitoBean salva(StrutturaVO strutturaVO) throws DataException;
    public EsitoBean delete(StrutturaVO strutturaVO) throws DataException;
};
