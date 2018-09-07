package it.gesan.module.icdix.controller;

import it.gesan.module.icdix.costants.Constants;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.icdix.model.dao.interfaces.DAOFactory;
import it.gesan.module.icdix.model.dao.interfaces.IcdixDAO;
import it.gesan.module.icdix.vo.IcdixVO;

/**
 *
 * @author sisto
 */
public class IcdixDelegate {

    private static IcdixDelegate delegate = null;
    private IcdixDAO dao = null;

    private IcdixDelegate() {
        try {
            if (this.dao == null) {
                this.dao = (IcdixDAO) DAOFactory.getDAO(Constants.ICDIX_DAO_CLASS);
                //logger.debug("IcdixDAO instantiated:" + Constants.ICDIX_DAO_CLASS);
            }
        } catch (Exception e) {
            System.out.println("Errore nella creazione del Delegete: " + e.getMessage());
            //logger.error("Exception while connecting to IcdixDAO!!", e);
        }

    }

    public static IcdixDelegate getInstance() {
        if (delegate == null) {
            delegate = new IcdixDelegate();
        }
        return delegate;
    }

    public EsitoBean getLista(IcdixVO icdixVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getLista(icdixVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean getIcdixById(String id) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.getIcdixById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean salva(IcdixVO icdixVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.salva(icdixVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }

    public EsitoBean delete(IcdixVO icdixVO) {
        EsitoBean returnValue = null;
        try {
            returnValue = this.dao.delete(icdixVO);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return returnValue;
    }
}
