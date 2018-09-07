package it.gesan.module.anagrafica.controller;

import it.gesan.module.anagrafica.costants.Constants;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.anagrafica.model.dao.interfaces.DAOFactory;
import it.gesan.module.anagrafica.model.dao.interfaces.AnagraficaDAO;
import it.gesan.module.anagrafica.vo.AnagraficaVO;

/**
 *
 * @author sisto
 */
public class AnagraficaDelegate {

    private static AnagraficaDelegate delegate = null;
    private AnagraficaDAO dao = null;

    private AnagraficaDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (AnagraficaDAO) DAOFactory.getDAO(Constants.ANAGRAFICA_DAO_CLASS);
                //logger.debug("AnagraficaDAO instantiated:" + Constants.ANAGRAFICA_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to AnagraficaDAO!!", e);
        }

    }

    public static AnagraficaDelegate getInstance() {
        if (delegate == null) {
            delegate = new AnagraficaDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista(AnagraficaVO anagraficaVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(anagraficaVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getLista(String filtroId, String usernameProprietario) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(filtroId, usernameProprietario);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getAnagraficaById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getAnagraficaById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(AnagraficaVO anagraficaVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(anagraficaVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(AnagraficaVO anagraficaVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(anagraficaVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
