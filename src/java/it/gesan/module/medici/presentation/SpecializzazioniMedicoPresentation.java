package it.gesan.module.medici.presentation;

import it.gesan.module.medici.controller.SpecializzazioniMedicoDelegate;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.medici.vo.SpecializzazioneMedicoVO;

/**
 *
 * @author sisto
 */
public class SpecializzazioniMedicoPresentation {

    public static EsitoBean getLista(SpecializzazioneMedicoVO specializzazioneMedicoVO) {
        SpecializzazioniMedicoDelegate delegate = SpecializzazioniMedicoDelegate.getInstance();
        return delegate.getLista(specializzazioneMedicoVO);
    }

    public static EsitoBean getLista(String filtroId, String proprietario) {
        SpecializzazioniMedicoDelegate delegate = SpecializzazioniMedicoDelegate.getInstance();
        return delegate.getLista(filtroId, proprietario);
    }

    public static EsitoBean getSpecializzazioneMedicoById(String id) {
        SpecializzazioniMedicoDelegate delegate = SpecializzazioniMedicoDelegate.getInstance();
        return delegate.getSpecializzazioneMedicoById(id);
    }

    public static EsitoBean salva(SpecializzazioneMedicoVO specializzazioneMedicoVO) {
        SpecializzazioniMedicoDelegate delegate = SpecializzazioniMedicoDelegate.getInstance();
        return delegate.salva(specializzazioneMedicoVO);
    }

    public static EsitoBean delete(SpecializzazioneMedicoVO specializzazioneMedicoVO) {
        SpecializzazioniMedicoDelegate delegate = SpecializzazioniMedicoDelegate.getInstance();
        return delegate.delete(specializzazioneMedicoVO);
    }
}
