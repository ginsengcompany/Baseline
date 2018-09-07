/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.views.utility;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.oltu.oauth2.common.validators.AbstractValidator;
/**
 *
 *
 *
 */
public class BearerHeaderOAuthValidator extends AbstractValidator {
    @Override
    public void validateContentType(HttpServletRequest request) throws OAuthProblemException {
    }
    @Override
    public void validateMethod(HttpServletRequest request) throws OAuthProblemException {
    }
    @Override
    public void validateRequiredParameters(HttpServletRequest request) throws OAuthProblemException {
        // Check if there is the Authorization Header
        String authzHeader = request.getHeader(OAuth.HeaderType.AUTHORIZATION);
        if (OAuthUtils.isEmpty(authzHeader)) {
            throw OAuthProblemException.error("", "Missing authorization header.");
        }
        // See if the authorization method is set to OAuth
        String authzMethod = OAuthUtils.getAuthzMethod(authzHeader);
        if (!OAuth.OAUTH_HEADER_NAME.equals(authzMethod)) {
            throw OAuthProblemException.error("", "Incorrect authorization method.");
        }
        // Get the header field
        String headerField = OAuthUtils.getAuthHeaderField(authzHeader);
        if (OAuthUtils.isEmpty(headerField)) {
            throw OAuthProblemException
                .error(OAuthError.TokenResponse.INVALID_REQUEST, "Missing required parameter.");
        }
        // Check if this OAuth 1.0 or OAuth 2.0
        Map<String, String> values = OAuthUtils.decodeOAuthHeader(authzHeader);
        String oauthVersionDiff = values.get(OAuth.OAUTH_VERSION_DIFFER);
        if (!OAuthUtils.isEmpty(oauthVersionDiff)) {
            throw OAuthProblemException
                .error(OAuthError.TokenResponse.INVALID_REQUEST,
                    "Incorrect OAuth version. Found OAuth V1.0.");
        }
    }
}
