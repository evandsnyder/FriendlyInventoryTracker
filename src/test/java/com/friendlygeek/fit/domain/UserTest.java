package com.friendlygeek.fit.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testEqualityWithSameObjectReference() {
		User userOne = new User("evan", "snyder", "esnyder", "test@gmail.com", "testpass");
		User userTwo = userOne;

		assertTrue(userOne.equals(userTwo));
	}

	@Test
	void testEqualityWithNullObject() {
		User userOne = new User("evan", "snyder", "esnyder", "test@gmail.com", "testpass");

		assertFalse(userOne.equals(null));
	}

	@Test
	void testEqualityWithDuplicateObject() {
		Name testName = new Name("evan", "snyder");
		Profile testProfile = new Profile("esnyder", "test@gmail.com", "testpass");
		User userOne = new User(testName, testProfile);
		User userTwo = new User(testName, testProfile);

		assertFalse(userOne.equals(userTwo));

		userTwo.setId(userOne.getId());

		assertTrue(userOne.equals(userTwo));
	}

	@Test
	void testValidation() {
		User uut = new User();
		assertFalse(uut.validate());

		uut.setName(new Name("first", "last"));
		assertFalse(uut.validate());

		uut.setProfile(new Profile("username", "email", "pass"));
		assertTrue(uut.validate());
	}

}
