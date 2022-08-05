package com.friendlygeek.fit.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.friendlygeek.fit.service.exceptions.PropertyFileLoadException;

public class FriendlyConfiguration {

	private Properties properties;

	private static final String PROP_LOCATION_ENV = "prop_location";

	public FriendlyConfiguration() {
	}

	public void LoadProperties() throws ConfigurationLoadException {

		if (properties == null) {
			String propFileLocation = System.getProperty(PROP_LOCATION_ENV);
			properties = new Properties();

			try {
				FileInputStream propFileStream = new FileInputStream(propFileLocation);
				properties.load(propFileStream);
				propFileStream.close();
			} catch (IOException ex) {
				throw new ConfigurationLoadException("Could not open property file", new PropertyFileLoadException());
			}
		}
	}

	public String GetProperty(String propName) {

		// Shouldn't hit this..
		if (properties == null) {
			throw new RuntimeException("Properties failed to load successfully");
		}

		return (String) properties.get(propName);
	}

}
