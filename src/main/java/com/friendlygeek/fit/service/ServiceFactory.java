package com.friendlygeek.fit.service;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import com.friendlygeek.fit.config.FriendlyConfiguration;
import com.friendlygeek.fit.service.exceptions.ServiceLoadException;
import com.friendlygeek.fit.service.exceptions.ServiceNotFoundException;

public class ServiceFactory {
	private FriendlyConfiguration appConfiguration;
	
	private HashMap<String, IService> loadedServices;
	
	
	public ServiceFactory(FriendlyConfiguration appConfiguration) {
		this.appConfiguration = appConfiguration;
		loadedServices = new HashMap<>();
	}

	public IService getService(String serviceName) throws ServiceLoadException {
		
		var knownService = loadedServices.get(serviceName);
		if(knownService != null) {
			return knownService;
		}

		try {
			String fullyQualifiedImplementationName = getServiceImplementationByName(serviceName);

			IService service;
			Class<?> clazz = Class.forName(fullyQualifiedImplementationName);
			Constructor<?> constructor = clazz.getConstructor(FriendlyConfiguration.class);
			service = (IService) constructor.newInstance(appConfiguration);
			loadedServices.put(serviceName, service);
			return service;
		} catch (Exception ex) {
			throw new ServiceLoadException("Failed to load requested service", ex);
		}
	}

	private String getServiceImplementationByName(String n) throws ServiceNotFoundException {
		String serviceName = appConfiguration.GetProperty(n);
		if (serviceName == null)
			throw new ServiceNotFoundException("Could not find service named: " + n, null);
		return serviceName;
	}
}
