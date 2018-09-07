package it.gesan.module.portale.controller;

import it.gesan.module.portale.costants.Constants;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.portale.model.dao.interfaces.DAOFactory;
import it.gesan.module.portale.model.dao.interfaces.PortaleNewsDAO;
import it.gesan.module.portale.vo.PortaleNewsVO;

/**
 *
 * @author sisto
 */
public class PortaleNewsDelegate {

    private static PortaleNewsDelegate delegate = null;
    private PortaleNewsDAO dao = null;

    private PortaleNewsDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (PortaleNewsDAO) DAOFactory.getDAO(Constants.PORTALENEWS_DAO_CLASS);
                //logger.debug("PortaleNewsDAO instantiated:" + Constants.PORTALENEWS_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to PortaleNewsDAO!!", e);
        }

    }

    public static PortaleNewsDelegate getInstance() {
        if (delegate == null) {
            delegate = new PortaleNewsDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista(PortaleNewsVO portaleNewsVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(portaleNewsVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getLista(String filtroId, String proprietario) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(filtroId, proprietario);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getPortaleNewsById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getPortaleNewsById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(PortaleNewsVO portaleNewsVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(portaleNewsVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(PortaleNewsVO portaleNewsVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(portaleNewsVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
