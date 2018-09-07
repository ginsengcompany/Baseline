package it.gesan.module.portale.controller;

import it.gesan.module.portale.costants.Constants;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.portale.model.dao.interfaces.DAOFactory;
import it.gesan.module.portale.model.dao.interfaces.PortalePagineDAO;
import it.gesan.module.portale.vo.PortalePaginaVO;

/**
 *
 * @author sisto
 */
public class PortalePagineDelegate {

    private static PortalePagineDelegate delegate = null;
    private PortalePagineDAO dao = null;

    private PortalePagineDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (PortalePagineDAO) DAOFactory.getDAO(Constants.PORTALEPAGINE_DAO_CLASS);
                //logger.debug("PortalePagineDAO instantiated:" + Constants.PORTALEPAGINE_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to PortalePagineDAO!!", e);
        }

    }

    public static PortalePagineDelegate getInstance() {
        if (delegate == null) {
            delegate = new PortalePagineDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista(PortalePaginaVO portalePaginaVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(portalePaginaVO);
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

    public EsitoBean getPortalePaginaById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getPortalePaginaById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(PortalePaginaVO portalePaginaVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(portalePaginaVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(PortalePaginaVO portalePaginaVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(portalePaginaVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
