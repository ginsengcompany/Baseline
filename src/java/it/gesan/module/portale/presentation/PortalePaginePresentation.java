package it.gesan.module.portale.presentation;

import it.gesan.module.portale.controller.PortalePagineDelegate;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.portale.vo.PortalePaginaVO;

/**
 *
 * @author sisto
 */
public class PortalePaginePresentation {

    public static EsitoBean getLista(PortalePaginaVO portalePaginaVO) {
        PortalePagineDelegate delegate = PortalePagineDelegate.getInstance();
        return delegate.getLista(portalePaginaVO);
    }

    public static EsitoBean getLista(String filtroId, String proprietario) {
        PortalePagineDelegate delegate = PortalePagineDelegate.getInstance();
        return delegate.getLista(filtroId, proprietario);
    }

    public static EsitoBean getPortalePaginaById(String id) {
        PortalePagineDelegate delegate = PortalePagineDelegate.getInstance();
        return delegate.getPortalePaginaById(id);
    }

    public static EsitoBean salva(PortalePaginaVO portalePaginaVO) {
        PortalePagineDelegate delegate = PortalePagineDelegate.getInstance();
        return delegate.salva(portalePaginaVO);
    }

    public static EsitoBean delete(PortalePaginaVO portalePaginaVO) {
        PortalePagineDelegate delegate = PortalePagineDelegate.getInstance();
        return delegate.delete(portalePaginaVO);
    }
}
