package com.friendlygeek.fit.business;

import java.io.File;
import java.util.List;

import com.friendlygeek.fit.domain.Asset;
import com.friendlygeek.fit.domain.User;
import com.friendlygeek.fit.service.ServiceFactory;
import com.friendlygeek.fit.service.authentication.IAuthenticationService;
import com.friendlygeek.fit.service.exceptions.InventoryLoadException;
import com.friendlygeek.fit.service.exceptions.InventorySaveException;
import com.friendlygeek.fit.service.exceptions.LoginException;
import com.friendlygeek.fit.service.exceptions.ServiceLoadException;
import com.friendlygeek.fit.service.inventory.IInventoryService;

public class FriendlyInventoryTrackerManager extends BaseManager {

	private ServiceFactory serviceFactory;

	public FriendlyInventoryTrackerManager() {
		super();
		serviceFactory = new ServiceFactory(getConfig());
	}

	public String authenticateUser(String username, String password) {

		IAuthenticationService authService;
		try {
			authService = (IAuthenticationService) serviceFactory.getService(IAuthenticationService.NAME);
		} catch (ServiceLoadException e) {

			return "Could not log you. Please try again later. If this problem persists, contact your system administrator";
		}

		boolean success = false;
		try {
			success = authService.authenticateUser(new User("", "", username, "", password));
		} catch (LoginException e) {
			return "Failed to log in";
		}

		if (success) {
			return "Successfully logged in";
		}

		return "Incorrect username or password";
	}

	public String searchInventory(String assetName) {
		IInventoryService inventory;
		try {
			inventory = (IInventoryService) serviceFactory.getService(IInventoryService.NAME);
		} catch (ServiceLoadException e) {
			return "Could not query the inventory. If this problem persists, please contact your system administrator";
		}

		var result = inventory.findAssetByName(assetName);
		if (result == null) {
			return "Could not find the requested asset";
		}

		return result.toString();
	}

	public String addToInventory(Asset newAsset) {
		if (!newAsset.validate()) {
			return "Invalid asset configuration";
		}

		IInventoryService inventory;
		try {
			inventory = (IInventoryService) serviceFactory.getService(IInventoryService.NAME);
		} catch (ServiceLoadException e) {
			return "Could not access the inventory. If this problem persists, please contact your system administrator";
		}

		inventory.addAsset(newAsset);
		return "Added asset to inventory";
	}

	public String loadInventory(File inventoryFile) {
		IInventoryService inventory;
		try {
			inventory = (IInventoryService) serviceFactory.getService(IInventoryService.NAME);
		} catch (ServiceLoadException e) {
			return "Could not access the inventory. If this problem persists, please contact your system administrator";
		}

		try {
			inventory.loadInventory(inventoryFile);
		} catch (InventoryLoadException e) {
			return "Failed to load inventory from file";
		}

		return "Successfully loaded inventory";

	}

	public List<Asset> getInventory() {
		IInventoryService inventory;
		try {
			inventory = (IInventoryService) serviceFactory.getService(IInventoryService.NAME);
		} catch (ServiceLoadException e) {
			return null;
			// return "Could not access the inventory. If this problem persists, please
			// contact your system administrator";
		}

		return inventory.getInventory();
	}

	public String saveInventory(File saveFile) {
		IInventoryService inventory;
		try {
			inventory = (IInventoryService) serviceFactory.getService(IInventoryService.NAME);
			inventory.saveAllAssets(saveFile);
		} catch (ServiceLoadException e) {
			return "Error accessing inventory service";
		} catch (InventorySaveException e) {
			return "Error saving inventory to file";
		}
		
		return "";
	}
}
