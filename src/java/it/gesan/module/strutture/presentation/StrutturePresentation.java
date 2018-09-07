package it.gesan.module.strutture.presentation;

import it.gesan.module.strutture.controller.StruttureDelegate;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.strutture.vo.StrutturaVO;

/**
 *
 * @author sisto
 */
public class StrutturePresentation {

    public static EsitoBean getLista(StrutturaVO strutturaVO) {
        StruttureDelegate delegate = StruttureDelegate.getInstance();
        return delegate.getLista(strutturaVO);
    }

    public static EsitoBean getStrutturaById(String id) {
        StruttureDelegate delegate = StruttureDelegate.getInstance();
        return delegate.getStrutturaById(id);
    }

    public static EsitoBean getStrutturaByCodiceStruttura(String codiceStruttura) {
        StruttureDelegate delegate = StruttureDelegate.getInstance();
        return delegate.getStrutturaByCodiceStruttura(codiceStruttura);
    }

    public static EsitoBean salva(StrutturaVO strutturaVO) {
        StruttureDelegate delegate = StruttureDelegate.getInstance();
        return delegate.salva(strutturaVO);
    }

    public static EsitoBean delete(StrutturaVO strutturaVO) {
        StruttureDelegate delegate = StruttureDelegate.getInstance();
        return delegate.delete(strutturaVO);
    }
}
