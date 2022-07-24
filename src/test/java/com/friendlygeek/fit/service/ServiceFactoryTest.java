package com.friendlygeek.fit.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.service.account.IProfileService;
import com.friendlygeek.fit.service.account.ProfileServiceImpl;
import com.friendlygeek.fit.service.exceptions.PropertyFileLoadException;
import com.friendlygeek.fit.service.exceptions.ServiceLoadException;
import com.friendlygeek.fit.service.exceptions.ServiceNotFoundException;

class ServiceFactoryTest {

	private ServiceFactory uut = new ServiceFactory();

	@Test
	void testFailToLoadPropertyFile() {
		System.setProperty("prop_location", "not-a-valid-location");
		Exception exception = assertThrows(ServiceLoadException.class, () -> {
			uut.getService(null);
		});

		assertTrue(exception.getCause() instanceof PropertyFileLoadException);
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
