package it.gesan.module.anagraficatipo.controller;

import it.gesan.module.anagraficatipo.costants.Constants;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.anagraficatipo.model.dao.interfaces.DAOFactory;
import it.gesan.module.anagraficatipo.model.dao.interfaces.AnagraficaTipoDAO;
import it.gesan.module.anagraficatipo.vo.AnagraficaTipoVO;

/**
 *
 * @author sisto
 */
public class AnagraficaTipoDelegate {

    private static AnagraficaTipoDelegate delegate = null;
    private AnagraficaTipoDAO dao = null;

    private AnagraficaTipoDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (AnagraficaTipoDAO) DAOFactory.getDAO(Constants.ANAGRAFICATIPO_DAO_CLASS);
                //logger.debug("AnagraficaTipoDAO instantiated:" + Constants.ANAGRAFICATIPO_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to AnagraficaTipoDAO!!", e);
        }

    }

    public static AnagraficaTipoDelegate getInstance() {
        if (delegate == null) {
            delegate = new AnagraficaTipoDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista(AnagraficaTipoVO anagraficaTipoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(anagraficaTipoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getAnagraficaTipoById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getAnagraficaTipoById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(AnagraficaTipoVO anagraficaTipoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(anagraficaTipoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(AnagraficaTipoVO anagraficaTipoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(anagraficaTipoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
