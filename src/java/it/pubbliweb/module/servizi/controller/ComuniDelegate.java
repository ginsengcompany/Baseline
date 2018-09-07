/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pubbliweb.module.servizi.controller;

import it.pubbliweb.module.servizi.costants.Constants;
import it.pubbliweb.module.servizi.model.dao.interfaces.ComuniDAO;
import it.pubbliweb.module.servizi.model.dao.interfaces.DAOFactory;

/**
 *
 * @author sisto
 */
public class ComuniDelegate {
    private static ComuniDelegate delegate = null;
    private ComuniDAO dao = null;

    private ComuniDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (ComuniDAO) DAOFactory.getDAO(Constants.COMUNI_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
        }

    }

    public static ComuniDelegate getInstance() {
        if (delegate == null) {
            delegate = new ComuniDelegate();
        }
        return delegate;
    }

    public String getLista(String siglaProvincia) {
        String returnValue = "[]";
        try {
            returnValue = this.dao.getLista(siglaProvincia);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }      
}
