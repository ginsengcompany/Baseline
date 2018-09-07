/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.inquinamento.inquinamento;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fabrizio
 */
public class Luogo {
    private final Map<String, LatLong> luoghi;
    
    public Luogo(){
        luoghi = new HashMap<>();
        luoghi.put("Napoli NA01 Oss. Astronomico", new LatLong("41.417193","14.411627"));
        luoghi.put("Napoli NA02 Osp. Santobono", new LatLong("40.849368","14.231109"));
        luoghi.put("Napoli NA06 Museo Nazionale", new LatLong("40.854159","14.251332"));
        luoghi.put("Napoli NA07 Ferrovia", new LatLong("40.854161","14.271738"));
        luoghi.put("Napoli NA08 Osp.N.Pellegrini", new LatLong("40.872328","14.275463"));
        luoghi.put("Napoli NA09 Via Argine", new LatLong("40.863874","14.341356"));
        luoghi.put("Napoli Parco Virgiliano", new LatLong("40.798636","14.179681"));
        luoghi.put("Napoli via Epomeo", new LatLong("40.844933","14.20567"));
        luoghi.put("Acerra Zona Industriale", new LatLong("40.979613","14.401014"));
        luoghi.put("Pomigliano D’Arco Area ASI", new LatLong("40.920841","14.384944"));
        luoghi.put("Portici Parco Reggia", new LatLong("40.815877","14.349277"));
        luoghi.put("Pozzuoli Zona Villa Avellino", new LatLong("40.822926","14.122528"));
        luoghi.put("Volla via Filichito", new LatLong("40.886372","14.34999"));
        luoghi.put("S.Vitaliano Scuola Marconi", new LatLong("40.924329","14.481393"));
        luoghi.put("Caserta CE51 Ist.Manzoni", new LatLong("41.078687","14.338375"));
        luoghi.put("Caserta CE52 Sc. De Amicis", new LatLong("41.076934","14.331199"));
        luoghi.put("Maddaloni CE54 Sc. Settembrini", new LatLong("41.045916","14.378081"));
        luoghi.put("Casoria Scuola Palizzi", new LatLong("40.914637","14.298595"));
        luoghi.put("Torre Annunziata Sc. Pascoli", new LatLong("40.760542","14.438133"));
        luoghi.put("Aversa Sc. Cirillo", new LatLong("40.975496","14.211404"));
        luoghi.put("Acerra Scuola Caporale", new LatLong("40.940463","14.370191"));
        luoghi.put("Teverola via San Lorenzo", new LatLong("40.9909409","14.2027471"));
        luoghi.put("Marcianise Regi Lagni", new LatLong("40.994652","14.287231"));
        luoghi.put("Avellino AV41 Sc. V Circolo", new LatLong("40.92307","14.786743"));
        luoghi.put("Avellino Scuola Alighieri", new LatLong("40.91874","14.785454"));
        luoghi.put("Nocera Inferiore Sc. Solimena", new LatLong("40.740265","14.643457"));
        luoghi.put("Benevento Zona Industriale", new LatLong("41.14688","14.836134"));
        luoghi.put("Benevento BN32 Via Mustilli", new LatLong("41.131449","14.789388"));
        luoghi.put("Benevento Campo Sportivo", new LatLong("41.11566","14.77994"));
        luoghi.put("Battipaglia Parco Fiume", new LatLong("40.61107","14.975843"));
        luoghi.put("Polla Area Tritovagliatore", new LatLong("40.486909","15.527995"));
        luoghi.put("Cava dei Tirreni Stadio", new LatLong("40.710999","14.702449"));
        luoghi.put("Salerno SA22 Osp. Via Vernieri", new LatLong("40.682214","14.766295"));
        luoghi.put("Salerno SA23 Scuola Conti", new LatLong("40.695351","14.777522"));
        luoghi.put("Salerno Parco Mercatello", new LatLong("40.661425","14.804505"));
        luoghi.put("S. Felice a Cancello C. Scolast.", new LatLong("40.990452","14.423996"));
        luoghi.put("Solofra Zona Industriale", new LatLong("40.835482","14.824687"));
        luoghi.put("Sparanise Ferrovia", new LatLong("41.185222","14.09216"));
        luoghi.put("Pignataro M. Area Industriale", new LatLong("41.168491","14.150802"));
        luoghi.put("San Gregorio Matese Lago", new LatLong("41.417193","14.411627"));
        luoghi.put("Ottati Alburni", new LatLong("40.470596","15.298723"));
        luoghi.put("Ariano Irpino Stadio", new LatLong("41.156068","15.096684"));
    }
    
    public String getLongitudine(String luogo){
        return luoghi.get(luogo).getLongitudine();
    }
    
    public String getLatitudine(String luogo){
        return luoghi.get(luogo).getLatitudine();
    }
}
