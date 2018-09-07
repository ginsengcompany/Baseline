package it.gesan.module.servizi.presentation;

import it.gesan.module.servizi.controller.ServiziDelegate;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.servizi.vo.ServizioVO;

/**
 *
 * @author sisto
 */
public class ServiziPresentation {

    public static EsitoBean getLista(ServizioVO servizioVO) {
        ServiziDelegate delegate = ServiziDelegate.getInstance();
        return delegate.getLista(servizioVO);
    }

    public static EsitoBean getServizioById(String id) {
        ServiziDelegate delegate = ServiziDelegate.getInstance();
        return delegate.getServizioById(id);
    }

    public static EsitoBean salva(ServizioVO servizioVO) {
        ServiziDelegate delegate = ServiziDelegate.getInstance();
        return delegate.salva(servizioVO);
    }

    public static EsitoBean delete(ServizioVO servizioVO) {
        ServiziDelegate delegate = ServiziDelegate.getInstance();
        return delegate.delete(servizioVO);
    }
}
