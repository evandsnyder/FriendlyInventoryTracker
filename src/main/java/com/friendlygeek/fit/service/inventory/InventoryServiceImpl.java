package com.friendlygeek.fit.service.inventory;

import java.util.ArrayList;
import java.util.UUID;

import com.friendlygeek.fit.domain.Asset;

public class InventoryServiceImpl implements IInventoryService {

	private ArrayList<Asset> inMemoryStore;
	
	public InventoryServiceImpl() {
		inMemoryStore = new ArrayList<>();
	}

	@Override
	public void addAsset(Asset newAsset) {
		if (newAsset.validate()) {
			inMemoryStore.add(newAsset);
		}

	}

	@Override
	public void updateAsset(Asset updatedAsset) {
		// Find the index of the existing asset and replace it...
		if (!updatedAsset.validate()) {
			return;
		}

		Asset existingAsset = inMemoryStore.stream().filter(asset -> asset.getId().equals(updatedAsset.getId()))
				.findFirst().orElse(null);
		if (existingAsset != null) {
			inMemoryStore.set(inMemoryStore.indexOf(existingAsset), updatedAsset);
		}

	}

	@Override
	public Asset findAssetById(UUID assetId) {
		return inMemoryStore.stream().filter(asset -> asset.getId().equals(assetId)).findFirst().orElse(null);
	}

	@Override
	public Asset findAssetByName(String assetName) {
		return inMemoryStore.stream().filter(asset -> asset.getCommonName().equals(assetName)).findFirst().orElse(null);
	}

	public ArrayList<Asset> getDataStore() {
		return inMemoryStore;
	}
}
