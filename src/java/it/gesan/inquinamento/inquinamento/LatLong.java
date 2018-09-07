/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.inquinamento.inquinamento;

/**
 *
 * @author Fabrizio
 */
public class LatLong {
    private String latitudine, longitudine;
        
        public String getLatitudine(){
            return latitudine;
        }
        
        public String getLongitudine(){
            return longitudine;
        }
        
        public void setLatitudine(String latitudine){
            this.latitudine = latitudine;
        }
        
        public void setLongitudine(String longitudine){
            this.longitudine = longitudine;
        }
        
        public LatLong(String lat, String longi){
            this.latitudine = lat;
            this.longitudine = longi;
        }
}
