package com.friendlygeek.fit.service.authentication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.config.ConfigurationLoadException;
import com.friendlygeek.fit.config.FriendlyConfiguration;
import com.friendlygeek.fit.domain.User;
import com.friendlygeek.fit.service.exceptions.LoginException;

class AuthenticationServiceImplTest {

	private static FriendlyConfiguration appConfig;

	@BeforeAll
	public static void SetUp() {
		appConfig = new FriendlyConfiguration();

		try {
			appConfig.LoadProperties();
		} catch (ConfigurationLoadException e) {
			System.exit(-1);
		}
	}

	@Test
	void testAuthenticate() {
		AuthenticationServiceImpl uut = new AuthenticationServiceImpl(appConfig);
		User testUser = new User("fName", "lName", "admin", "admin@admin.com", "adminPass");

		try {
			assertFalse(uut.authenticateUser(testUser));
			testUser.getProfile().setPassword("abc123");
			assertTrue(uut.authenticateUser(testUser));

		} catch (LoginException ex) {
			fail("Received unexpected LoginException");
		}

	}
}
