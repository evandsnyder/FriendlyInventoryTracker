package com.friendlygeek.fit.service.inventory;

import java.util.UUID;

import com.friendlygeek.fit.domain.Asset;
import com.friendlygeek.fit.service.IService;

public interface IInventoryService extends IService {
	void addAsset(Asset newAsset);
	void updateAsset(Asset updatedAsset);
	Asset findAssetById(UUID assetId);
	Asset findAssetByName(String assetName);
}
