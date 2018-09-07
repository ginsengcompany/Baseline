package it.gesan.module.allegati.controller;

import it.gesan.module.allegati.costants.Constants;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.allegati.model.dao.interfaces.DAOFactory;
import it.gesan.module.allegati.model.dao.interfaces.AllegatiDAO;
import it.gesan.module.allegati.vo.AllegatoVO;

/**
 *
 * @author sisto
 */
public class AllegatiDelegate {

    private static AllegatiDelegate delegate = null;
    private AllegatiDAO dao = null;

    private AllegatiDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (AllegatiDAO) DAOFactory.getDAO(Constants.ALLEGATI_DAO_CLASS);
                //logger.debug("AllegatiDAO instantiated:" + Constants.ALLEGATI_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to AllegatiDAO!!", e);
        }

    }

    public static AllegatiDelegate getInstance() {
        if (delegate == null) {
            delegate = new AllegatiDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista(AllegatoVO allegatoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(allegatoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getLista(String idRisorsa, String tipoRisorsa) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(idRisorsa, tipoRisorsa);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getAllegatoById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getAllegatoById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(AllegatoVO allegatoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(allegatoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(AllegatoVO allegatoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(allegatoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
