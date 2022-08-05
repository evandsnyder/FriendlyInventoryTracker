package com.friendlygeek.fit.service.account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.config.ConfigurationLoadException;
import com.friendlygeek.fit.config.FriendlyConfiguration;
import com.friendlygeek.fit.domain.Profile;
import com.friendlygeek.fit.domain.User;

class ProfileServiceImplTest {

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
	void testUpdateUsernameWithNullName() {
		Profile testProfile = new Profile("testUser", "testUser@gmail.com", "testPass");

		ProfileServiceImpl uut = new ProfileServiceImpl(appConfig);

		assertFalse(uut.updateUsername(testProfile, null));
	}

	@Test
	void testUpdateUsernameWithEmptyName() {
		Profile testProfile = new Profile("testUser", "testUser@gmail.com", "testPass");

		ProfileServiceImpl uut = new ProfileServiceImpl(appConfig);

		assertFalse(uut.updateUsername(testProfile, ""));
	}

	@Test
	void testUpdateUsernameWithSameName() {
		Profile testProfile = new Profile("testUser", "testUser@gmail.com", "testPass");

		ProfileServiceImpl uut = new ProfileServiceImpl(appConfig);

		assertFalse(uut.updateUsername(testProfile, "testUser"));
	}

	@Test
	void testUpdateUsernameSuccess() {
		Profile testProfile = new Profile("testUser", "testUser@gmail.com", "testPass");

		ProfileServiceImpl uut = new ProfileServiceImpl(appConfig);

		assertTrue(uut.updateUsername(testProfile, "testUser2"));
	}

	@Test
	void testUpdatePasswordAll() {
		Profile testProfile = new Profile("testUser", "testUser@gmail.com", "testPass");

		ProfileServiceImpl uut = new ProfileServiceImpl(appConfig);

		assertFalse(uut.updatePassword(testProfile, null));
		assertFalse(uut.updatePassword(testProfile, ""));
		assertFalse(uut.updatePassword(testProfile, "short"));

		assertTrue(uut.updatePassword(testProfile, "newPassword1234"));
	}
	
	// Just to have the outfile ready to go...
	@Test
	void testWriteToFile() {
		var testUser = new User("test", "test", "admin", "admin@admin.com","abc123");
		var uut = new ProfileServiceImpl(appConfig);
		
		uut.saveUser(testUser);
	}
}
