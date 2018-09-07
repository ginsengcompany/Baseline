/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pubbliweb.module.servizi.controller;

import it.pubbliweb.module.servizi.costants.Constants;
import it.pubbliweb.module.servizi.model.dao.interfaces.DAOFactory;
import it.pubbliweb.module.servizi.model.dao.interfaces.ProvinceDAO;

/**
 *
 * @author sisto
 */
public class ProvinceDelegate {
    private static ProvinceDelegate delegate = null;
    private ProvinceDAO dao = null;

    private ProvinceDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (ProvinceDAO) DAOFactory.getDAO(Constants.PROVINCE_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
        }

    }

    public static ProvinceDelegate getInstance() {
        if (delegate == null) {
            delegate = new ProvinceDelegate();
        }
        return delegate;
    }

    public String getLista() {
        String returnValue = "[]";
        try {
            returnValue = this.dao.getLista();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }      
}
