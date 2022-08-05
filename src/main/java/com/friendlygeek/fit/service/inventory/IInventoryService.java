package com.friendlygeek.fit.service.inventory;

import java.io.File;
import java.util.List;
import java.util.UUID;

import com.friendlygeek.fit.domain.Asset;
import com.friendlygeek.fit.service.IService;
import com.friendlygeek.fit.service.exceptions.InventoryLoadException;
import com.friendlygeek.fit.service.exceptions.InventorySaveException;

public interface IInventoryService extends IService {
	public final String NAME = "IInventoryService";
	
	void loadInventory(File inventoryFile) throws InventoryLoadException;
	void addAsset(Asset newAsset);
	void updateAsset(Asset updatedAsset);
	
	void saveAllAssets(File destinationFile)throws InventorySaveException;
	
	List<Asset> getInventory();
	Asset findAssetById(UUID assetId);
	Asset findAssetByName(String assetName);
}
