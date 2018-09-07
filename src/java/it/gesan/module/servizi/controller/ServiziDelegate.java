package it.gesan.module.servizi.controller;

import it.gesan.module.servizi.costants.Constants;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.servizi.model.dao.interfaces.DAOFactory;
import it.gesan.module.servizi.model.dao.interfaces.ServiziDAO;
import it.gesan.module.servizi.vo.ServizioVO;

/**
 *
 * @author sisto
 */
public class ServiziDelegate {

    private static ServiziDelegate delegate = null;
    private ServiziDAO dao = null;

    private ServiziDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (ServiziDAO) DAOFactory.getDAO(Constants.SERVIZI_DAO_CLASS);
                //logger.debug("ServiziDAO instantiated:" + Constants.SERVIZI_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to ServiziDAO!!", e);
        }

    }

    public static ServiziDelegate getInstance() {
        if (delegate == null) {
            delegate = new ServiziDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista(ServizioVO servizioVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(servizioVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getServizioById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getServizioById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(ServizioVO servizioVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(servizioVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(ServizioVO servizioVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(servizioVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
