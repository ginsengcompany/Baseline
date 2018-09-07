package it.gesan.module.medici.controller;

import it.gesan.module.medici.costants.Constants;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.medici.model.dao.interfaces.DAOFactory;
import it.gesan.module.medici.model.dao.interfaces.SpecializzazioniMedicoDAO;
import it.gesan.module.medici.vo.SpecializzazioneMedicoVO;

/**
 *
 * @author sisto
 */
public class SpecializzazioniMedicoDelegate {

    private static SpecializzazioniMedicoDelegate delegate = null;
    private SpecializzazioniMedicoDAO dao = null;

    private SpecializzazioniMedicoDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (SpecializzazioniMedicoDAO) DAOFactory.getDAO(Constants.SPECIALIZZAZIONIMEDICO_DAO_CLASS);
                //logger.debug("SpecializzazioniMedicoDAO instantiated:" + Constants.SPECIALIZZAZIONIMEDICO_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to SpecializzazioniMedicoDAO!!", e);
        }

    }

    public static SpecializzazioniMedicoDelegate getInstance() {
        if (delegate == null) {
            delegate = new SpecializzazioniMedicoDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista(SpecializzazioneMedicoVO specializzazioneMedicoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(specializzazioneMedicoVO);
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

    public EsitoBean getSpecializzazioneMedicoById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getSpecializzazioneMedicoById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(SpecializzazioneMedicoVO specializzazioneMedicoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(specializzazioneMedicoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(SpecializzazioneMedicoVO specializzazioneMedicoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(specializzazioneMedicoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
