package com.friendlygeek.fit.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfileTest {

	@Test
	void testEqualityWithSameObjectReference() {
		Profile profileOne = new Profile("test@gmail.com", "test@gmail.com", "testpass");
		Profile profileTwo = profileOne;
		
		assertTrue(profileOne.equals(profileTwo));
	}

	@Test
	void testEqualityWithNullObject() {
		Profile profileOne = new Profile("test@gmail.com", "test@gmail.com", "testpass");
		
		assertFalse(profileOne.equals(null));
	}

	@Test
	void testEqualityWithDuplicateObject() {
		Profile profileOne = new Profile("test@gmail.com", "test@gmail.com", "testpass");
		Profile profileTwo = new Profile("test@gmail.com", "test@gmail.com", "testpass");
		
		assertFalse(profileOne.equals(profileTwo));
		
		profileTwo.setId(profileOne.getId());
		
		assertTrue(profileOne.equals(profileTwo));
	}
	
	@Test
	void testValidation() {
		Profile uut = new Profile();
		assertFalse(uut.validate());
		
		uut.setEmail("TestEmail");
		assertFalse(uut.validate());
		
		uut.setUsername("testUsername");
		assertFalse(uut.validate());
		
		uut.setPassword("testPassword");
		assertTrue(uut.validate());
	}

}
