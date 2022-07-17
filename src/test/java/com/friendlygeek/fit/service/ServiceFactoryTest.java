package com.friendlygeek.fit.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.service.account.IProfileService;

class ServiceFactoryTest {

	private ServiceFactory uut = new ServiceFactory();
	@Test
	void testGetInvalidService() {
		assertNull(uut.getService("anything"));
	}
	
	@Test
	void testGetValidService() {
		assertTrue(uut.getService("profile") instanceof IProfileService);
	}

}
