package com.friendlygeek.fit.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.config.FriendlyConfiguration;
import com.friendlygeek.fit.service.account.IProfileService;
import com.friendlygeek.fit.service.account.ProfileServiceImpl;
import com.friendlygeek.fit.service.exceptions.ServiceLoadException;
import com.friendlygeek.fit.service.exceptions.ServiceNotFoundException;

class ServiceFactoryTest {

	private static ServiceFactory uut;
	
	@BeforeAll
	public static void SetUp() {
		// Setup AppConfig
		FriendlyConfiguration appConfiguration = new FriendlyConfiguration();
		try {
		appConfiguration.LoadProperties();
		} catch (Exception e ) {
			// That shouldn't happen here...
			System.exit(-1);
		}
		
		// setup ServiceFactory...
		uut = new ServiceFactory(appConfiguration);
		
	}

	@Test
	void testGetServiceWithInvalidName() {
		Exception exception = assertThrows(ServiceLoadException.class, () -> {
			uut.getService("fake-service");
		});
		assertTrue(exception.getCause() instanceof ServiceNotFoundException);
	}


	@Test
	void testGetValidService() {
		try {
			IProfileService service = (IProfileService)uut.getService(IProfileService.NAME);
			assertTrue(service instanceof ProfileServiceImpl);
		} catch(Exception e) {
			fail("Received exception when there shouldn't be one");
		}
	}

}
