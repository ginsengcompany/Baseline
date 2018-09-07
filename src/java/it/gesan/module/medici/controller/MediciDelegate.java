package it.gesan.module.medici.controller;

import it.gesan.module.medici.model.dao.beans.MedicoBean;
import it.gesan.module.medici.costants.Constants;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.medici.model.dao.interfaces.DAOFactory;
import it.gesan.module.medici.model.dao.interfaces.MediciDAO;
import it.gesan.module.medici.vo.MedicoVO;

/**
 *
 * @author sisto
 */
public class MediciDelegate {

    private static MediciDelegate delegate = null;
    private MediciDAO dao = null;

    private MediciDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (MediciDAO) DAOFactory.getDAO(Constants.MEDICI_DAO_CLASS);
                //logger.debug("MediciDAO instantiated:" + Constants.MEDICI_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to MediciDAO!!", e);
        }

    }

    public static MediciDelegate getInstance() {
        if (delegate == null) {
            delegate = new MediciDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista() {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getListaRegistrati(String username) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getListaRegistrati(username);
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

    public EsitoBean getMedicoById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getMedicoById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getMedicoByCodiceFiscale(String codiceFiscale) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getMedicoByCodiceFiscale(codiceFiscale);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(MedicoBean medicoBean) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(medicoBean);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(MedicoVO medicoVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(medicoVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
