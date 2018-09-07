/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.module.dispositivi.presentation;

import it.gesan.module.dispositivi.controller.DispositiviDelegate;
import it.gesan.module.dispositivi.model.dao.beans.EsitoBean;
import it.gesan.module.dispositivi.vo.DispositivoVO;

/**
 *
 * @author sisto
 */
public class DispositiviPresentation {
    
    public static EsitoBean getLista(DispositivoVO dispositivoVO) {
        DispositiviDelegate delegate = DispositiviDelegate.getInstance();
        return delegate.getLista(dispositivoVO);
    }
    
    public static EsitoBean getDispositivoByClientId(String clientId, String codiceAzienda){
        DispositiviDelegate delegate = DispositiviDelegate.getInstance();
        return delegate.getDispositivoByClientId(clientId, codiceAzienda);
    }
    
    public static EsitoBean getDispositivoById(String id){
        DispositiviDelegate delegate = DispositiviDelegate.getInstance();
        return delegate.getDispositivoById(id);
    }
    
    public static EsitoBean getMaster(String codiceAzienda){
        DispositiviDelegate delegate = DispositiviDelegate.getInstance();
        return delegate.getMaster(codiceAzienda);
    }
    
    public static EsitoBean salva(DispositivoVO dispositivoVO){
        DispositiviDelegate delegate = DispositiviDelegate.getInstance();
        return delegate.salva(dispositivoVO);
    }
    
    public static EsitoBean delete(DispositivoVO dispositivoVO){
        DispositiviDelegate delegate = DispositiviDelegate.getInstance();
        return delegate.delete(dispositivoVO);
    }
    
}
