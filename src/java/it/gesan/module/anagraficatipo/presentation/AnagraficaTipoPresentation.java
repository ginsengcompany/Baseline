package it.gesan.module.anagraficatipo.presentation;

import it.gesan.module.anagraficatipo.controller.AnagraficaTipoDelegate;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.anagraficatipo.vo.AnagraficaTipoVO;

/**
 *
 * @author sisto
 */
public class AnagraficaTipoPresentation {

    public static EsitoBean getLista(AnagraficaTipoVO anagraficaTipoVO) {
        AnagraficaTipoDelegate delegate = AnagraficaTipoDelegate.getInstance();
        return delegate.getLista(anagraficaTipoVO);
    }

    public static EsitoBean getAnagraficaTipoById(String id) {
        AnagraficaTipoDelegate delegate = AnagraficaTipoDelegate.getInstance();
        return delegate.getAnagraficaTipoById(id);
    }

    public static EsitoBean salva(AnagraficaTipoVO anagraficaTipoVO) {
        AnagraficaTipoDelegate delegate = AnagraficaTipoDelegate.getInstance();
        return delegate.salva(anagraficaTipoVO);
    }

    public static EsitoBean delete(AnagraficaTipoVO anagraficaTipoVO) {
        AnagraficaTipoDelegate delegate = AnagraficaTipoDelegate.getInstance();
        return delegate.delete(anagraficaTipoVO);
    }
}
