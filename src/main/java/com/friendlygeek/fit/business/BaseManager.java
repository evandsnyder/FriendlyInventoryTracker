package com.friendlygeek.fit.business;

import com.friendlygeek.fit.config.ConfigurationLoadException;
import com.friendlygeek.fit.config.FriendlyConfiguration;

public class BaseManager {
	
	private FriendlyConfiguration appConfiguration;

	public BaseManager() {
		appConfiguration = new FriendlyConfiguration();
		try {
			appConfiguration.LoadProperties();
		} catch (ConfigurationLoadException e) {
			// Just crash if we can't load the properties file...
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public FriendlyConfiguration getConfig() {
		return appConfiguration;
	}

}
