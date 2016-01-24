package org.springframework.social.microsoft.config.support;

import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.microsoft.api.Microsoft;

public class MicrosoftApiHelper implements ApiHelper<Microsoft> {

	private final UsersConnectionRepository usersConnectionRepository;
	private final UserIdSource userIdSource;

	public MicrosoftApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
		this.usersConnectionRepository = usersConnectionRepository;
		this.userIdSource = userIdSource;
	}

	@Override
	public Microsoft getApi() {
		Connection<Microsoft> connection = usersConnectionRepository
				.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(Microsoft.class);
		return connection != null ? connection.getApi() : null;
	}

}
