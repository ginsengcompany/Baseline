/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.api;


import it.gesan.module.utenti.bo.UtentiBO;
import it.gesan.module.utenti.presentation.GruppiPresentation;
import it.gesan.module.utenti.presentation.UtentiPresentation;
import it.gesan.module.utenti.presentation.VociMenuPresentation;
import it.gesan.module.utenti.vo.GruppoVO;
import it.gesan.module.utenti.vo.MenuVO;
import it.gesan.module.utenti.vo.UtenteVO;
import it.gesan.permessi.bo.VerificaPermessiBO;
import it.gesan.permessi.costants.Sezioni;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.constants.ReturnValues;
import it.gesan.rdb.interfaces.IEsitoBean;
import it.gesan.utility.DigestUtils;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("users")
public class UsersResources {

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    ObjectMapper mapper = new ObjectMapper();



    @PUT
    @Path("attiva/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response attiva(@PathParam("id") String id) throws JSONException, IOException {
        int status = 400;
        String username = securityContext.getUserPrincipal().getName();

        EsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        //JSONObject jsonUtente = new JSONObject();
        //UtenteVO utenteVO = (UtenteVO)esito.getObject();

        if (esito.getReturnValue() == ReturnValues.FOUND) {
            UtenteVO uVO = new UtenteVO();
            uVO.setPrimaryKey(id);
            uVO.setUpdateDate(new Date());
            uVO.setUpdateUser(username);
            uVO.setAttivo(true);
            esito = UtentiPresentation.aggionaStato(uVO);
            if (esito.getReturnValue() == ReturnValues.SAVED) {
                esito.setEsito(true);
                status = 200;
            }
        }
        return Response.status(status).entity(esito).build();
    }

    @PUT
    @Path("disattiva/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response disattiva(@PathParam("id") String id) throws JSONException, IOException {
        int status = 400;
        String username = securityContext.getUserPrincipal().getName();

        EsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        //JSONObject jsonUtente = new JSONObject();
        //UtenteVO utenteVO = (UtenteVO)esito.getObject();

        if (esito.getReturnValue() == ReturnValues.FOUND) {
            UtenteVO uVO = new UtenteVO();
            uVO.setPrimaryKey(id);
            uVO.setUpdateDate(new Date());
            uVO.setUpdateUser(username);
            uVO.setAttivo(false);
            esito = UtentiPresentation.aggionaStato(uVO);
            if (esito.getReturnValue() == ReturnValues.SAVED) {
                esito.setEsito(true);
                status = 200;
            }
        }
        return Response.status(status).entity(esito).build();
    }

    @GET
    @Path("permessi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPermessi(@QueryParam("tipo") String tipo, @QueryParam("sezione") String sezione, @QueryParam("id") String id) throws JSONException, IOException {
        String usernameUtenteLoggato = securityContext.getUserPrincipal().getName();
        int status = 401;
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");

        if (tipo == null || (!tipo.equals("gruppo") && !tipo.equals("utente"))) {
            esito.setMessaggio("Manca il tipo, puo essere: 'gruppo' o 'utente' ");
            status = 400;
        } else if (sezione == null) {
            esito.setMessaggio("Manca la sezione");
            status = 400;
        } else if (id == null) {
            esito.setMessaggio("Manca l'id dell'utente o del gruppo per il quale si vuole leggere i permessi");
            status = 400;
        } else {
            VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", usernameUtenteLoggato, sezione);
            if (vpBO.verificaPermessiLettura(id, "")) {
                status = 200;
                VerificaPermessiBO vpBOUtente = new VerificaPermessiBO(tipo, id, sezione);
                esito.setEsito(true);
                esito.setMessaggio("OK");
                esito.setObject(vpBOUtente.getPermessiUtente());
            }
        }

        return Response.status(status).entity(esito).build();
    }
    
