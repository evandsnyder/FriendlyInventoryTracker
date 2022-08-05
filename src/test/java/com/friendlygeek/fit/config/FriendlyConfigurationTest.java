package com.friendlygeek.fit.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.service.exceptions.PropertyFileLoadException;

class FriendlyConfigurationTest {
	
	FriendlyConfiguration uut = new FriendlyConfiguration();

	@Test
	void testFailToLoadPropertyFile() {
		System.setProperty("prop_location", "not-a-valid-location");
		Exception exception = assertThrows(ConfigurationLoadException.class, () -> {
			uut.LoadProperties();
		});

		assertTrue(exception.getCause() instanceof PropertyFileLoadException);
	}

}
