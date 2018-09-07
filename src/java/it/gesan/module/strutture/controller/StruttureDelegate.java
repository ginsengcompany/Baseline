package it.gesan.module.strutture.controller;

import it.gesan.module.strutture.costants.Constants;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.strutture.model.dao.interfaces.DAOFactory;
import it.gesan.module.strutture.model.dao.interfaces.StruttureDAO;
import it.gesan.module.strutture.vo.StrutturaVO;

/**
 *
 * @author sisto
 */
public class StruttureDelegate {

    private static StruttureDelegate delegate = null;
    private StruttureDAO dao = null;

    private StruttureDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (StruttureDAO) DAOFactory.getDAO(Constants.STRUTTURE_DAO_CLASS);
                //logger.debug("StruttureDAO instantiated:" + Constants.STRUTTURE_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to StruttureDAO!!", e);
        }

    }

    public static StruttureDelegate getInstance() {
        if (delegate == null) {
            delegate = new StruttureDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista(StrutturaVO strutturaVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(strutturaVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getStrutturaById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getStrutturaById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getStrutturaByCodiceStruttura(String codiceStruttura) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getStrutturaByCodiceStruttura(codiceStruttura);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(StrutturaVO strutturaVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(strutturaVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(StrutturaVO strutturaVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(strutturaVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
