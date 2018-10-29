/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.api;

import it.gesan.utility.SendMail;
import it.gesan.module.medici.model.dao.beans.MedicoBean;
import it.gesan.module.medici.presentation.MediciPresentation;
import it.gesan.module.medici.presentation.SpecializzazioniMedicoPresentation;
import it.gesan.module.medici.vo.MedicoVO;
import it.gesan.module.sessioni.presentation.SessioniPresentation;
import it.gesan.module.sessioni.vo.SessioneVO;
import it.gesan.module.strutture.presentation.StrutturePresentation;
import it.gesan.module.strutture.vo.StrutturaVO;
import it.gesan.module.utenti.presentation.UtentiPresentation;
import it.gesan.module.utenti.vo.UtenteVO;
import it.gesan.permessi.bo.VerificaPermessiBO;
import it.gesan.permessi.costants.Sezioni;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.constants.ReturnValues;
import it.gesan.rdb.interfaces.IEsitoBean;
import it.gesan.utility.StandardSetting;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author sistoandolfi
 */
@Path("medici")
public class MediciResources {

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    ObjectMapper mapper = new ObjectMapper();

    @GET
    @Path("specializzazioni")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaSpecializzazioni() throws JSONException, IOException {
        int status = 200;
        String username = securityContext.getUserPrincipal().getName();
        IEsitoBean esito = null;
        /*VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.MEDICI);
        
         if(vpBO.getOggettiCodivisi() != null){
         if(vpBO.getOggettiCodivisi().equals("$ALL")){
                
         status = 200;
         }
         else{
         esito = MediciPresentation.getLista(vpBO.getOggettiCodivisi(), username);
         status = 200;
         }
         } */
        esito = SpecializzazioniMedicoPresentation.getLista(null);
        return Response.status(status).entity(esito).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLista() throws JSONException, IOException {
        int status = 401;
        String username = securityContext.getUserPrincipal().getName();

        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.MEDICI);
        IEsitoBean esito = null;
        if (vpBO.getOggettiCodivisi() != null) {
            if (vpBO.getOggettiCodivisi().equals("$ALL")) {
                esito = MediciPresentation.getLista();
                status = 200;
            } else {
                esito = MediciPresentation.getLista(vpBO.getOggettiCodivisi(), username);
                status = 200;
            }
        }

        return Response.status(status).entity(esito).build();
    }

    @GET
    @Path("registrati")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaRegistrati() throws JSONException, IOException {
        int status = 401;
        String username = securityContext.getUserPrincipal().getName();

        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.MEDICI);
        IEsitoBean esito = null;
        if (vpBO.getOggettiCodivisi() != null) {
            if (vpBO.getOggettiCodivisi().equals("$ALL")) {
                esito = MediciPresentation.getListaRegistrati(username);
                status = 200;
            } else {
                esito = MediciPresentation.getLista(vpBO.getOggettiCodivisi(), username);
                status = 200;
            }
        }

        return Response.status(status).entity(esito).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(MedicoBean medicoBean) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 401;
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.MEDICI);

        if (vpBO.verificaPermessiInserimento()) {
            esito = StrutturePresentation.getStrutturaByCodiceStruttura(username);
            if (esito.getReturnValue() == ReturnValues.FOUND) {
                StrutturaVO sVO = (StrutturaVO) esito.getObject();
                status = 400;
                StandardSetting.setDefaultDataInsert(medicoBean.getAnagrafica(), username);
                StandardSetting.setDefaultDataInsert(medicoBean.getMedico(), username);
                medicoBean.setIdStruttura(sVO.getId());
                esito = MediciPresentation.salva(medicoBean);

                if (esito.getReturnValue() == ReturnValues.SAVED) {
                    status = 200;
                }
            } else {
                esito.setMessaggio("Solo gli utenti di Struttura possono inserire Personale Medico");
            }

        }

        return Response.status(status).entity(esito).build();
    }

    @POST
    @Path("invito")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postInvioInvito(MedicoBean medicoBean) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 200;
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        esito = StrutturePresentation.getStrutturaByCodiceStruttura(username);
        StrutturaVO sVO = (StrutturaVO)esito.getObject();
        String[] indirizziDestinazione = new String[]{medicoBean.getEmail()};
        SendMail sm = new SendMail(indirizziDestinazione);
        sm.setSubject("PediaNetCampania Invito Alla Registrazione");
        sm.setMessaggio("Salve ," + "\n\n la struttura " + sVO.getDenominazione() + " è lieta di invitarla alla registrazione sul portale ");
        sm.send();

        return Response.status(status).entity(esito).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(@PathParam("id") String id, MedicoBean medicoBean) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 401;
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.MEDICI);

        if (vpBO.verificaPermessiModifica(id, username)) {
            esito = MediciPresentation.getMedicoById(id);
            if (esito.getReturnValue() == ReturnValues.FOUND) {
                MedicoBean mb = (MedicoBean) esito.getObject();

                status = 400;
                StandardSetting.setDefaultDataInsert(medicoBean.getAnagrafica(), username);
                StandardSetting.setDefaultDataInsert(medicoBean.getMedico(), username);

                mb.getAnagrafica().setCreateDate(mb.getAnagrafica().getCreateDate());
                mb.getAnagrafica().setCreateUser(mb.getAnagrafica().getCreateUser());
                mb.getMedico().setCreateDate(mb.getMedico().getCreateDate());
                mb.getMedico().setCreateUser(mb.getMedico().getCreateUser());
                mb.getMedico().setProprietario(mb.getMedico().getProprietario());
                
                mb.setPrimaryKey(id);

                medicoBean.setIdStruttura(mb.getIdStruttura());
                esito = MediciPresentation.salva(medicoBean);

                if (esito.getReturnValue() == ReturnValues.SAVED) {
                    status = 200;
                }
            } else {
                esito.setMessaggio("Solo gli utenti di Struttura possono inserire Personale Medico");
            }

        }

        return Response.status(status).entity(esito).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        
        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        //JSONObject jsonUtente = new JSONObject();
        
        if(esito.getReturnValue() == ReturnValues.FOUND){
            UtenteVO utenteVO = (UtenteVO)esito.getObject();
            MedicoVO sVO = new MedicoVO();
            
            sVO.setId(id);
            
            esito = MediciPresentation.delete(sVO);

            if(esito.getReturnValue() == ReturnValues.SAVED){
                esito.setEsito(true);
            }            
            //jsonUtente = new JSONObject(mapper.writeValueAsString(utenteVO));
        }
        //String utente = jsonUtente.toString();


        return Response.status(200).entity(esito).build();
    } 
}
