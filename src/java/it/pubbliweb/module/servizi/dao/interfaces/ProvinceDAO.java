/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pubbliweb.module.servizi.model.dao.interfaces;

import it.pubbliweb.module.servizi.exception.DataException;

/**
 *
 * @author sisto
 */
public interface ProvinceDAO {
    public String getLista() throws DataException;
}
