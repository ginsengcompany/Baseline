/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.api;

import it.gesan.beans.PazienteBean;
import it.gesan.module.allegati.presentation.AllegatiPresentation;
import it.gesan.module.allegati.vo.AllegatoVO;
import it.gesan.module.anagrafica.presentation.AnagraficaPresentation;
import it.gesan.module.anagrafica.vo.AnagraficaVO;
import it.gesan.module.anagraficatipo.presentation.AnagraficaTipoPresentation;
import it.gesan.module.anagraficatipo.vo.AnagraficaTipoVO;
import it.gesan.module.servizi.presentation.ServiziPresentation;
import it.gesan.module.servizi.vo.ServizioVO;
import it.gesan.module.utenti.presentation.CondivisioniPresentation;
import it.gesan.module.utenti.presentation.UtentiPresentation;
import it.gesan.module.utenti.vo.CondivisioneVO;
import it.gesan.module.utenti.vo.UtenteVO;
import it.gesan.permessi.bo.VerificaPermessiBO;
import it.gesan.permessi.costants.Sezioni;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.constants.ReturnValues;
import it.gesan.rdb.interfaces.IEsitoBean;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Antonio Biondillo
 */
@Path("anagrafica")
public class AnagraficaResources {

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    ObjectMapper mapper = new ObjectMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLista() throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();

        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);

        if (esito.getReturnValue() == ReturnValues.FOUND) {
            UtenteVO utenteVO = (UtenteVO) esito.getObject();
        }
        esito = AnagraficaPresentation.getLista(null);

        return Response.status(200).entity(esito).build();
    }

    @GET
    @Path("pazienti")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaPazienti() throws JSONException, IOException {
        int status = 401;
        String username = securityContext.getUserPrincipal().getName();
        String filtri;

        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.PAZIENTI);
        IEsitoBean esito = null;
        if (vpBO.getOggettiCodivisi() != null) {
            if (vpBO.getOggettiCodivisi().equals("$ALL")) {
                esito = AnagraficaPresentation.getLista(null);
                status = 200;
            } else {
                esito = AnagraficaPresentation.getLista(vpBO.getOggettiCodivisi(), username);
                status = 200;
            }
        }

        return Response.status(status).entity(esito).build();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("{id}")
