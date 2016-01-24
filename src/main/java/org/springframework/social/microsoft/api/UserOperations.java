package org.springframework.social.microsoft.api;

public interface UserOperations {

	MicrosoftProfile getUserProfile();

	MicrosoftProfile getUserProfileWithUsername(String userName);

}
