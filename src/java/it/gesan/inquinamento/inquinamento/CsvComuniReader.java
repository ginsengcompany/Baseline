/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.inquinamento.inquinamento;

import it.gesan.inquinamento.parsingclass.Comune;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aldo
 */
public class CsvComuniReader {
    private final String csvFile = "http://localhost:8081/Baseline/dashboard/static/csv/comuni.CSV";
    private String line = "";
    private final String csvSplit = ";";
    private List<Comune> comuni;
    
    public CsvComuniReader() {
        parseCsv();
    }
    
    private void parseCsv(){
        comuni = new ArrayList<>();
        try
        {
            URL csv = new URL(this.csvFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(csv.openStream()));
            int i=0;
            while((line = br.readLine()) != null){
                if(i > 0){
                    String[] lineRead = line.split(csvSplit);
                    comuni.add(new Comune(lineRead[0],lineRead[1].trim(),lineRead[2].trim(),Integer.parseInt(lineRead[3])));
                }
                i++;
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public List<Comune> getComuni(){
        return comuni;
    }
}
