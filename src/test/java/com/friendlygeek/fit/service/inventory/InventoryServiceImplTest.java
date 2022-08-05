package com.friendlygeek.fit.service.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.friendlygeek.fit.config.ConfigurationLoadException;
import com.friendlygeek.fit.config.FriendlyConfiguration;
import com.friendlygeek.fit.domain.Asset;
import com.friendlygeek.fit.domain.UnitOfMeasure;
import com.friendlygeek.fit.service.exceptions.InventorySaveException;

class InventoryServiceImplTest {
	
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
	void testAddNewValidAsset() {
		InventoryServiceImpl uut = new InventoryServiceImpl(appConfig);
		Asset asset = new Asset("testAsset", "tA001", 1l, new UnitOfMeasure("meter"));
		uut.addAsset(asset);
		assertTrue(0 < uut.getDataStore().size());
	}
	
	@Test
	void testAddNewInvalidAsset() {
		InventoryServiceImpl uut = new InventoryServiceImpl(appConfig);
		var originalSize = uut.getDataStore().size();
		Asset newAsset = new Asset();
		uut.addAsset(newAsset);
		assertEquals(originalSize, uut.getDataStore().size(), "Expected size to remain unchanged");
		
	}
	
	@Test
	void testFindAssetByName() {
		InventoryServiceImpl uut = new InventoryServiceImpl(appConfig);
		Asset asset = new Asset("testAsset2", "tA001", 1l, new UnitOfMeasure("meter"));
		uut.addAsset(asset);
		assertTrue(0 < uut.getDataStore().size());
		
		
		
		Asset result = uut.findAssetByName("testAsset2");
		assertEquals(asset.getId(), result.getId());
	}
	
	@Test
	void testUpdateAsset() {
		InventoryServiceImpl uut = new InventoryServiceImpl(appConfig);
		Asset asset = new Asset("testAsset", "tA001", 1l, new UnitOfMeasure("meter"));
		uut.addAsset(asset);
		assertTrue(0 < uut.getDataStore().size());
		
		Asset copiedAsset = new Asset(asset);
		
		copiedAsset.setCommonName("tA002");
		uut.updateAsset(copiedAsset);
		assertTrue(0 < uut.getDataStore().size());
		assertEquals("tA002", uut.findAssetById(asset.getId()).getCommonName());
	}
	
	@Test
	@Disabled
	void testSaveInventory() {
		InventoryServiceImpl uut = new InventoryServiceImpl(appConfig);
		Asset asset = new Asset("testAsset", "tA001", 1l, new UnitOfMeasure("meter"));
		uut.addAsset(asset);
		
		try {
			uut.saveAllAssets(null);
		} catch (InventorySaveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
