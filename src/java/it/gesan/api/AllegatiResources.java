/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.api;

import it.gesan.module.allegati.presentation.AllegatiPresentation;
import it.gesan.module.allegati.vo.AllegatoVO;
import it.gesan.permessi.bo.VerificaPermessiBO;
import it.gesan.permessi.costants.Permessi;
import it.gesan.permessi.costants.Sezioni;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.constants.ReturnValues;
import it.gesan.utility.StandardSetting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author sistoandolfi
 */
@Path("allegati")
public class AllegatiResources {

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    ObjectMapper mapper = new ObjectMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLista(@QueryParam("idRisorsa") String idRisorsa, @QueryParam("tipoRisorsa") String tipoRisorsa) throws JSONException, IOException {
        int status = 200;
        String filtri;
        String username = securityContext.getUserPrincipal().getName();
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");

        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.ALLEGATI);

        if (vpBO.getOggettiCodivisi() != null) {
            if (vpBO.getOggettiCodivisi().equals("$ALL")) {
                esito = AllegatiPresentation.getLista(idRisorsa, tipoRisorsa);
                status = 200;
            } else {
                esito = AllegatiPresentation.getLista(idRisorsa, tipoRisorsa);
                status = 200;
            }
        }

        return Response.status(status).entity(esito).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(AllegatoVO allegato) {
        int status = 401;
        String username = securityContext.getUserPrincipal().getName();
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.ALLEGATI);

        if (vpBO.verificaPermessiInserimento()) {
            status = 400;
            allegato.setId(null);
            StandardSetting.setDefaultDataInsert(allegato, username);

            esito = AllegatiPresentation.salva(allegato);

            if (esito.getReturnValue() == ReturnValues.SAVED) {
                status = 200;
            }
        }
        return Response.status(status).entity(esito).build();
    }

    @GET
    @Path("download/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response download(@PathParam("id") String id) throws IOException, JSONException {

        int status = 401;
        String username = securityContext.getUserPrincipal().getName();
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.ALLEGATI);
        
        if(vpBO.verificaPermesso(Permessi.DOWNLOAD, id)){
            esito = AllegatiPresentation.getAllegatoById(id);
            if (esito.getReturnValue() == ReturnValues.FOUND) {
                AllegatoVO allegato = (AllegatoVO) esito.getObject();
                String nomeFile = allegato.getDescrizioneTipo() + "." + allegato.getEstensione();
                byte[] file = Base64.decodeBase64(allegato.getFile());
                ByteArrayOutputStream bos = new ByteArrayOutputStream(file.length);
                bos.write(file, 0, file.length);
                ResponseBuilder response = Response.ok(bos.toByteArray());
                response.header("Content-Disposition", "attachment; filename=" + nomeFile);
                return response.build();
            }
            else{
                status = 400;
            }            
        }

        return Response.status(status).type(MediaType.APPLICATION_JSON).entity(esito).build();
    }

    @GET
    @Path("verificapermessidownload/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response verificaPermessiDownload(@PathParam("id") String id) throws IOException, JSONException {

        int status = 401;
        String username = securityContext.getUserPrincipal().getName();
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.ALLEGATI);
        
        if(vpBO.verificaPermesso(Permessi.DOWNLOAD, id)){
            status = 200;           
        }

        return Response.status(status).type(MediaType.APPLICATION_JSON).entity(esito).build();
    }
}
