package com.friendlygeek.fit.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.friendlygeek.fit.service.exceptions.PropertyFileLoadException;
import com.friendlygeek.fit.service.exceptions.ServiceLoadException;
import com.friendlygeek.fit.service.exceptions.ServiceNotFoundException;

public class ServiceFactory {
	private Properties properties;
	private static final String PROP_LOCATION_ENV = "prop_location";

	public IService getService(String serviceName) throws ServiceLoadException {

		try {
			String fullyQualifiedImplementationName = getServiceImplementationByName(serviceName);

			IService service;
			Class<?> clazz = Class.forName(fullyQualifiedImplementationName);
			Constructor<?> constructor = clazz.getConstructor();
			service = (IService) constructor.newInstance();
			return service;
		} catch (PropertyFileLoadException e) {
			throw new ServiceLoadException("Could not read property file", e);
		} catch (Exception ex) {
			throw new ServiceLoadException("Failed to load requested service", ex);
		}
	}

	private String getServiceImplementationByName(String n) throws ServiceNotFoundException, PropertyFileLoadException {
		if (properties == null) {
			String propFileLocation = System.getProperty(PROP_LOCATION_ENV);
			properties = new Properties();

			try {
				FileInputStream propFileStream = new FileInputStream(propFileLocation);
				properties.load(propFileStream);
				propFileStream.close();
			} catch (IOException ex) {
				throw new PropertyFileLoadException("Could not open property file");
			}
		}

		String serviceName = properties.getProperty(n);
		if (serviceName == null)
			throw new ServiceNotFoundException("Could not find service named: " + n, null);
		return serviceName;
	}
}
