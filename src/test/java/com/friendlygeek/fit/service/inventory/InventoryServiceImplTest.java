package com.friendlygeek.fit.service.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.domain.Asset;
import com.friendlygeek.fit.domain.UnitOfMeasure;

class InventoryServiceImplTest {

	@Test
	void testAddNewValidAsset() {
		InventoryServiceImpl uut = new InventoryServiceImpl();
		Asset asset = new Asset("testAsset", "tA001", 1l, new UnitOfMeasure("meter"));
		uut.addAsset(asset);
		assertEquals(1, uut.getDataStore().size());
	}
	
	@Test
	void testAddNewInvalidAsset() {
		InventoryServiceImpl uut = new InventoryServiceImpl();
		Asset newAsset = new Asset();
		uut.addAsset(newAsset);
		assertEquals(0, uut.getDataStore().size());
		
	}
	
	@Test
	void testFindAssetByName() {
		InventoryServiceImpl uut = new InventoryServiceImpl();
		Asset asset = new Asset("testAsset", "tA001", 1l, new UnitOfMeasure("meter"));
		uut.addAsset(asset);
		assertEquals(1, uut.getDataStore().size());
		
		
		
		Asset result = uut.findAssetByName("testAsset");
		assertEquals(asset.getId(), result.getId());
	}
	
	@Test
	void testUpdateAsset() {
		InventoryServiceImpl uut = new InventoryServiceImpl();
		Asset asset = new Asset("testAsset", "tA001", 1l, new UnitOfMeasure("meter"));
		uut.addAsset(asset);
		assertEquals(1, uut.getDataStore().size());
		
		Asset copiedAsset = new Asset(asset);
		
		copiedAsset.setCommonName("tA002");
		uut.updateAsset(copiedAsset);
		assertEquals(1, uut.getDataStore().size());
		assertEquals("tA002", uut.findAssetById(asset.getId()).getCommonName());
	}

}
