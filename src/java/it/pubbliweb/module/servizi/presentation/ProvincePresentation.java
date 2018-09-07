/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pubbliweb.module.servizi.presentation;

import it.pubbliweb.module.servizi.controller.ProvinceDelegate;

/**
 *
 * @author sisto
 */
public class ProvincePresentation {
    public static String getLista(){
        ProvinceDelegate delegate = ProvinceDelegate.getInstance();
        
        return delegate.getLista();
    }
}