//    public Response getDettaglio(@PathParam("id") String id) throws JSONException, IOException {
//        String username = securityContext.getUserPrincipal().getName();
//
//        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
//
//        if (esito.getReturnValue() == ReturnValues.FOUND) {
//            UtenteVO utenteVO = (UtenteVO) esito.getObject();
//        }
//        esito = PersonalePresentation.getPersonaleById(id);
//
//        return Response.status(200).entity(esito).build();
//    }
    @POST
    @Path("pazienti")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PazienteBean pazienteBean) throws JSONException, IOException {
        int status = 400;
        String username = securityContext.getUserPrincipal().getName();

        EsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        JSONObject jsonUtente = new JSONObject();

        if (esito.getReturnValue() == ReturnValues.FOUND) {
            UtenteVO utenteVO = (UtenteVO) esito.getObject();
            jsonUtente = new JSONObject(mapper.writeValueAsString(utenteVO));
        }
        String utente = jsonUtente.toString();

        AnagraficaVO anagraficaPaziente = new AnagraficaVO();

        String cognome = (pazienteBean.getCognome() == null) ? "" : pazienteBean.getCognome();
        String nome = (pazienteBean.getNome() == null) ? "" : pazienteBean.getNome();
        Date dataNascita = pazienteBean.getDataNascita();

        String codiceFiscaleMadre = pazienteBean.getCodiceFiscaleMadre();
        String codiceFiscalePadre = (pazienteBean.getCodiceFiscalePadre() == null) ? "" : pazienteBean.getCodiceFiscalePadre();

        if (cognome.trim().equals("") || nome.trim().equals("") || dataNascita == null) {
            esito.setEsito(false);
            esito.setMessaggio("I campi Cognome, Nome e Data di Nascita del Paziente sono Obbligatori");
        } else if (codiceFiscaleMadre.trim().equals("") && codiceFiscalePadre.trim().equals("")) {
            esito.setEsito(false);
            esito.setMessaggio("Iserire il Codice Fiscale di uno dei Genitori");
        } else {
            String codiceFiscale = pazienteBean.getCodiceFiscale();
            String provinciaNascita = pazienteBean.getProvinciaNascita();
            String localitaNascita = pazienteBean.getLuogoNascita();

            anagraficaPaziente.setCodiceFiscale(codiceFiscale);
            anagraficaPaziente.setCognome(cognome);
            anagraficaPaziente.setNome(nome);
            anagraficaPaziente.setProvinciaNascita(provinciaNascita);
            anagraficaPaziente.setLocalitaNascita(localitaNascita);
            anagraficaPaziente.setDataNascita(dataNascita);
            anagraficaPaziente.setPrimaryKey(null);
            anagraficaPaziente.setCreateUser(username);
            anagraficaPaziente.setCreateDate(new Date());
            anagraficaPaziente.setUpdateUser(username);
            anagraficaPaziente.setUpdateDate(new Date());
            anagraficaPaziente.setProprietario(username);

            esito = AnagraficaPresentation.salva(anagraficaPaziente);

            anagraficaPaziente = (AnagraficaVO) esito.getObject();
            AnagraficaTipoVO anagraficaTipoPaziente = new AnagraficaTipoVO();
            anagraficaTipoPaziente.setIdAnagrafica(anagraficaPaziente.getId());
            anagraficaTipoPaziente.setIdTipoAnagrafica("3");
            anagraficaTipoPaziente.setCreateDate(new Date());
            anagraficaTipoPaziente.setUpdateDate(new Date());
            anagraficaTipoPaziente.setCreateUser(username);
            anagraficaTipoPaziente.setUpdateUser(username);
            //anagraficaTipoPaziente.setProprietario(username);

            esito = AnagraficaTipoPresentation.salva(anagraficaTipoPaziente);

            if (esito.getReturnValue() == ReturnValues.SAVED) {
                AnagraficaVO anagraficaMadre = new AnagraficaVO();

                String cognomeMadre = pazienteBean.getCognomeMadre();
                Date dataNascitaMadre = pazienteBean.getDataNascitaMadre();
                String nomeMadre = pazienteBean.getNomeMadre();
                String provinciaNascitaMadre = pazienteBean.getProvinciaNascitaMadre();
                String localitaNascitaMadre = pazienteBean.getProvinciaNascitaMadre();

                if (!(cognomeMadre.trim().equals("") && nomeMadre.trim().equals("") && codiceFiscaleMadre.trim().equals("") && dataNascitaMadre != null)) {
                    anagraficaMadre.setCodiceFiscale(codiceFiscaleMadre);
                    anagraficaMadre.setCognome(cognomeMadre);
                    anagraficaMadre.setNome(nomeMadre);
                    anagraficaMadre.setProvinciaNascita(provinciaNascitaMadre);
                    anagraficaMadre.setLocalitaNascita(localitaNascitaMadre);
                    anagraficaMadre.setDataNascita(dataNascitaMadre);
                    anagraficaMadre.setPrimaryKey(null);
                    anagraficaMadre.setCreateUser(username);
                    anagraficaMadre.setCreateDate(new Date());
                    anagraficaMadre.setUpdateUser(username);
                    anagraficaMadre.setUpdateDate(new Date());
                    anagraficaMadre.setProprietario(username);
                    esito = AnagraficaPresentation.salva(anagraficaMadre);

                    anagraficaMadre = (AnagraficaVO) esito.getObject();
                    AnagraficaTipoVO anagraficaTipoMadre = new AnagraficaTipoVO();
                    anagraficaTipoMadre.setIdAnagrafica(anagraficaMadre.getId());
                    anagraficaTipoMadre.setIdTipoAnagrafica("1");
                    anagraficaTipoMadre.setCreateDate(new Date());
                    anagraficaTipoMadre.setUpdateDate(new Date());
                    anagraficaTipoMadre.setCreateUser(username);
                    anagraficaTipoMadre.setUpdateUser(username);

                    esito = AnagraficaTipoPresentation.salva(anagraficaTipoMadre);
                }

                AnagraficaVO anagraficaPadre = new AnagraficaVO();

                String cognomePadre = (pazienteBean.getCognomePadre() == null) ? "" : pazienteBean.getCognomePadre();
                Date dataNascitaPadre = pazienteBean.getDataNascitaPadre();
                String nomePadre = (pazienteBean.getNomePadre() == null) ? "" : pazienteBean.getNomePadre();

                String provinciaNascitaPadre = pazienteBean.getProvinciaNascitaPadre();
                String localitaNascitaPadre = pazienteBean.getProvinciaNascitaPadre();

                if (!(cognomePadre.trim().equals("") && nomePadre.trim().equals("") && codiceFiscalePadre.trim().equals("") && dataNascitaPadre != null)) {
                    anagraficaPadre.setCodiceFiscale(codiceFiscalePadre);
                    anagraficaPadre.setCognome(cognomePadre);
                    anagraficaPadre.setNome(nomePadre);
                    anagraficaPadre.setProvinciaNascita(provinciaNascitaPadre);
                    anagraficaPadre.setLocalitaNascita(localitaNascitaPadre);
                    anagraficaPadre.setDataNascita(dataNascitaPadre);
                    anagraficaPadre.setPrimaryKey(null);
                    anagraficaPadre.setCreateUser(username);
                    anagraficaPadre.setCreateDate(new Date());
                    anagraficaPadre.setUpdateUser(username);
                    anagraficaPadre.setUpdateDate(new Date());
                    anagraficaPadre.setProprietario(username);
                    esito = AnagraficaPresentation.salva(anagraficaPadre);

                    anagraficaPadre = (AnagraficaVO) esito.getObject();
                    AnagraficaTipoVO anagraficaTipoPadre = new AnagraficaTipoVO();
                    anagraficaTipoPadre.setIdAnagrafica(anagraficaPadre.getId());
                    anagraficaTipoPadre.setIdTipoAnagrafica("2");
                    anagraficaTipoPadre.setCreateDate(new Date());
                    anagraficaTipoPadre.setUpdateDate(new Date());
                    anagraficaTipoPadre.setCreateUser(username);
                    anagraficaTipoPadre.setUpdateUser(username);

                    esito = AnagraficaTipoPresentation.salva(anagraficaTipoPadre);
                }

                esito = this.salvaAllegati(pazienteBean.getDocumenti(), anagraficaPaziente);

                if (esito.getReturnValue() == ReturnValues.SAVED) {
                    esito.setEsito(true);
                    status = 200;
                }

            }
        }

        return Response.status(status).entity(esito).build();
    }
    
    @PUT
    @Path("modifica/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salva(@PathParam("id") String id, AnagraficaVO aVO) throws JSONException, IOException {
        int status = 400;
        String username = securityContext.getUserPrincipal().getName();

        EsitoBean esito = UtentiPresentation.getUtenteByUsername(username);

        if (esito.getReturnValue() == ReturnValues.FOUND) {
            aVO.setPrimaryKey(id);
            aVO.setUpdateDate(new Date());
            aVO.setUpdateUser(username);
            aVO.setId(aVO.getId());
            aVO.setNome(aVO.getNome());
            aVO.setCognome(aVO.getCognome());
            aVO.setDataNascita(aVO.getDataNascita());
            aVO.setLocalitaNascita(aVO.getLocalitaNascita());
            aVO.setProvinciaNascita(aVO.getProvinciaNascita());
            aVO.setProprietario(aVO.getProprietario());
            aVO.setCreateDate(aVO.getCreateDate());
            aVO.setCreateUser(aVO.getCreateUser());
            esito = AnagraficaPresentation.salva(aVO);
            if (esito.getReturnValue() == ReturnValues.SAVED) {
                esito.setEsito(true);
                status = 200;
            }
        }
        return Response.status(status).entity(esito).build();
    }
    
    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        
        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        //JSONObject jsonUtente = new JSONObject();
        
        if(esito.getReturnValue() == ReturnValues.FOUND){
            UtenteVO utenteVO = (UtenteVO)esito.getObject();
            AnagraficaVO aVO = new AnagraficaVO();
            
            aVO.setPrimaryKey(id);
            
            esito = AnagraficaPresentation.delete(aVO);

            if(esito.getReturnValue() == ReturnValues.SAVED){
                esito.setEsito(true);
            }            
            //jsonUtente = new JSONObject(mapper.writeValueAsString(utenteVO));
        }
        //String utente = jsonUtente.toString();


        return Response.status(200).entity(esito).build();
    } 


    /*@PUT
     @Path("{id}")
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     public Response put(@PathParam("id") String id, PersonaleVO personaleVO) throws JSONException, IOException {
     int status = 400;
     String username = securityContext.getUserPrincipal().getName();
        
     IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
     JSONObject jsonUtente = new JSONObject();
        
     if(esito.getReturnValue() == ReturnValues.FOUND){
     UtenteVO utenteVO = (UtenteVO)esito.getObject();
     jsonUtente = new JSONObject(mapper.writeValueAsString(utenteVO));
     }
     String utente = jsonUtente.toString();

     personaleVO.setPrimaryKey(id);
     personaleVO.setUpdateUser(username);
     personaleVO.setUpdateDate(new Date());
        
     esito = PersonalePresentation.salva(personaleVO);
     if(esito.getReturnValue() == ReturnValues.SAVED){
     esito.setEsito(true);
     status = 200;
     }

     return Response.status(status).entity(esito).build();
     }    */
    private EsitoBean salvaAllegati(List<AllegatoVO> documenti, AnagraficaVO anagrafica) {
        EsitoBean esito = new EsitoBean();

        if (!documenti.isEmpty()) {
            Iterator<AllegatoVO> itr = documenti.iterator();
            while (itr.hasNext()) {
                AllegatoVO allegato = itr.next();

                allegato.setData(new Date());
                allegato.setPrimaryKey(null);
                allegato.setTipoRiferimento(Sezioni.PAZIENTI);
                allegato.setCreateDate(new Date());
                allegato.setUpdateDate(new Date());
                allegato.setUpdateUser(anagrafica.getUpdateUser());
                allegato.setCreateUser(anagrafica.getCreateUser());
                allegato.setIdRiferimento(anagrafica.getId());
                allegato.setTipoFile("");
                allegato.setProprietario(anagrafica.getProprietario());

                esito = AllegatiPresentation.salva(allegato);
            }
        } else {
            esito.setEsito(true);
            esito.setReturnValue(ReturnValues.SAVED);
        }
        return esito;
    }

    @POST
    @Path("condividi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCondividi(String body) throws JSONException, IOException {
        int status = 400;
        String username = securityContext.getUserPrincipal().getName();
        EsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        JSONObject jsonBody = new JSONObject(body);

        String idRisorsa = jsonBody.isNull("idRisorsa") ? "" : jsonBody.getString("idRisorsa");
        String idUtenti = jsonBody.isNull("idUtenti") ? "" : jsonBody.getString("idUtenti");

        if (!idRisorsa.trim().equals("")) {
            String[] idUtentiSelezionati = idUtenti.split(";");
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_MONTH, 45);

            for (String idUtenteSelezionato : idUtentiSelezionati) {
                esito = CondivisioniPresentation.getListaByIdUtenteIdRisorsa(idUtenti, idRisorsa);
                if (esito.getReturnValue() == ReturnValues.FOUND) {
                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    CondivisioneVO cVO = (CondivisioneVO)esito.getObject();
                    esito.setEsito(false);
                    esito.setMessaggio("Risorsa già condivisa fino al " + df.format(cVO.getScadenzaCondivisione()));
                } else {
                    CondivisioneVO cVO = new CondivisioneVO();
                    cVO.setIdUtente(idUtenteSelezionato);
                    cVO.setIdRisorsa(idRisorsa);
                    cVO.setUsernameUtenteCondividente(username);
                    cVO.setTipoRisorsa("pazienti");
                    cVO.setScadenzaCondivisione(c.getTime());
                    cVO.setCreateDate(new Date());
                    cVO.setCreateUser(username);
                    esito = CondivisioniPresentation.salva(cVO);
                    if (esito.getReturnValue() == ReturnValues.SAVED) {
                        status = 200;
                    }
                }

            }
        } else {
            esito.setMessaggio("Manca l'idRisorsa");
        }

        return Response.status(status).entity(esito).build();
    }
}
