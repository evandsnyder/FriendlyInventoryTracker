package com.friendlygeek.fit.service.account;

import com.friendlygeek.fit.domain.Profile;
import com.friendlygeek.fit.service.IService;

public interface IProfileService extends IService {
	boolean updateUsername(Profile profile, String newUsername);
	boolean updatePassword(Profile profile, String newPassword);
}