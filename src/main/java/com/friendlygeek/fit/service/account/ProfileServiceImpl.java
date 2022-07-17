package com.friendlygeek.fit.service.account;

import com.friendlygeek.fit.domain.Profile;

public class ProfileServiceImpl implements IProfileService {

	@Override
	public boolean updateUsername(Profile profile, String newUsername) {
		if(newUsername == null || newUsername.isBlank() || newUsername.isEmpty() || newUsername.length() < 4) {
			// All bad options
			return false;
		}
		if(profile.getUsername().equals(newUsername)) {
			// Name doesn't need changed
			return false;
		}
		
		profile.setUsername(newUsername);
		
		return true;
	}

	@Override
	public boolean updatePassword(Profile profile, String newPassword) {
		if(newPassword == null || newPassword.isBlank() || newPassword.isEmpty() || newPassword.length() < 8) {
			return false;
		}
		
		if(profile.getPassword().equals(newPassword)){
			return false;
		}
		
		profile.setPassword(newPassword);
		return true;
	}
	
}
