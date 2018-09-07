package it.gesan.module.medici.presentation;

import it.gesan.module.medici.model.dao.beans.MedicoBean;
import it.gesan.module.medici.controller.MediciDelegate;
import it.gesan.rdb.beans.EsitoBean;;
import it.gesan.module.medici.vo.MedicoVO;

/**
 *
 * @author sisto
 */
public class MediciPresentation {

    public static EsitoBean getLista() {
        MediciDelegate delegate = MediciDelegate.getInstance();
        return delegate.getLista();
    }

    public static EsitoBean getListaRegistrati(String username) {
        MediciDelegate delegate = MediciDelegate.getInstance();
        return delegate.getListaRegistrati(username);
    }

    public static EsitoBean getLista(String filtroId, String proprietario) {
        MediciDelegate delegate = MediciDelegate.getInstance();
        return delegate.getLista(filtroId, proprietario);
    }

    public static EsitoBean getMedicoById(String id) {
        MediciDelegate delegate = MediciDelegate.getInstance();
        return delegate.getMedicoById(id);
    }

    public static EsitoBean getMedicoByCodiceFiscale(String codiceFiscale) {
        MediciDelegate delegate = MediciDelegate.getInstance();
        return delegate.getMedicoByCodiceFiscale(codiceFiscale);
    }

    public static EsitoBean salva(MedicoBean medicoBean) {
        MediciDelegate delegate = MediciDelegate.getInstance();
        return delegate.salva(medicoBean);
    }

    public static EsitoBean delete(MedicoVO medicoVO) {
        MediciDelegate delegate = MediciDelegate.getInstance();
        return delegate.delete(medicoVO);
    }
}
