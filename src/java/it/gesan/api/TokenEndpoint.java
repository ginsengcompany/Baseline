/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.api;

import it.gesan.module.anagrafica.presentation.AnagraficaPresentation;
import it.gesan.module.anagrafica.vo.AnagraficaVO;
import it.gesan.module.dispositivi.presentation.DispositiviPresentation;
import it.gesan.module.dispositivi.vo.DispositivoVO;
import it.gesan.module.utenti.presentation.UtentiPresentation;
import it.gesan.module.utenti.vo.UtenteVO;
import it.gesan.module.sessioni.presentation.SessioniPresentation;
import it.gesan.module.sessioni.vo.SessioneVO;
import it.gesan.module.utenti.bo.UtentiBO;
import it.gesan.permessi.bo.VerificaPermessiBO;
import it.gesan.permessi.costants.Sezioni;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.utility.BasicAuth;
import it.gesan.views.beans.AuthorizationCredentials;
import it.gesan.views.utility.OAuthRequestWrapper;
import it.gesan.rdb.constants.ReturnValues;
import it.gesan.rdb.interfaces.IEsitoBean;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.TokenType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author sisto
 */
@Path("token")
public class TokenEndpoint {
    
    @Context
    SecurityContext securityContext;

    private String tipoDispositivo = null;
    private String sessionType = "N";
    private String clientId = null;
    private final ObjectMapper mapper = new ObjectMapper();
    private JSONObject jsonUtente = null;
//    @Inject
//    private Database database;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    //public Response authorize(@Context HttpServletRequest request) throws OAuthSystemException {
    public Response authorize(@Context HttpServletRequest request, MultivaluedMap<String, String> form) throws OAuthSystemException, JSONException {
        try {
            long sessionExpireIn = 3600000;
            String userAgent = request.getHeader("User-Agent");
            //OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);
            OAuthRequestWrapper requestWrapper = new OAuthRequestWrapper(request, form);
            OAuthTokenRequest oauthRequest = new OAuthTokenRequest(requestWrapper);
            OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
            String application = requestWrapper.getParameter("application");
            //String tipoDispositivo = requestWrapper.getParameter("dispositive_type");

            String username = "";
            // check if clientid is valid
            if (!checkClientId(oauthRequest.getClientId())) {
                return buildInvalidClientIdResponse();
            }

            // check if client_secret is valid
            if (!checkClientSecret(oauthRequest.getClientSecret())) {
                return buildInvalidClientSecretResponse();
            }

            // do checking for different grant types
            if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(GrantType.AUTHORIZATION_CODE.toString())) {
                if (!checkAuthCode(oauthRequest.getParam(OAuth.OAUTH_CODE))) {
                    return buildBadAuthCodeResponse();
                }
            } else if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(GrantType.CLIENT_CREDENTIALS.toString())) {
                AuthorizationCredentials credenziali = this.getCredenziali(request);
                if (!checkUserPass(credenziali.getUsername(), credenziali.getPassword())) {
                    return buildInvalidUserPassResponse("Username e/o password non corretti");
                } else {
                    username = credenziali.getUsername();
                    if (userAgent.equals("AdvaSoft")) {
                        JSONObject json = validaDispositivo(form);
                        if (!json.getBoolean("esito")) {
                            String returnMessage = "Errore nel validare il Dispositivo";
                            if (!json.isNull("messaggio")) {
                                returnMessage = json.getString("messaggio");
                            }
                            return buildInvalidUserPassResponse(returnMessage);
                        }
                    } else if (userAgent.equals("AdvaSoftMobile")) {
                        JSONObject json = validaDispositivoMobile(form);
                        if (!json.getBoolean("esito")) {
                            String returnMessage = "Errore nel validare il Dispositivo " + json.getString("messaggio");
                            if (!json.isNull("messaggio")) {
                                returnMessage = json.getString("messaggio");
                            }
                            return buildInvalidUserPassResponse(returnMessage);
                        }
                    } else if (userAgent != null) {
                        username = credenziali.getUsername();
                    } else {
                        String returnMessage = "Errore nel validare il Dispositivo";
                        return buildInvalidUserPassResponse(returnMessage);
                    }
                }
            } else if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(GrantType.PASSWORD.toString())) {
                if (!checkUserPass(oauthRequest.getUsername(), oauthRequest.getPassword())) {
                    return buildInvalidUserPassResponse("Username e/o password non corretti");
                } else {
                    username = oauthRequest.getUsername();
                }
            } else if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(GrantType.REFRESH_TOKEN.toString())) {
                // refresh token is not supported in this implementation
                buildInvalidUserPassResponse("Refresh token non permesso");
            }
            JSONObject session = new JSONObject();
            if (tipoDispositivo != null) {
                sessionExpireIn = 31536000000L;
                sessionType = "A";
                session.put("clientId", this.clientId);
            }
            final String accessToken = oauthIssuerImpl.accessToken();
            JSONObject jsonSession = new JSONObject();
            long createToken = new Date().getTime();
            long expiteToken = createToken + (sessionExpireIn);
            jsonSession.put("access_token", accessToken);
            jsonSession.put("expires_in", sessionExpireIn);
            jsonSession.put("create_token", createToken);
            jsonSession.put("expires_token", expiteToken);
            jsonSession.put("token_type", TokenType.BEARER.toString());
            jsonSession.put("username", username);
            jsonSession.put("session", session);
            jsonSession.put("session_type", sessionType);

            SessioniPresentation.create(jsonSession.toString());

            OAuthResponse response = OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setAccessToken(accessToken).setExpiresIn(String.valueOf(sessionExpireIn)).setParam("username", username).setTokenType(TokenType.BEARER.toString()).buildJSONMessage();
            return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
        } catch (OAuthProblemException e) {
            OAuthResponse res = OAuthASResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST).error(e).buildJSONMessage();
            return Response.status(res.getResponseStatus()).entity(res.getBody()).build();
        }
    }

    
    @GET
    @Path("applicativi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLista() throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();

        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);

        if (esito.getReturnValue() == ReturnValues.FOUND) {
            UtenteVO utenteVO = (UtenteVO) esito.getObject();
        }
        String a = SessioniPresentation.getSessioneType("{session_type : 'A'}");

        return Response.status(200).entity(a).build();
    }
    
    
    @POST
    @Path("applicativi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postToken(SessioneVO sessioneVO) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        int status = 401;
        IEsitoBean esito = new EsitoBean("Non si hanno i permessi per eseguire l'operazione");
        VerificaPermessiBO vpBO = new VerificaPermessiBO("utente", username, Sezioni.GRUPPI);

        if (vpBO.verificaPermessiInserimento()) {
                status = 400;
                JSONObject jsonSession = new JSONObject();
                long createToken = new Date().getTime();
                long sessionExpireIn = 31536000000L;
                sessionType = "A";
                long tokenExpires = sessioneVO.getExpiteToken().getTime();
                JSONObject session = new JSONObject();
                session.put("clientId",sessioneVO.getSession());
                jsonSession.put("access_token", sessioneVO.getAuthToken());
                jsonSession.put("expires_in", sessionExpireIn);
                jsonSession.put("create_token", createToken);
                jsonSession.put("expires_token", tokenExpires);
                jsonSession.put("token_type", TokenType.BEARER.toString());
                jsonSession.put("username", username);
                jsonSession.put("session", session);
                jsonSession.put("session_type", sessionType);

                esito = SessioniPresentation.create1(jsonSession.toString());
               

                if (esito.getReturnValue() == ReturnValues.SAVED) {
                status = 200;
            }
        }

        return Response.status(status).entity(esito).build();
    }
    
    
    @DELETE
    @Path("applicativi/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        
        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        //JSONObject jsonUtente = new JSONObject();
        
        if(esito.getReturnValue() == ReturnValues.FOUND){
            UtenteVO utenteVO = (UtenteVO)esito.getObject();
            SessioneVO sVO = new SessioneVO();
            
            sVO.setAuthToken(id);
            
            esito = SessioniPresentation.delete1(sVO);

            if(esito.getReturnValue() == ReturnValues.SAVED){
                esito.setEsito(true);
            }            
            //jsonUtente = new JSONObject(mapper.writeValueAsString(utenteVO));
        }
        //String utente = jsonUtente.toString();


        return Response.status(200).entity(esito).build();
    } 
    
    // ...
    private boolean checkClientId(String clientId) {
        return true;
    }

    private Response buildInvalidClientIdResponse() {
        return Response.status(401).entity("{}").build();
    }

    private boolean checkClientSecret(String clientSecret) {
        return true;
    }

    private Response buildInvalidClientSecretResponse() {
        return Response.status(401).entity("{}").build();
    }

    private boolean checkAuthCode(String param) {
        return true;
    }

    private Response buildBadAuthCodeResponse() {
        return Response.status(401).entity("{}").build();
    }

    private boolean checkUserPass(String username, String password) {
        boolean returnValue = false;
        IEsitoBean esito = UtentiPresentation.getUtenteByUsernamePassword(username, password);

        if (esito.getReturnValue() == ReturnValues.FOUND) {
            UtenteVO utenteVO = (UtenteVO) esito.getObject();
            try {
                this.jsonUtente = new JSONObject(mapper.writeValueAsString(utenteVO));
                returnValue = true;
            } catch (JSONException ex) {
                Logger.getLogger(TokenEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TokenEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return returnValue;
    }

    private Response buildInvalidUserPassResponse(String message) {
        return Response.status(401).entity("{\"error\": \"invalid_request\", \"error_description\": \"" + message + "\"}").build();
    }

    private AuthorizationCredentials getCredenziali(HttpServletRequest request) {
        AuthorizationCredentials returnValue;
        String auth = request.getHeader("Authorization");
        String username = "";
        String password = "";
        if (auth != null) {
            String[] lap = BasicAuth.decode(auth);
            username = lap[0];
            password = lap[1];
        }
        returnValue = new AuthorizationCredentials(username, password);
        return returnValue;
    }

    private JSONObject validaDispositivo(MultivaluedMap<String, String> form) {
        JSONObject returnValue = new JSONObject();

        try {
            returnValue.put("esito", false);
//            String tipoDispositivo = null;

            String codiceUtente = jsonUtente.getString("id");
            String descrizione = null;
            String applicazione = null;
            for (Map.Entry<String, List<String>> entry : form.entrySet()) {
                if (entry.getKey().equals("dispositive_type")) {
                    tipoDispositivo = ((List<String>) entry.getValue()).get(0);
                }
                if (entry.getKey().equals("client_id")) {
                    clientId = ((List<String>) entry.getValue()).get(0);
                }
                if (entry.getKey().equals("descrizione")) {
                    descrizione = ((List<String>) entry.getValue()).get(0);
                }
                if (entry.getKey().equals("applicazione")) {
                    applicazione = ((List<String>) entry.getValue()).get(0);
                }
                //            System.out.println(entry.getKey() + "/" + entry.getValue());
            }
            if (clientId != null && codiceUtente != null) {
                IEsitoBean esito = DispositiviPresentation.getDispositivoByClientId(clientId, codiceUtente);
                DispositivoVO dispositivoVO = (DispositivoVO) esito.getObject();

                String dispositivo = new JSONObject(mapper.writeValueAsString(dispositivoVO)).toString();
                if (tipoDispositivo == null) {
                    tipoDispositivo = "C";
                }

                if (tipoDispositivo.equals("M")) {
                    esito = DispositiviPresentation.getMaster(codiceUtente);
                    if (esito.getReturnValue() == ReturnValues.FOUND) {
                        returnValue.put("messaggio", "Dispositivo Master gia presente");
                    } else {
                        JSONObject jsonDispositivo = new JSONObject();
                        dispositivoVO.setClientId(clientId);
                        dispositivoVO.setCodiceUtente(codiceUtente);
                        dispositivoVO.setTipoDispositivo(tipoDispositivo);
                        dispositivoVO.setTipo("Desktop");
                        dispositivoVO.setDescrizione(descrizione);
                        dispositivoVO.setCreateDate(new Date());
                        dispositivoVO.setUpdateDate(new Date());
                        dispositivoVO.setCreateUser(jsonUtente.getString("username"));
                        dispositivoVO.setUpdateUser(jsonUtente.getString("username"));
                        dispositivoVO.setImpronta(clientId);
                        dispositivoVO.setApplicazione(applicazione);

                        IEsitoBean esitoRegistra = DispositiviPresentation.salva(dispositivoVO);
                        if (esitoRegistra.getReturnValue() == ReturnValues.SAVED) {
                            returnValue.put("esito", true);
                            dispositivoVO = (DispositivoVO) esitoRegistra.getObject();
                        } else {
                            returnValue.put("esito", false);
                            returnValue.put("messaggio", esitoRegistra.getMessaggio());
                        }
                        //JSONObject jsonEsitoRegistra = new JSONObject(mapper.writeValueAsString(esitoRegistra));
                        //returnValue = jsonEsitoRegistra;
                    }
                    dispositivoVO = (DispositivoVO) esito.getObject();
                    String dispositivoMaster = new JSONObject(mapper.writeValueAsString(dispositivoVO)).toString();

                    JSONObject jsonMaster = new JSONObject(dispositivoMaster);
                    if (!jsonMaster.isNull("clientId")) {

                    } else {

                    }

                } else {
                    JSONObject jsonDispositivo = new JSONObject(dispositivo);
                    if (jsonDispositivo.isNull("clientId")) {
                        dispositivoVO.setClientId(clientId);
                        dispositivoVO.setCodiceUtente(codiceUtente);
                        dispositivoVO.setTipoDispositivo(tipoDispositivo);
                        dispositivoVO.setTipo("Desktop");
                        dispositivoVO.setDescrizione(descrizione);
                        dispositivoVO.setCreateDate(new Date());
                        dispositivoVO.setUpdateDate(new Date());
                        dispositivoVO.setCreateUser(jsonUtente.getString("username"));
                        dispositivoVO.setUpdateUser(jsonUtente.getString("username"));
                        dispositivoVO.setImpronta(clientId);
                        dispositivoVO.setApplicazione(applicazione);

                        IEsitoBean esitoRegistra = DispositiviPresentation.salva(dispositivoVO);
                        if (esitoRegistra.getReturnValue() == ReturnValues.SAVED) {
                            returnValue.put("esito", true);
                            dispositivoVO = (DispositivoVO) esitoRegistra.getObject();
                        } else {
                            returnValue.put("esito", false);
                            returnValue.put("messaggio", esitoRegistra.getMessaggio());
                        }
                        //JSONObject jsonEsitoRegistra = new JSONObject(mapper.writeValueAsString(esitoRegistra));

                        //returnValue = jsonEsitoRegistra;
                    } else {
                        returnValue.put("messaggio", "Dispositivo gia presente");
                    }
                }

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return returnValue;
    }

    private JSONObject validaDispositivoMobile(MultivaluedMap<String, String> form) throws JSONException {
        JSONObject returnValue = new JSONObject();

        try {
            returnValue.put("esito", false);
            returnValue.put("messaggio", "");

            String id;
            String codiceUtente = jsonUtente.getString("id");
            String username = jsonUtente.getString("username");
            String descrizione = "";
            String impronta = null;
            String tipo = "";
            String applicazione = null;
//            String tipoDispositivo = null;

            //String codiceAzienda = null;
            for (Map.Entry<String, List<String>> entry : form.entrySet()) {
                if (entry.getKey().equals("dispositive_type")) {
                    tipoDispositivo = ((List<String>) entry.getValue()).get(0);
                }
                if (entry.getKey().equals("client_id")) {
                    clientId = ((List<String>) entry.getValue()).get(0);
                }
                if (entry.getKey().equals("codice_azienda")) {
                    codiceUtente = ((List<String>) entry.getValue()).get(0);
                }
                if (entry.getKey().equals("descrizione")) {
                    descrizione = ((List<String>) entry.getValue()).get(0);
                }
                if (entry.getKey().equals("impronta")) {
                    impronta = ((List<String>) entry.getValue()).get(0);
                }
                if (entry.getKey().equals("tipo")) {
                    tipo = ((List<String>) entry.getValue()).get(0);
                }
                if (entry.getKey().equals("applicazione")) {
                    applicazione = ((List<String>) entry.getValue()).get(0);
                }
            }
            if (impronta == null) {
                returnValue.put("messaggio", "Manca l'impronta del dispositivo");
            }
            if (applicazione == null) {
                applicazione = "Nessuna";
            }
            if (clientId != null && codiceUtente != null) {
                DispositivoVO dispositivoVO;
                IEsitoBean esito = DispositiviPresentation.getDispositivoByClientId(clientId, codiceUtente);
                if (esito.getReturnValue() == ReturnValues.FOUND) {
                    dispositivoVO = (DispositivoVO) esito.getObject();
                    if (!dispositivoVO.isAttivo()) {
                        if (!dispositivoVO.getImpronta().equals(impronta)) {
                            dispositivoVO.setCodiceUtente(codiceUtente);
                            dispositivoVO.setTipoDispositivo(tipoDispositivo);
                            dispositivoVO.setClientId(clientId);
                            dispositivoVO.setDescrizione(descrizione);
                            dispositivoVO.setImpronta(impronta);
                            dispositivoVO.setTipo(tipo);
                            dispositivoVO.setCreateUser(username);
                            dispositivoVO.setCreateDate(new Date());
                            dispositivoVO.setUpdateUser(username);
                            dispositivoVO.setUpdateDate(new Date());
                            dispositivoVO.setAttivo(false);
                            dispositivoVO.setApplicazione(applicazione);
                            esito = DispositiviPresentation.salva(dispositivoVO);
                            if (esito.getReturnValue() == ReturnValues.SAVED) {
                                returnValue.put("esito", true);
                                returnValue.put("messaggio", "Dispositivo associato correttamente");
                            } else {
                                returnValue.put("messaggio", esito.getMessaggio());
                            }
                        }
                        returnValue.put("messaggio", "Dispositivo presente ma non Attivo");
                    } else {
                        returnValue.put("messaggio", "Dispositivo Attivo");
                    }
                } else {
                    dispositivoVO = new DispositivoVO();

                    dispositivoVO.setCodiceUtente(codiceUtente);
                    dispositivoVO.setTipoDispositivo(tipoDispositivo);
                    dispositivoVO.setClientId(clientId);
                    dispositivoVO.setDescrizione(descrizione);
                    dispositivoVO.setImpronta(impronta);
                    dispositivoVO.setTipo(tipo);
                    dispositivoVO.setCreateUser(username);
                    dispositivoVO.setCreateDate(new Date());
                    dispositivoVO.setUpdateUser(username);
                    dispositivoVO.setUpdateDate(new Date());
                    dispositivoVO.setAttivo(false);
                    dispositivoVO.setApplicazione(applicazione);
                    esito = DispositiviPresentation.salva(dispositivoVO);
                    if (esito.getReturnValue() == ReturnValues.SAVED) {
                        returnValue.put("esito", true);
                        returnValue.put("messaggio", "Dispositivo associato ma non attivato");
                    } else {
                        returnValue.put("messaggio", esito.getMessaggio());
                    }
                }

                String dispositivo = new JSONObject(mapper.writeValueAsString(dispositivoVO)).toString();
                returnValue.put("data", dispositivo);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return returnValue;
    }
}
