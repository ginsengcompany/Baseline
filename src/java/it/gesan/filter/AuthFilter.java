/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.filter;

import it.gesan.security.UserInfo;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import it.gesan.module.sessioni.bo.SessioneBO;
import it.gesan.module.sessioni.presentation.SessioniPresentation;
import java.security.Principal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.SecurityContext;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.apache.oltu.oauth2.rs.response.OAuthRSResponse;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author sisto
 */
public class AuthFilter implements ContainerRequestFilter {

    private String username = null;

    private String session = null;
    
    private String  authToken = null;

    @Context
    HttpServletRequest webRequest;

    public static final String AUTH_TOKEN = "Authorization";

    @Override
    public ContainerRequest filter(ContainerRequest containerRequest) throws WebApplicationException {
        final HttpSession session = webRequest.getSession();
//String auth = containerRequest.getHeaderValue("user-agent");
        ResponseBuilder builder = null;
        String response = "{}";
        builder = Response.status(Response.Status.UNAUTHORIZED).type(MediaType.APPLICATION_JSON).entity(response);

        //GET, POST, PUT, DELETE, ...
        String method = containerRequest.getMethod();
        // myresource/get/56bCA for example
        String path = containerRequest.getPath(true);
        
        authToken = containerRequest.getHeaderValue(AuthFilter.AUTH_TOKEN);

        //We do allow wadl to be retrieve
        if (method.equals("GET") && (path.equals("application.wadl") || path.equals("application.wadl/xsd0.xsd"))) {
            return containerRequest;
        }

        if (method.equals("GET") && (path.equals("auth"))) {
            return containerRequest;
        }

        if (method.equals("POST") && (path.equals("token"))) {
            return containerRequest;
        }
        
        if (method.equals("GET") && (path.contains("registrazione"))) {
            return containerRequest;
        }
        if (method.equals("POST") && (path.equals("registrazione"))) {
            return containerRequest;
        }
        if (method.equals("POST") && (path.contains("registrazione"))) {
            return containerRequest;
        }
        

        
        try {
            String accessToken = "";
            
            if(path.contains("preview") || path.contains("download")){
                MultivaluedMap queryParams = containerRequest.getQueryParameters();
                if (queryParams.containsKey("authToken")) {
                    authToken = containerRequest.getQueryParameters().get("authToken").get(0);
                    accessToken = authToken;
                    authToken = "Bearer " + authToken;
                }            
            }  
            else{
                OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(webRequest, ParameterStyle.HEADER);
                // Get the access token
                accessToken = oauthRequest.getAccessToken();            
            }
            
//            OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(webRequest, ParameterStyle.HEADER);
//            // Get the access token
//            String accessToken = oauthRequest.getAccessToken();

            // Validate the access token
            //if (!database.isValidToken(accessToken)) {
//            String sessionParams = this.getBodyRequest(containerRequest);
            if (!this.isValidToken(accessToken, containerRequest)) {
                // Return the OAuth error message
                OAuthResponse oauthResponse = OAuthRSResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED).setRealm("").setError(OAuthError.ResourceResponse.INVALID_TOKEN).buildHeaderMessage();

                //return Response.status(Response.Status.UNAUTHORIZED).build();
                builder = Response.status(Response.Status.UNAUTHORIZED).header(OAuth.HeaderType.WWW_AUTHENTICATE, oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));

            } else {
                containerRequest.setSecurityContext(new SecurityContext() {
                    @Override
                    public Principal getUserPrincipal() {
                        return new UserInfo(username, authToken.replace("Bearer ", ""));
                    }

                    @Override
                    public boolean isUserInRole(String s) {
                        return false;
                    }

                    @Override
                    public boolean isSecure() {
                        return false;
                    }

                    @Override
                    public String getAuthenticationScheme() {
                        return null;
                    }
                });
                if (path.equals("validate")) {
                    builder = Response.status(Response.Status.OK).header("Content-Type", MediaType.APPLICATION_JSON).entity("{\"validate\":true, \"username\": \"" + this.username + "\", \"session\": " + this.session + "}");
                } else if (path.equals("profile")) {
                    builder = Response.status(Response.Status.OK).header("Content-Type", MediaType.APPLICATION_JSON).entity("{\"validate\":true, \"username\": \"" + this.username + "\", \"session\": " + this.session + "}");
                } else {
                    return containerRequest;
                }
                //

            }
            // [1]

        } catch (OAuthProblemException e) {
            try {
                OAuthResponse res = OAuthASResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST).error(e).buildJSONMessage();
                builder = Response.status(res.getResponseStatus()).entity(res.getBody());
            } catch (OAuthSystemException ex) {
                Logger.getLogger(AuthFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (OAuthSystemException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(AuthFilter.class.getName()).log(Level.SEVERE, null, ex);
        }

        throw new WebApplicationException(builder.build());
    }

    private boolean isValidToken(String accessToken, ContainerRequest containerRequest) {
        boolean returnValue = false;

        try {
            
            String session = SessioniPresentation.getSessione("{\"access_token\": \"" + accessToken + "\"}");
            if (session != null) {
                JSONObject jsonSession = new JSONObject(session);

                long istantDate = new Date().getTime(); // / 1000;
//                System.out.println(istantDate);
//                System.out.println(jsonSession.getLong("expiresToken"));
                if (istantDate > jsonSession.getLong("expiresToken")) {
                    SessioniPresentation.delete(jsonSession.getString("accessToken"));
                    return false;
                } else {
                    String sessionType = jsonSession.getString("sessionType");
                    String clientId = containerRequest.getHeaderValue("client_id");
                    if (sessionType.equals("A")) {
                        JSONObject sessionData = jsonSession.getJSONObject("session");
                        if (sessionData.isNull("clientId")) {
                            return false;
                        }
                        else{
                            this.username = jsonSession.getString("username");
                            if(clientId == null){
                                return false;
                            }
                            else{
                                if(sessionData.getString("clientId").equals(clientId)){
                                    return true;
                                }
                                else if(clientId.equals("interno")){
                                    return true;
                                }
                                else{
                                    return false;
                                }                                
                            }

                        }
                    } else {
                        long expiresToken = istantDate + jsonSession.getLong("expiresIn");
                        JSONObject jsonNewSession = SessioneBO.getNewSession(jsonSession, "{}");
                        jsonNewSession.put("expiresToken", expiresToken);
                        this.username = jsonNewSession.getString("username");
                        this.session = jsonNewSession.getString("session");
                        SessioniPresentation.update(jsonSession.toString(), jsonNewSession.toString());
                    }

                    return true;
                }
            }

        } catch (JSONException ex) {
            Logger.getLogger(AuthFilter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return returnValue;
    }
//
//    private String getBodyRequest(ContainerRequest containerRequest) {
//        InputStream incomingData = containerRequest.getEntityInputStream();
//        StringBuilder crunchifyBuilder = new StringBuilder();
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
//            String line = null;
//            while ((line = in.readLine()) != null) {
//                crunchifyBuilder.append(line);
//            }
//        } catch (Exception e) {
//            System.out.println("Error Parsing: - ");
//        }
//
//        String strBodyRequest = crunchifyBuilder.toString();
//        
//        return strBodyRequest;
//    }
}
