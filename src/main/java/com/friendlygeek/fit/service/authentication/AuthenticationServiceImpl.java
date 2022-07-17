package com.friendlygeek.fit.service.authentication;

import com.friendlygeek.fit.domain.User;

public class AuthenticationServiceImpl implements IAuthenticationService {

	@Override
	public boolean authenticateUser(User user) {
		// Using hard coded user information until we add a persistence layer
		return user.getProfile().getUsername().equals("admin") && user.getProfile().getPassword().equals("abc123");
	}

}
