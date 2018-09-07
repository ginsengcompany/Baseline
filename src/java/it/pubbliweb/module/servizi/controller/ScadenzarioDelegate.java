/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pubbliweb.module.servizi.controller;

import it.pubbliweb.module.servizi.costants.Constants;
import it.pubbliweb.module.servizi.exception.DataException;
import it.pubbliweb.module.servizi.model.dao.interfaces.DAOFactory;
import it.pubbliweb.module.servizi.model.dao.interfaces.ScadenzarioDAO;

/**
 *
 * @author sisto
 */
public class ScadenzarioDelegate {

    private static ScadenzarioDelegate delegate = null;
    private ScadenzarioDAO dao = null;

    private ScadenzarioDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (ScadenzarioDAO) DAOFactory.getDAO(Constants.SCADENZARIO_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
        }

    }

    public static ScadenzarioDelegate getInstance() {
        if (delegate == null) {
            delegate = new ScadenzarioDelegate();
        }
        return delegate;
    }

    public String getLista(String codiceAzienda) {
        String returnValue = "[]";
        try {
            returnValue = this.dao.getLista(codiceAzienda);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public String getListaByCodiceDocumento(String codiceAzienda) {
        String returnValue = "[]";
        try {
            returnValue = this.dao.getListaByCodiceDocumento(codiceAzienda);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public String getScadenzaById(String id) {
        String returnValue = "{}";
        try {
            returnValue = this.dao.getScadenzaById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public String salva(String jsonParams) {
        String returnValue = "{}";
        try {
            returnValue = this.dao.salva(jsonParams);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public String delete(String jsonParams) {
        String returnValue = "[]";
        try {
            returnValue = this.dao.delete(jsonParams);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
