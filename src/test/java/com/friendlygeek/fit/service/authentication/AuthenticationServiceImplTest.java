package com.friendlygeek.fit.service.authentication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.domain.User;

class AuthenticationServiceImplTest {

	@Test
	void testAuthenticate() {
		AuthenticationServiceImpl uut = new AuthenticationServiceImpl();
		User testUser = new User("fName", "lName", "admin", "admin@admin.com", "adminPass");
		assertFalse(uut.authenticateUser(testUser));
		
		testUser.getProfile().setPassword("abc123");
		assertTrue(uut.authenticateUser(testUser));
	}

}
