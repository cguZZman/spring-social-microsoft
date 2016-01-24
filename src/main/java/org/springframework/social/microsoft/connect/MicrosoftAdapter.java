package org.springframework.social.microsoft.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.microsoft.api.Microsoft;
import org.springframework.social.microsoft.api.MicrosoftProfile;

public class MicrosoftAdapter implements ApiAdapter<Microsoft> {

	public boolean test(Microsoft microsoft) {
		try {
			microsoft.userOperations().getUserProfile();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(Microsoft microsoft, ConnectionValues values) {
		MicrosoftProfile profile = microsoft.userOperations().getUserProfile();
		values.setProviderUserId(profile.getId());
		values.setDisplayName(profile.getName());
		values.setProfileUrl(profile.getLink());
		values.setImageUrl("https://apis.microsoft.net/v5.0/" + profile.getId() + "/picture");
	}

	public UserProfile fetchUserProfile(Microsoft microsoft) {
		MicrosoftProfile profile = microsoft.userOperations().getUserProfile();
		return new UserProfileBuilder().setFirstName(profile.getFirstName()).setLastName(profile.getLastName())
				.setUsername(profile.getId()).build();
	}

	public void updateStatus(Microsoft microsoft, String message) {
	}
	
}
