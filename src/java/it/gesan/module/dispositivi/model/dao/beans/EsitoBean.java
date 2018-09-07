/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.module.dispositivi.model.dao.beans;

import it.gesan.rdb.interfaces.IEsitoBean;

/**
 *
 * @author sistoandolfi
 */
public class EsitoBean implements IEsitoBean{
    private boolean esito = false;
    private int returnValue;
    private String messaggio;
    private Object object;

    @Override
    public int getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(int returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public boolean isEsito() {
        return this.esito;
    }

    @Override
    public void setEsito(boolean esito) {
        this.esito = esito;
    }
    
    
}
