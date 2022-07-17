package com.friendlygeek.fit.service.account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.domain.Profile;

class ProfileServiceImplTest {

	@Test
	void testUpdateUsernameWithNullName() {
		Profile testProfile = new Profile("testUser", "testUser@gmail.com", "testPass");

		ProfileServiceImpl uut = new ProfileServiceImpl();

		assertFalse(uut.updateUsername(testProfile, null));
	}

	@Test
	void testUpdateUsernameWithEmptyName() {
		Profile testProfile = new Profile("testUser", "testUser@gmail.com", "testPass");

		ProfileServiceImpl uut = new ProfileServiceImpl();

		assertFalse(uut.updateUsername(testProfile, ""));
	}

	@Test
	void testUpdateUsernameWithSameName() {
		Profile testProfile = new Profile("testUser", "testUser@gmail.com", "testPass");

		ProfileServiceImpl uut = new ProfileServiceImpl();

		assertFalse(uut.updateUsername(testProfile, "testUser"));
	}

	@Test
	void testUpdateUsernameSuccess() {
		Profile testProfile = new Profile("testUser", "testUser@gmail.com", "testPass");

		ProfileServiceImpl uut = new ProfileServiceImpl();

		assertTrue(uut.updateUsername(testProfile, "testUser2"));
	}
	
	@Test
	void testUpdatePasswordAll() {
		Profile testProfile = new Profile("testUser", "testUser@gmail.com", "testPass");

		ProfileServiceImpl uut = new ProfileServiceImpl();
		
		assertFalse(uut.updatePassword(testProfile, null));
		assertFalse(uut.updatePassword(testProfile, ""));
		assertFalse(uut.updatePassword(testProfile, "short"));
		
		assertTrue(uut.updatePassword(testProfile, "newPassword1234"));
	}
}
