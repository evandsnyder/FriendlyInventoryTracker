package com.friendlygeek.fit.service.authentication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.friendlygeek.fit.config.FriendlyConfiguration;
import com.friendlygeek.fit.domain.User;
import com.friendlygeek.fit.service.exceptions.LoginException;

public class AuthenticationServiceImpl implements IAuthenticationService {

	private FriendlyConfiguration appConfiguration;

	public AuthenticationServiceImpl(FriendlyConfiguration appConfiguration) {
		this.appConfiguration = appConfiguration;
	}

	@Override
	public boolean authenticateUser(User user) throws LoginException {
		// Attempt to open file and search
		// Search from application properties...
		String accountFile = appConfiguration.GetProperty("AccountFileName");
		
		if(accountFile == null) {
			throw new LoginException("ERR: Not such property with name AccountFileName found"); 
		}
		
		try(FileInputStream inFile = new FileInputStream(accountFile); ObjectInputStream in = new ObjectInputStream(inFile)){
			User anyUser = (User)in.readObject();
			
			var givenPassword = user.getProfile().getPassword();
			var givenUsername = user.getProfile().getUsername();
			
			return anyUser.getProfile().getUsername().equals(givenUsername) && anyUser.getProfile().getPassword().equals(givenPassword);
		} catch (FileNotFoundException e) {
			throw new LoginException("Could not find given user file", e);
		} catch (IOException e) {
			throw new LoginException("Could not open user file", e);
		} catch (ClassNotFoundException e) {
			throw new LoginException("Error reading user file", e);
		}
	}

}
