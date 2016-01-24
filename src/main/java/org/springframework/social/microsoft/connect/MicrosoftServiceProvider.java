package org.springframework.social.microsoft.connect;

import org.springframework.social.microsoft.api.Microsoft;
import org.springframework.social.microsoft.api.impl.MicrosoftTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class MicrosoftServiceProvider extends AbstractOAuth2ServiceProvider<Microsoft> {

	public static final String ACCESS_TOKEN_URI = "https://login.microsoft.com/oauth20_token.srf";
	public static final String AUTHORIZAION_URI = "https://login.microsoft.com/oauth20_authorize.srf";
	public static final String MOBILE_REDIRECT_URI = "https://login.microsoft.com/oauth20_desktop.srf";
	
	public MicrosoftServiceProvider(String clientId, String clientSecret) {
		super(new OAuth2Template(clientId, clientSecret, AUTHORIZAION_URI, ACCESS_TOKEN_URI));
	}

	public Microsoft getApi(String accessToken) {
		return new MicrosoftTemplate(accessToken);
	}

}
