package it.gesan.module.portale.presentation;

import it.gesan.module.portale.controller.PortaleNewsDelegate;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.portale.vo.PortaleNewsVO;

/**
 *
 * @author sisto
 */
public class PortaleNewsPresentation {

    public static EsitoBean getLista(PortaleNewsVO portaleNewsVO) {
        PortaleNewsDelegate delegate = PortaleNewsDelegate.getInstance();
        return delegate.getLista(portaleNewsVO);
    }

    public static EsitoBean getLista(String filtroId, String proprietario) {
        PortaleNewsDelegate delegate = PortaleNewsDelegate.getInstance();
        return delegate.getLista(filtroId, proprietario);
    }

    public static EsitoBean getPortaleNewsById(String id) {
        PortaleNewsDelegate delegate = PortaleNewsDelegate.getInstance();
        return delegate.getPortaleNewsById(id);
    }

    public static EsitoBean salva(PortaleNewsVO portaleNewsVO) {
        PortaleNewsDelegate delegate = PortaleNewsDelegate.getInstance();
        return delegate.salva(portaleNewsVO);
    }

    public static EsitoBean delete(PortaleNewsVO portaleNewsVO) {
        PortaleNewsDelegate delegate = PortaleNewsDelegate.getInstance();
        return delegate.delete(portaleNewsVO);
    }
}
