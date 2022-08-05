package com.friendlygeek.fit.view.loginframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.friendlygeek.fit.business.FriendlyInventoryTrackerManager;
import com.friendlygeek.fit.view.inventoryframe.InventoryFrame;
import com.friendlygeek.fit.view.inventoryframe.InventoryFrameController;

public class LoginFrameController implements ActionListener {
	
	private LoginFrame loginFrame;
	private FriendlyInventoryTrackerManager fitManager;

	public LoginFrameController(FriendlyInventoryTrackerManager fitManager, LoginFrame loginFrame) {
		this.fitManager = fitManager;
		this.loginFrame = loginFrame;
		
		loginFrame.getLoginButton().addActionListener(this);
		loginFrame.getCancelButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(loginFrame.getLoginButton())){
			onLogin(e);
		} else if (e.getSource().equals(loginFrame.getCancelButton())) {
			onCancelLogin(e);
		}
	}
	
	private void onLogin(ActionEvent event) {
		System.out.println("Attempting to login in...");
		
		var username = loginFrame.getUsernameField().getText();
		var password = loginFrame.getPasswordField().getText(); // I know this is bad practice
		
		var result = fitManager.authenticateUser(username, password);
		if(!result.contains("Successfully")) {
			loginFrame.getErrorLabel().setText(result);
			return;
		}
		
		// Otherwise we can destroy this window and move on to the next window...
		InventoryFrame inventoryFrame = new InventoryFrame();
		InventoryFrameController inventoryController = new InventoryFrameController(fitManager, inventoryFrame);
		inventoryFrame.setVisible(true);
		
		loginFrame.dispose();
	}
	
	private void onCancelLogin(ActionEvent event) {
		System.out.println("Exiting");
		System.exit(0);
	}

}
