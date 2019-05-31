/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.api;


import it.gesan.rdb.beans.EsitoBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Base64;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;


/**
 * REST Web Service
 *
 * @author Antonio Biondillo
 */
@Path("distretti")
public class Distretti {

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    ObjectMapper mapper = new ObjectMapper();
    
    @GET
    @Path("comune/findByCodiceIstat")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRegione(@QueryParam("codiceIstatComune") String codice) throws JSONException, IOException {
        String usernameUtenteLoggato = securityContext.getUserPrincipal().getName();
        int status = 401;
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        
        URL urlForGetRequest = new URL("http://10.10.13.67:8080/distretti-3.0/rest/comune/findByCodiceIstat?codiceIstatComune="+codice);

        String readLine = null;

        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

        conection.setRequestMethod("GET");

        int responseCode = conection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {

            BufferedReader in = new BufferedReader(

                new InputStreamReader(conection.getInputStream()));

            StringBuffer response = new StringBuffer();

            while ((readLine = in .readLine()) != null) {

                response.append(readLine);

            } in .close();

            status = 200;
            esito.setEsito(true);
            esito.setMessaggio("OK");
            esito.setObject(response.toString());

            //GetAndPost.POSTRequest(response.toString());

        } 
        else {

            esito.setMessaggio("Errore nella ricerca");
            status = 400;

        }

        return Response.status(status).entity(esito).build();
    }
    
    @GET
    @Path("clima/img")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getImmagineClima(@QueryParam("namePng") String regione) throws JSONException, IOException {
        String usernameUtenteLoggato = securityContext.getUserPrincipal().getName();
        int status = 401;
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        
        URL urlForGetRequest = new URL("https://immagini.ilmeteo.it/cartine/aria/"+regione+"-aria-m.png");

        String readLine = null;

        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

        conection.setRequestMethod("GET");

        int responseCode = conection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {

            BufferedReader in = new BufferedReader(

                new InputStreamReader(conection.getInputStream()));

            StringBuffer response = new StringBuffer();

            while ((readLine = in .readLine()) != null) {

                response.append(readLine);

            } in .close();
            
            byte[] imageBytes = IOUtils.toByteArray(new URL("https://immagini.ilmeteo.it/cartine/aria/"+regione+"-aria-m.png"));
            String base64 = Base64.getEncoder().encodeToString(imageBytes);

            status = 200;
            esito.setEsito(true);
            esito.setMessaggio("OK");

            esito.setObject(base64);

            //GetAndPost.POSTRequest(response.toString());

        } 
        else {

            esito.setMessaggio("Errore nella ricerca");
            status = 400;

        }

        return Response.status(status).entity(esito).build();
    }
    
    
}
