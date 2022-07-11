package com.friendlygeek.fit.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssetTest {

	@Test
	void testEqualityWithSameObjectReference() {
		Asset assetOne = new Asset("iron-plate", "ip001", 2L, new UnitOfMeasure("tons"));
		Asset assetTwo = assetOne;

		assertTrue(assetOne.equals(assetTwo));
	}

	@Test
	void testEqualityWithNullObject() {
		Asset assetOne = new Asset("iron-plate", "ip001", 2L, new UnitOfMeasure("tons"));
		assertFalse(assetOne.equals(null));
	}

	@Test
	void testEqualityWithDuplicateObject() {
		UnitOfMeasure testUoM = new UnitOfMeasure("tons");
		Asset assetOne = new Asset("iron-plate", "ip001", 2L, testUoM);
		Asset assetTwo = new Asset("iron-plate", "ip001", 2L, testUoM);

		assertFalse(assetOne.equals(assetTwo));

		assetTwo.setId(assetOne.getId());

		assertTrue(assetOne.equals(assetTwo));
	}

	@Test
	void testValidation() {
		Asset testAsset = new Asset();
		assertFalse(testAsset.validate());

		testAsset.setCommonName("test");
		assertFalse(testAsset.validate());

		testAsset.setInternalId("tID");
		assertFalse(testAsset.validate());

		testAsset.setQuantity(2L);
		assertFalse(testAsset.validate());

		testAsset.setUnitOfMeasure(new UnitOfMeasure("gram"));

		assertTrue(testAsset.validate());
	}

}
