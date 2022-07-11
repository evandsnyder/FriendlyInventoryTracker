package com.friendlygeek.fit.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitOfMeasureTest {

	@Test
	void testEqualityWithSameObjectReference() {
		UnitOfMeasure uomOne = new UnitOfMeasure("gram");
		UnitOfMeasure uomTwo = uomOne;
		
		
		assertTrue(uomOne.equals(uomTwo));

	}

	@Test
	void testEqualityWithNullObject() {
		UnitOfMeasure uomOne = new UnitOfMeasure("gram");
		
		assertFalse(uomOne.equals(null));
	}

	@Test
	void testEqualityWithDuplicateObject() {
		UnitOfMeasure uomOne = new UnitOfMeasure("gram");
		UnitOfMeasure uomTwo = new UnitOfMeasure("gram");
		
		assertFalse(uomOne.equals(uomTwo));
		
		uomTwo.setId(uomOne.getId());
		
		assertTrue(uomOne.equals(uomTwo));
	}
	
	@Test
	void testValidation() {
		UnitOfMeasure uut = new UnitOfMeasure();
		assertFalse(uut.validate());
		
		uut.setUnit("gram");
		assertTrue(uut.validate());
	}

}
