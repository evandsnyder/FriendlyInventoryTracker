package com.friendlygeek.fit.service;

import com.friendlygeek.fit.service.account.IProfileService;
import com.friendlygeek.fit.service.account.ProfileServiceImpl;
import com.friendlygeek.fit.service.authentication.AuthenticationServiceImpl;
import com.friendlygeek.fit.service.authentication.IAuthenticationService;
import com.friendlygeek.fit.service.inventory.IInventoryService;
import com.friendlygeek.fit.service.inventory.InventoryServiceImpl;

public class ServiceFactory {
	private IAuthenticationService authService;
	private IProfileService profileService;
	private IInventoryService inventoryService;

	public IService getService(String serviceName) {
		if(serviceName.contains("authentication")) {
			if(authService == null) {
				authService = new AuthenticationServiceImpl();
			}
			return authService;
		}
		
		if(serviceName.contains("profile")) {
			if(profileService == null) {
				profileService = new ProfileServiceImpl();
			}
			return profileService;
		}
		
		if(serviceName.contains("inventory")) {
			if(inventoryService == null) {
				inventoryService = new InventoryServiceImpl();
			}
			return inventoryService;
		}
		
		return null;
	}
}
