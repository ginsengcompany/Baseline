package it.gesan.module.icdix.presentation;

import it.gesan.module.icdix.controller.IcdixDelegate;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.icdix.vo.IcdixVO;

/**
 *
 * @author sisto
 */
public class IcdixPresentation {

    public static EsitoBean getLista(IcdixVO icdixVO) {
        IcdixDelegate delegate = IcdixDelegate.getInstance();
        return delegate.getLista(icdixVO);
    }

    public static EsitoBean getIcdixById(String id) {
        IcdixDelegate delegate = IcdixDelegate.getInstance();
        return delegate.getIcdixById(id);
    }

    public static EsitoBean salva(IcdixVO icdixVO) {
        IcdixDelegate delegate = IcdixDelegate.getInstance();
        return delegate.salva(icdixVO);
    }

    public static EsitoBean delete(IcdixVO icdixVO) {
        IcdixDelegate delegate = IcdixDelegate.getInstance();
        return delegate.delete(icdixVO);
    }
}
