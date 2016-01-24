package org.springframework.social.microsoft.api.impl;

import org.springframework.social.microsoft.api.Microsoft;
import org.springframework.social.microsoft.api.UserOperations;
import org.springframework.social.microsoft.api.onedrive.OneDriveOperations;
import org.springframework.social.microsoft.api.onedrive.impl.OneDriveTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;

public class MicrosoftTemplate extends AbstractOAuth2ApiBinding implements Microsoft {
	private UserOperations userOperations;
	private OneDriveOperations oneDriveOperations;

	public MicrosoftTemplate() {
		initSubApis();
	}

	public MicrosoftTemplate(String accessToken) {
		super(accessToken);
		initSubApis();
	}

	@Override
	public UserOperations userOperations() {
		return userOperations;
	}

	@Override
	public OneDriveOperations oneDriveOperations() {
		return oneDriveOperations;
	}
	
	private void initSubApis() {
		userOperations = new UserTemplate(this, getRestTemplate(), isAuthorized());
		oneDriveOperations = new OneDriveTemplate(this, getRestTemplate(), isAuthorized());
	}
}
