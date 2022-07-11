package com.friendlygeek.fit.service.inventory;

import java.util.UUID;

import com.friendlygeek.fit.domain.Asset;
import com.friendlygeek.fit.service.IService;

public interface IInventoryService extends IService {
	void addAsset(Asset newAsset);
	void updateAsset(Asset updatedAsset);
	void findAssetById(UUID assetId);
	void findAssetByName(String assetName);
}
