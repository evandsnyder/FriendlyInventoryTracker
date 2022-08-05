package com.friendlygeek.fit.service.account;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.friendlygeek.fit.config.FriendlyConfiguration;
import com.friendlygeek.fit.domain.Profile;
import com.friendlygeek.fit.domain.User;

public class ProfileServiceImpl implements IProfileService {
	
	private FriendlyConfiguration appConfiguration;
	
	public ProfileServiceImpl(FriendlyConfiguration appConfiguration) {
		this.appConfiguration = appConfiguration;
	}

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

	@Override
	public void saveUser(User user) {
		// Only used for testing... not worried about unit testing this..
		String outFileName = appConfiguration.GetProperty("AccountFileName");
		if(outFileName == null) {
			return;
		}
		
		File outFileDescriptor = new File(outFileName);
		try {
			outFileDescriptor.createNewFile();
		} catch (IOException e1) {
			// Failed to create the new file....
			e1.printStackTrace();
		}
		
		try(var outFile = new FileOutputStream(outFileDescriptor); var out = new ObjectOutputStream(outFile)){
			out.writeObject(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
