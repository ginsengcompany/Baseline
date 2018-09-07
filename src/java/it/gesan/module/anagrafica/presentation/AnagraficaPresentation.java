package it.gesan.module.anagrafica.presentation;

import it.gesan.module.anagrafica.controller.AnagraficaDelegate;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.anagrafica.vo.AnagraficaVO;

/**
 *
 * @author sisto
 */
public class AnagraficaPresentation {

    public static EsitoBean getLista(AnagraficaVO anagraficaVO) {
        AnagraficaDelegate delegate = AnagraficaDelegate.getInstance();
        return delegate.getLista(anagraficaVO);
    }

    public static EsitoBean getLista(String filtroId, String usernameProprietario) {
        AnagraficaDelegate delegate = AnagraficaDelegate.getInstance();
        return delegate.getLista(filtroId, usernameProprietario);
    }

    public static EsitoBean getAnagraficaById(String id) {
        AnagraficaDelegate delegate = AnagraficaDelegate.getInstance();
        return delegate.getAnagraficaById(id);
    }

    public static EsitoBean salva(AnagraficaVO anagraficaVO) {
        AnagraficaDelegate delegate = AnagraficaDelegate.getInstance();
        return delegate.salva(anagraficaVO);
    }

    public static EsitoBean delete(AnagraficaVO anagraficaVO) {
        AnagraficaDelegate delegate = AnagraficaDelegate.getInstance();
        return delegate.delete(anagraficaVO);
    }
}
