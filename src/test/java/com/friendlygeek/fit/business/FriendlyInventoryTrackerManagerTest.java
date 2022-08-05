package com.friendlygeek.fit.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.domain.Asset;
import com.friendlygeek.fit.domain.UnitOfMeasure;

class FriendlyInventoryTrackerManagerTest {

	private static FriendlyInventoryTrackerManager uut;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		uut = new FriendlyInventoryTrackerManager();
	}

	@Test
	void testAuthenticateUserWithBadCredentials() {
		var response = uut.authenticateUser("yee", "haw");
		assertEquals("Incorrect username or password", response, "Expected login failure");
	}

	@Test
	void testAuthenticateWithValidCredentials() {
		var response = uut.authenticateUser("admin", "abc123");
		assertEquals("Successfully logged in", response, "Expected successful login");
	}

	@Test
	void searchInventoryWithValidItem() {
		var response = uut.searchInventory("testAsset");
		assertEquals(
				"Asset [id=1240c9e0-1377-4f9b-a2e1-31eb7e3de141, commonName=testAsset, internalId=tA001, quantity=1, unitOfMeasure=UnitOfMeasure [unit=meter], description=null]",
				response, "Expected to find asset");
	}

	@Test
	void searchInventoryWithInvalidItem() {
		var response = uut.searchInventory("FAKEITEM");
		assertEquals("Could not find the requested asset", response, "Expected to fail asset search");
	}

	@Test
	void testAddInvalidAsset() {
		var response = uut.addToInventory(new Asset());
		assertEquals("Invalid asset configuration", response, "Expected asset to have invalid configuration");
	}

	@Test
	void testAddValidAsset() {
		var response = uut.addToInventory(new Asset("testAsset2", "tA0012", 1l, new UnitOfMeasure("meter")));
		assertEquals("Added asset to inventory", response, "Expected asset to be successfully added");
	}

}
