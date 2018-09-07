/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.api;

import it.gesan.module.portale.presentation.PortaleNewsPresentation;
import it.gesan.module.portale.presentation.PortalePaginePresentation;
import it.gesan.module.portale.vo.PortaleNewsVO;
import it.gesan.module.portale.vo.PortalePaginaVO;
import it.gesan.permessi.bo.VerificaPermessiBO;
import it.gesan.permessi.costants.Sezioni;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.constants.ReturnValues;
import java.io.IOException;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author sistoandolfi
 */
@Path("portale")
public class PortaleResources {
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Path("pagine")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLista() throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 401;
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.PORTALEPAGINE);

        if (vpBO.getOggettiCodivisi() != null) {
            if (vpBO.getOggettiCodivisi().equals("$ALL")) {
                esito = PortalePaginePresentation.getLista(null);
                status = 200;
            } else {
                esito = PortalePaginePresentation.getLista(vpBO.getOggettiCodivisi(), username);
                status = 200;
            }
        }
        return Response.status(status).entity(esito).build();
    }

    @GET
    @Path("pagine/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAzienda(@PathParam("id") String id) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 401;
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        

        return Response.status(200).entity(esito).build();
    }

    @PUT
    @Path("pagine/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") String id, PortalePaginaVO pagina) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 400;
        EsitoBean esito = PortalePaginePresentation.getPortalePaginaById(id);
        
        
        
        if (esito.getReturnValue() == ReturnValues.FOUND) {
            VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.GRUPPI);
            PortalePaginaVO ppVO = (PortalePaginaVO)esito.getObject();
            
            if (vpBO.verificaPermessiModifica(ppVO.getId(), ppVO.getProprietario())) {
                pagina.setCreateDate(ppVO.getCreateDate());
                pagina.setCreateUser(ppVO.getCreateUser());
                pagina.setPrimaryKey(id);
                esito = PortalePaginePresentation.salva(pagina);

                if (esito.getReturnValue() == ReturnValues.SAVED) {
                    status = 200;
                }                
            }
            else{
                status = 401;
                esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");            
            }
        }

        return Response.status(status).entity(esito).build();
    } 

    @GET
    @Path("news")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaNews() throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 401;
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.PORTALENEWS);

        if (vpBO.getOggettiCodivisi() != null) {
            if (vpBO.getOggettiCodivisi().equals("$ALL")) {
                esito = PortaleNewsPresentation.getLista(null);
                status = 200;
            } else {
                esito = PortaleNewsPresentation.getLista(vpBO.getOggettiCodivisi(), username);
                status = 200;
            }
        }
        return Response.status(status).entity(esito).build();
    }   

    @POST
    @Path("news")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PortaleNewsVO news) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 401;
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.PORTALENEWS);

        if (vpBO.verificaPermessiInserimento()) {
            status = 400;
            news.setTipo("news");
            news.setPrimaryKey(null);
            news.setUpdateDate(new Date());
            news.setUpdateUser(username);
            news.setCreateDate(new Date());
            news.setCreateUser(username);
            news.setProprietario(username);
            esito = PortaleNewsPresentation.salva(news);

            if (esito.getReturnValue() == ReturnValues.SAVED) {
                status = 200;
            }
        }

        return Response.status(200).entity(esito).build();
    }    
}