    /*METODI CORRETTI*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaUtenti() throws JSONException, IOException {
        int status = 401;
        String username = securityContext.getUserPrincipal().getName();

        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.UTENTI);
        IEsitoBean esito = null;
        if (vpBO.getOggettiCodivisi() != null) {
            if (vpBO.getOggettiCodivisi().equals("$ALL")) {
                esito = UtentiPresentation.getLista(null);
                status = 200;
            } else {
                esito = UtentiPresentation.getLista(vpBO.getOggettiCodivisi(), username);
                status = 200;
            }
        }

        return Response.status(status).entity(esito).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUtente(UtenteVO utenteVO) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 401;
        IEsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.UTENTI);

       
        
        if (vpBO.verificaPermessiInserimento()) {
            status = 400;
            esito = UtentiBO.validaUtente(utenteVO);
            if(esito.isEsito()){
                utenteVO.setPrimaryKey(null);
                utenteVO.setUpdateDate(new Date());
                utenteVO.setUpdateUser(username);
                utenteVO.setCreateDate(new Date());
                utenteVO.setCreateUser(username);
                utenteVO.setProprietario(username);
                esito = UtentiPresentation.salva(utenteVO);

                if (esito.getReturnValue() == ReturnValues.SAVED) {
                    status = 200;
                }                
            }
        }

        return Response.status(status).entity(esito).build();
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putUtenti(@PathParam("id") String id, UtenteVO utenteVO) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 400;
        //EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        EsitoBean esito = UtentiPresentation.getUtenteById(id);

        if (esito.getReturnValue() == ReturnValues.FOUND) {
            VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.UTENTI);
            UtenteVO uVO = (UtenteVO) esito.getObject();

            if (vpBO.verificaPermessiModifica(id, uVO.getProprietario())) {
                status = 401;
                if (utenteVO.getPassword().trim().equals("")) {
                    utenteVO.setPassword(uVO.getPassword());
                }
                else{
                    utenteVO.setPassword(DigestUtils.sha1Hex(utenteVO.getPassword()));
                }
                status = 400;
                utenteVO.setPrimaryKey(username);
                utenteVO.setUpdateDate(new Date());
                utenteVO.setUpdateUser(username);

                esito = UtentiPresentation.salva(utenteVO);

                if (esito.getReturnValue() == ReturnValues.SAVED) {
                    status = 200;
                }
            } else {
                status = 401;
                esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
            }

        }

        return Response.status(status).entity(esito).build();
    }

    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUtente(@PathParam("username") String username) throws JSONException, IOException {
        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        JSONObject jsonUtente = new JSONObject();
        UtenteVO utenteVO = new UtenteVO();
        if (esito.getReturnValue() == ReturnValues.FOUND) {
            utenteVO = (UtenteVO) esito.getObject();
            jsonUtente = new JSONObject(mapper.writeValueAsString(utenteVO));
            VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.UTENTI);
            if (vpBO.isSuperUser()) {
                esito = VociMenuPresentation.getLista(new MenuVO());
                List<MenuVO> listaVociMenu = (List<MenuVO>) esito.getObject();
                jsonUtente.put("menu", new JSONArray(mapper.writeValueAsString(listaVociMenu)));
            } else {
                jsonUtente.put("menu", new JSONArray(utenteVO.getMenu()));
            }
        }

        String utente = jsonUtente.toString();

        return Response.status(200).entity(utente).build();
    }

    /*GRUPPI*/
    @GET
    @Path("gruppi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaGruppi() throws JSONException, IOException {
        int status = 401;
        String username = securityContext.getUserPrincipal().getName();
        String filtri;

        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.GRUPPI);
        IEsitoBean esito = null;
        if (vpBO.getOggettiCodivisi() != null) {
            if (vpBO.getOggettiCodivisi().equals("$ALL")) {
                esito = GruppiPresentation.getLista(null);
                status = 200;
            } else {
                esito = GruppiPresentation.getLista(vpBO.getOggettiCodivisi(), username);
                status = 200;
            }
        }

        return Response.status(status).entity(esito).build();
    }

    @POST
    @Path("gruppi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postGruppo(GruppoVO gruppo) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 401;
        IEsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.GRUPPI);

        if (vpBO.verificaPermessiInserimento()) {
            status = 400;
            gruppo.setPrimaryKey(null);
            gruppo.setUpdateDate(new Date());
            gruppo.setUpdateUser(username);
            gruppo.setCreateDate(new Date());
            gruppo.setCreateUser(username);
            gruppo.setProprietario(username);
            esito = GruppiPresentation.salva(gruppo);

            if (esito.getReturnValue() == ReturnValues.SAVED) {
                status = 200;
            }
        }

        return Response.status(status).entity(esito).build();
    }

    @PUT
    @Path("gruppi/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putGruppo(@PathParam("id") String id, GruppoVO gruppo) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 400;
        EsitoBean esito = GruppiPresentation.getGruppoById(id);

        if (esito.getReturnValue() == ReturnValues.FOUND) {
            VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.GRUPPI);
            GruppoVO gVO = (GruppoVO) esito.getObject();

            if (vpBO.verificaPermessiModifica(gruppo.getId(), gVO.getProprietario())) {
                status = 400;
                gruppo = UtentiBO.formattaMenu(gruppo);
                gruppo.setPrimaryKey(username);
                gruppo.setUpdateDate(new Date());
                gruppo.setUpdateUser(username);

                esito = GruppiPresentation.salva(gruppo);

                if (esito.getReturnValue() == ReturnValues.SAVED) {
                    status = 200;
                }
            } else {
                status = 401;
                esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
            }

        }

        return Response.status(status).entity(esito).build();
    }
}
