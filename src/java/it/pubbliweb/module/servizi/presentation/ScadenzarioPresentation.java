/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pubbliweb.module.servizi.presentation;

import it.pubbliweb.module.servizi.controller.ScadenzarioDelegate;
import it.pubbliweb.module.servizi.exception.DataException;

/**
 *
 * @author sisto
 */
public class ScadenzarioPresentation {
    public static String getLista(String codiceAzienda){
        ScadenzarioDelegate delegate = ScadenzarioDelegate.getInstance();
        
        return delegate.getLista(codiceAzienda);
    }
    
    public static String getListaByCodiceDocumento(String codiceAzienda) {
        ScadenzarioDelegate delegate = ScadenzarioDelegate.getInstance();
        
        return delegate.getListaByCodiceDocumento(codiceAzienda);
    }
    
    public static String getScadenzaById(String id) {
        ScadenzarioDelegate delegate = ScadenzarioDelegate.getInstance();
        
        return delegate.getScadenzaById(id);
    }
    

    public static String salva(String jsonParams) {
        ScadenzarioDelegate delegate = ScadenzarioDelegate.getInstance();
        
        return delegate.salva(jsonParams);
    }

    public String delete(String jsonParams) {
        ScadenzarioDelegate delegate = ScadenzarioDelegate.getInstance();
        
        return delegate.delete(jsonParams);
    }     
}
