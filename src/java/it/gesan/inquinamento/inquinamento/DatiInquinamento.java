package it.gesan.inquinamento.inquinamento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import it.gesan.inquinamento.parsingclass.O3;
import it.gesan.inquinamento.parsingclass.Pm2_5;
import it.gesan.inquinamento.parsingclass.No2;
import it.gesan.inquinamento.parsingclass.Benzene;
import it.gesan.inquinamento.parsingclass.Co;
import it.gesan.inquinamento.parsingclass.So2;
import it.gesan.inquinamento.parsingclass.Pm10;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Fabrizio
 */
public class DatiInquinamento {
    private List<Benzene> benzene;
    private List<Co> co;
    private List<No2> no2;
    private List<O3> o3;
    private List<Pm10> pm10;
    private List<Pm2_5> pm2_5;
    private List<So2> so2;
    private final Luogo listaLuoghi;

    public DatiInquinamento(){
        benzene = new ArrayList<>();
        co = new ArrayList<>();
        o3 = new ArrayList<>();
        pm10 = new ArrayList<>();
        pm2_5 = new ArrayList<>();
        so2 = new ArrayList<>();
        no2 = new ArrayList<>();
        listaLuoghi = new Luogo();
    }
    
    public void populate(Document doc){
        Element body = doc.body();
        Elements tables = body.select("table");
        for(int i=0; i < tables.size(); i++)
        {
            Elements rows = tables.get(i).select("tr");
            for(int j=1;j < rows.size(); j++){
                Element row = rows.get(j);
                Elements tds = row.getElementsByTag("td");
                switch(i){
                    case 0:
                        Pm10 elemPm10 = new Pm10();
                        for(int k=0; k < tds.size(); k++){
                            Element td = tds.get(k);
                            switch(k){
                                case 0:
                                    elemPm10.setStazione(td.text());
                                    break;
                                case 1:
                                    elemPm10.setComune(td.text());
                                    break;
                                case 2:
                                    elemPm10.setProvincia(td.text());
                                    break;
                                case 3:
                                    elemPm10.setUm(td.text());
                                    break;
                                case 4:
                                    elemPm10.setMediaGiornaliera(td.text());
                                    break;
                            }
                        }
                        elemPm10.setLongitudine(listaLuoghi.getLongitudine(elemPm10.getStazione()));
                        elemPm10.setLatitudine(listaLuoghi.getLatitudine(elemPm10.getStazione()));
                        pm10.add(elemPm10);
                        break;
                    case 1:
                        Pm2_5 elemPm2_5 = new Pm2_5();
                        for(int k = 0;k < tds.size(); k++){
                            Element td = tds.get(k);
                            switch(k){
                                case 0:
                                    elemPm2_5.setStazione(td.text());
                                    break;
                                case 1:
                                    elemPm2_5.setComune(td.text());
                                    break;
                                case 2:
                                    elemPm2_5.setProvincia(td.text());
                                    break;
                                case 3:
                                    elemPm2_5.setUm(td.text());
                                    break;
                                case 4:
                                    elemPm2_5.setMediaGiornaliera(td.text());
                                    break;
                            }
                        }
                        elemPm2_5.setLongitudine(listaLuoghi.getLongitudine(elemPm2_5.getStazione()));
                        elemPm2_5.setLatitudine(listaLuoghi.getLatitudine(elemPm2_5.getStazione()));
                        pm2_5.add(elemPm2_5);
                        break;
                    case 2:
                        No2 elemNo2 = new No2();
                        for(int k = 0; k < tds.size(); k++){
                            Element td = tds.get(k);
                            switch(k){
                                case 0:
                                    elemNo2.setStazione(td.text());
                                    break;
                                case 1:
                                    elemNo2.setComune(td.text());
                                    break;
                                case 2:
                                    elemNo2.setProvincia(td.text());
                                    break;
                                case 3:
                                    elemNo2.setUm(td.text());
                                    break;
                                case 4:
                                    elemNo2.setMediaGiornaliera(td.text());
                                    break;
                                case 5:
                                    elemNo2.setMassimoOrario(td.text());
                                    break;
                            }
                        }
                        elemNo2.setLatitudine(listaLuoghi.getLatitudine(elemNo2.getStazione()));
                        elemNo2.setLongitudine(listaLuoghi.getLongitudine(elemNo2.getStazione()));
                        no2.add(elemNo2);
                        break;
                    case 3:
                        O3 elemO3 = new O3();
                        for(int k = 0; k < tds.size(); k++){
                            Element td = tds.get(k);
                            switch(k){
                                case 0:
                                    elemO3.setStazione(td.text());
                                    break;
                                case 1:
                                    elemO3.setComune(td.text());
                                    break;
                                case 2:
                                    elemO3.setProvincia(td.text());
                                    break;
                                case 3:
                                    elemO3.setUm(td.text());
                                    break;
                                case 4:
                                    elemO3.setMediaGiornaliera(td.text());
                                    break;
                                case 5:
                                    elemO3.setMassimoOrario(td.text());
                                    break;
                            }
                        }
                        elemO3.setLongitudine(listaLuoghi.getLongitudine(elemO3.getStazione()));
                        elemO3.setLatitudine(listaLuoghi.getLatitudine(elemO3.getStazione()));
                        o3.add(elemO3);
                        break;
                    case 4:
                        Co elemCo = new Co();
                        for(int k = 0; k < tds.size(); k++){
                            Element td = tds.get(k);
                            switch(k){
                                case 0:
                                    elemCo.setStazione(td.text());
                                    break;
                                case 1:
                                    elemCo.setComune(td.text());
                                    break;
                                case 2:
                                    elemCo.setProvincia(td.text());
                                    break;
                                case 3:
                                    elemCo.setUm(td.text());
                                    break;
                                case 4:
                                    elemCo.setMediaGiornaliera(td.text());
                                    break;
                                case 5:
                                    elemCo.setMassimoOrario(td.text());
                                    break;
                            }
                        }
                        elemCo.setLongitudine(listaLuoghi.getLongitudine(elemCo.getStazione()));
                        elemCo.setLatitudine(listaLuoghi.getLongitudine(elemCo.getStazione()));
                        co.add(elemCo);
                        break;
                    case 5:
                        So2 elemSo2 = new So2();
                        for(int k = 0; k < tds.size(); k++){
                            Element td = tds.get(k);
                            switch(k){
                                case 0:
                                    elemSo2.setStazione(td.text());
                                    break;
                                case 1:
                                    elemSo2.setComune(td.text());
                                    break;
                                case 2:
                                    elemSo2.setProvincia(td.text());
                                    break;
                                case 3:
                                    elemSo2.setUm(td.text());
                                    break;
                                case 4:
                                    elemSo2.setMediaGiornaliera(td.text());
                                    break;
                                case 5:
                                    elemSo2.setMassimoOrario(td.text());
                                    break;
                            }
                        }
                        elemSo2.setLongitudine(listaLuoghi.getLongitudine(elemSo2.getStazione()));
                        elemSo2.setLatitudine(listaLuoghi.getLatitudine(elemSo2.getStazione()));
                        so2.add(elemSo2);
                        break;
                    case 6:
                        Benzene elemBenzene = new Benzene();
                        for(int k = 0; k < tds.size(); k++){
                            Element td = tds.get(k);
                            switch(k){
                                case 0:
                                    elemBenzene.setStazione(td.text());
                                    break;
                                case 1:
                                    elemBenzene.setComune(td.text());
                                    break;
                                case 2:
                                    elemBenzene.setProvincia(td.text());
                                    break;
                                case 3:
                                    elemBenzene.setUm(td.text());
                                    break;
                                case 4:
                                    elemBenzene.setMediaGiornaliera(td.text());
                                    break;
                            }
                        }
                        elemBenzene.setLatitudine(listaLuoghi.getLatitudine(elemBenzene.getStazione()));
                        elemBenzene.setLongitudine(listaLuoghi.getLongitudine(elemBenzene.getStazione()));
                        benzene.add(elemBenzene);
                        break;
                }
            }
        }
    }
    
    
    /**
     * @return the benzene
     */
    public List<Benzene> getBenzene() {
        return benzene;
    }

