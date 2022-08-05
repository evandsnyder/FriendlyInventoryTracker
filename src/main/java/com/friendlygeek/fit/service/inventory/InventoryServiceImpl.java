package com.friendlygeek.fit.service.inventory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.friendlygeek.fit.config.FriendlyConfiguration;
import com.friendlygeek.fit.domain.Asset;
import com.friendlygeek.fit.service.exceptions.InventoryLoadException;
import com.friendlygeek.fit.service.exceptions.InventorySaveException;

public class InventoryServiceImpl implements IInventoryService {
	private FriendlyConfiguration appConfiguration;

	private ArrayList<Asset> inMemoryStore;

	public InventoryServiceImpl(FriendlyConfiguration appConfiguration) {
		this.appConfiguration = appConfiguration;

		try {
			loadInventory();
		} catch (InventoryLoadException e) {
			// Uhh just use a generic, empty array
			// Add log statement here detailed failure to load inventory from file...
			inMemoryStore = new ArrayList<>();
		}

	}

	private void loadInventory() throws InventoryLoadException{ // throw some kind of app configuration exception...
		String inputFileName = appConfiguration.GetProperty("InventoryFileName");
		try (FileInputStream fileIn = new FileInputStream(inputFileName);
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			inMemoryStore = (ArrayList<Asset>)in.readObject();
		} catch (FileNotFoundException e) {
			throw new InventoryLoadException("Could not find inventory file", e);
		} catch (IOException e) {
			throw new InventoryLoadException("Could not open inventory file", e);
		} catch (ClassNotFoundException e) {
			throw new InventoryLoadException("Error reading inventory file", e);
		}
	}
	
	@Override
	public void loadInventory(File inventoryFile) throws InventoryLoadException {
		try(FileInputStream fileIn = new FileInputStream(inventoryFile);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				){
			inMemoryStore = (ArrayList<Asset>)in.readObject();
		} catch (FileNotFoundException e) {
			throw new InventoryLoadException("Could not find inventory file", e);
		} catch (IOException e) {
			throw new InventoryLoadException("Could not open inventory file", e);
		} catch (ClassNotFoundException e) {
			throw new InventoryLoadException("Error reading inventory file", e);
		}
	}

	
	// Not going to fully flesh this out since its more for testing than "production"
	@Override
	public void saveAllAssets(File destinationFile) throws InventorySaveException {
		String outputFileName;
		File outFileDescriptor;
		if(destinationFile == null) {
			outputFileName = appConfiguration.GetProperty("InventoryFileName");
			// assert it isn't null...
			if(outputFileName == null) {
				throw new InventorySaveException("No filename was specified in the configuration");
			}
			
			outFileDescriptor = new File(outputFileName);
		} else {
			outFileDescriptor = destinationFile;
		}
		
		
		try {
			outFileDescriptor.createNewFile();
		} catch (IOException e1) {
			throw new InventorySaveException("Error creating the new inventory file");
		}
		
		try (FileOutputStream fileOut = new FileOutputStream(outFileDescriptor);
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

			out.writeObject(inMemoryStore);
		} catch (Exception e) {
			throw new InventorySaveException("No filename was specified in the configuration");
		}
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
	
	@Override
	public List<Asset> getInventory(){
		return inMemoryStore;
	}
}
