/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pubbliweb.module.servizi.presentation;

import it.pubbliweb.module.servizi.controller.ComuniDelegate;

/**
 *
 * @author sisto
 */
public class ComuniPresentation {
    public static String getLista(String siglaProvincia){
        ComuniDelegate delegate = ComuniDelegate.getInstance();
        
        return delegate.getLista(siglaProvincia);
    }
}
