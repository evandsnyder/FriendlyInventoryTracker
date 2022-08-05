package com.friendlygeek.fit.driver;

import com.friendlygeek.fit.business.FriendlyInventoryTrackerManager;
import com.friendlygeek.fit.view.loginframe.LoginFrame;
import com.friendlygeek.fit.view.loginframe.LoginFrameController;

public class FriendlyInventoryTrackerDriver {

	public FriendlyInventoryTrackerDriver() {
		// Initialize everything we need here...
		FriendlyInventoryTrackerManager manager = new FriendlyInventoryTrackerManager();
		
		LoginFrame loginFrame = new LoginFrame();
		LoginFrameController loginController = new LoginFrameController(manager, loginFrame);
		loginFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FriendlyInventoryTrackerDriver();
	}

}
