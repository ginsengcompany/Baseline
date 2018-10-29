/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.inquinamento.parsingclass;

import it.gesan.inquinamento.inquinamento.LatLong;

/**
 *
 * @author aldo
 */
public class Comune {
    private String nome;
    private LatLong coordinate;
    private int incidenza;
    
    public Comune(){
        this.coordinate = new LatLong();
    }
    
    public Comune(String nome, String latitudine, String longitudine, int incidenza){
        this.nome = nome;
        this.coordinate = new LatLong(latitudine,longitudine);
        this.incidenza = incidenza;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getLatitudine(){
        return this.coordinate.getLatitudine();
    }
    
    public String getLongitudine(){
        return this.coordinate.getLongitudine();
    }
    
    public int getIncidenza(){
        return this.incidenza;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setLatitudine(String latitudine){
        this.coordinate.setLatitudine(latitudine);
    }
    
    public void setLongitudine(String longitudine){
        this.coordinate.setLongitudine(longitudine);
    }
    
    public void setIncidenza(int incidenza){
        this.incidenza = incidenza;
    }
    
    public void setLatLong(String latitudine, String longitudine){
        this.coordinate = new LatLong(latitudine,longitudine);
    }
}
