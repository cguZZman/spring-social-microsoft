package org.springframework.social.microsoft.security;

import org.springframework.social.microsoft.api.Microsoft;
import org.springframework.social.microsoft.connect.MicrosoftConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

public class MicrosoftAuthenticationService extends OAuth2AuthenticationService<Microsoft> {
	
	public MicrosoftAuthenticationService(String apiKey, String appSecret) {
		super(new MicrosoftConnectionFactory(apiKey, appSecret));
	}
	
}
