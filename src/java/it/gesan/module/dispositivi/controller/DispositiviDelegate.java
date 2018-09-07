/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.module.dispositivi.controller;

import it.gesan.module.dispositivi.costants.Constants;
import it.gesan.module.dispositivi.model.dao.beans.EsitoBean;
import it.gesan.module.dispositivi.model.dao.interfaces.DAOFactory;
import it.gesan.module.dispositivi.model.dao.interfaces.DispositiviDAO;
import it.gesan.module.dispositivi.vo.DispositivoVO;

/**
 *
 * @author sisto
 */
public class DispositiviDelegate {

    private static DispositiviDelegate delegate = null;
    private DispositiviDAO dao = null;

    private DispositiviDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (DispositiviDAO) DAOFactory.getDAO(Constants.DISPOSITIVI_DAO_CLASS);
                //logger.debug("UserDAO instantiated:" + Constants.UTENTE_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to UserDAOjdbc!!", e);
        }

    }

    public static DispositiviDelegate getInstance() {
        if (delegate == null) {
            delegate = new DispositiviDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista(DispositivoVO dispositvoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(dispositvoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getDispositivoByClientId(String clientId, String codiceAzienda) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getDispositivoByClientId(clientId, codiceAzienda);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getDispositivoById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getDispositivoById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getMaster(String codiceAzienda) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getMaster(codiceAzienda);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(DispositivoVO dispositivoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(dispositivoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(DispositivoVO dispositivoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(dispositivoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
