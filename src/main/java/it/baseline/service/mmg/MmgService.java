package it.baseline.service.mmg;

import it.baseline.model.Mmg;

/**
 * Created by IntelliJ IDEA.
 * User: Antonio Biondillo
 * Date: 26/04/2018
 * Time: 12:54 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public interface MmgService {
    Mmg cercaPaziente(int id);

    Mmg insertPaziente(int idPaziente, int idMedico);
}