    /**
     * @param benzene the benzene to set
     */
    public void setBenzene(List<Benzene> benzene) {
        this.benzene = benzene;
    }

    /**
     * @return the co
     */
    public List<Co> getCo() {
        return co;
    }

    /**
     * @param co the co to set
     */
    public void setCo(List<Co> co) {
        this.co = co;
    }

    /**
     * @return the no2
     */
    public List<No2> getNo2() {
        return no2;
    }

    /**
     * @param no2 the no2 to set
     */
    public void setNo2(List<No2> no2) {
        this.no2 = no2;
    }

    /**
     * @return the o3
     */
    public List<O3> getO3() {
        return o3;
    }

    /**
     * @param o3 the o3 to set
     */
    public void setO3(List<O3> o3) {
        this.o3 = o3;
    }

    /**
     * @return the pm10
     */
    public List<Pm10> getPm10() {
        return pm10;
    }

    /**
     * @param pm10 the pm10 to set
     */
    public void setPm10(List<Pm10> pm10) {
        this.pm10 = pm10;
    }

    /**
     * @return the pm2_5
     */
    public List<Pm2_5> getPm2_5() {
        return pm2_5;
    }

    /**
     * @param pm2_5 the pm2_5 to set
     */
    public void setPm2_5(List<Pm2_5> pm2_5) {
        this.pm2_5 = pm2_5;
    }

    /**
     * @return the so2
     */
    public List<So2> getSo2() {
        return so2;
    }

    /**
     * @param so2 the so2 to set
     */
    public void setSo2(List<So2> so2) {
        this.so2 = so2;
    }
    
    
}
