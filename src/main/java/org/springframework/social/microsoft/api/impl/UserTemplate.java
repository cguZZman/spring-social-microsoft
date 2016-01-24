package org.springframework.social.microsoft.api.impl;

import org.springframework.social.microsoft.api.MicrosoftProfile;
import org.springframework.social.microsoft.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractMicrosoftOperations implements UserOperations {
	public static final String API_URL_BASE = "https://apis.live.net/v5.0";
	public static final String PATH_SEPARATOR = "/";
	
	public UserTemplate(MicrosoftTemplate microsoftTemplate, RestTemplate restTemplate, boolean authorized) {
		super(restTemplate, authorized);
	}

	@Override
	public MicrosoftProfile getUserProfile() {
		return getEntity(API_URL_BASE + "/me", MicrosoftProfile.class);
	}

	@Override
	public MicrosoftProfile getUserProfileWithUsername(String userName) {
		return getEntity(API_URL_BASE + PATH_SEPARATOR + userName, MicrosoftProfile.class);
	}

}
