package it.gesan.module.allegati.presentation;

import it.gesan.module.allegati.controller.AllegatiDelegate;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.allegati.vo.AllegatoVO;

/**
 *
 * @author sisto
 */
public class AllegatiPresentation {

    public static EsitoBean getLista(AllegatoVO allegatoVO) {
        AllegatiDelegate delegate = AllegatiDelegate.getInstance();
        return delegate.getLista(allegatoVO);
    }

    public static EsitoBean getLista(String idRisorsa, String tipoRisorsa) {
        AllegatiDelegate delegate = AllegatiDelegate.getInstance();
        return delegate.getLista(idRisorsa, tipoRisorsa);
    }

    public static EsitoBean getAllegatoById(String id) {
        AllegatiDelegate delegate = AllegatiDelegate.getInstance();
        return delegate.getAllegatoById(id);
    }

    public static EsitoBean salva(AllegatoVO allegatoVO) {
        AllegatiDelegate delegate = AllegatiDelegate.getInstance();
        return delegate.salva(allegatoVO);
    }

    public static EsitoBean delete(AllegatoVO allegatoVO) {
        AllegatiDelegate delegate = AllegatiDelegate.getInstance();
        return delegate.delete(allegatoVO);
    }
}
