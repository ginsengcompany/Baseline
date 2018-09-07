/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.api;

import it.gesan.module.utenti.presentation.PermessiPresentation;
import it.gesan.module.utenti.presentation.SezioniPresentation;
import it.gesan.module.utenti.presentation.VociMenuPresentation;
import it.gesan.module.utenti.vo.MenuVO;
import it.gesan.module.utenti.vo.PermessoVO;
import it.gesan.module.utenti.vo.SezioneVO;
import it.gesan.permessi.bo.VerificaPermessiBO;
import it.gesan.permessi.costants.Sezioni;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.interfaces.IEsitoBean;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author sistoandolfi
 */
@Path("configurazione")
public class ConfigurazioneResources {

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    ObjectMapper mapper = new ObjectMapper();
    
    @GET
    @Path("menu")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaMenu() throws JSONException, IOException {
        int status = 401;
        String filtri;
        String username = securityContext.getUserPrincipal().getName();

        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.MENU);
        EsitoBean esito = null;
        if(vpBO.getOggettiCodivisi() != null){
            if(vpBO.getOggettiCodivisi().equals("$ALL")){
                esito = VociMenuPresentation.getLista(new MenuVO());
                status = 200;
            }
            else{
                esito = VociMenuPresentation.getLista(vpBO.getOggettiCodivisi());
                status = 200;
            }
        }

        return Response.status(status).entity(esito).build();
    }    

    @GET
    @Path("sezioni")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaSezioni() throws JSONException, IOException {
        int status = 401;
        String filtri;
        String username = securityContext.getUserPrincipal().getName();

        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.SEZIONI);
        IEsitoBean esito = null;
        if(vpBO.getOggettiCodivisi() != null){
            if(vpBO.getOggettiCodivisi().equals("$ALL")){
                esito = SezioniPresentation.getLista(new SezioneVO());
                status = 200;
            }
            else{
                esito = SezioniPresentation.getLista(vpBO.getOggettiCodivisi());
                status = 200;
            }
        }

        return Response.status(status).entity(esito).build();
    }    

    @GET
    @Path("permessi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaPermessi() throws JSONException, IOException {
        int status = 200;
        IEsitoBean esito = PermessiPresentation.getLista(new PermessoVO());

        return Response.status(status).entity(esito).build();
    }    
}
