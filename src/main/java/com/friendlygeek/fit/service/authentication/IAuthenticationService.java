package com.friendlygeek.fit.service.authentication;

import com.friendlygeek.fit.domain.User;
import com.friendlygeek.fit.service.IService;

public interface IAuthenticationService extends IService {
	boolean authenticateUser(User user);
}
