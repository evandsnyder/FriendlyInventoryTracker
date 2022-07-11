package com.friendlygeek.fit.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameTest {

	@Test
	void testEqualityWithSameObjectReference() {
		Name nameOne = new Name("evan", "snyder");
		Name nameTwo = nameOne;
		assertTrue(nameOne.equals(nameTwo));
	}

	@Test
	void testEqualityWithNullObject() {
		Name nameOne = new Name("evan", "snyder");

		assertFalse(nameOne.equals(null));
	}

	@Test
	void testEqualityWithDuplicateObject() {
		Name nameOne = new Name("evan", "snyder");
		Name nameTwo = new Name("evan", "snyder");
		assertFalse(nameOne.equals(nameTwo));
		nameTwo.setId(nameOne.getId());
		assertTrue(nameOne.equals(nameTwo));
	}
	
	@Test
	void testValidation() {
		Name uut = new Name();
		assertFalse(uut.validate());
		
		uut.setFirstName("testName");
		assertFalse(uut.validate());
		
		uut.setLastName("testLastName");
		assertTrue(uut.validate());
	}
}
