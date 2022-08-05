package com.friendlygeek.fit.view.inventoryframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import com.friendlygeek.fit.business.FriendlyInventoryTrackerManager;
import com.friendlygeek.fit.view.MessageDialog;

public class InventoryFrameController implements ActionListener {

	private InventoryFrame inventoryFrame;
	private FriendlyInventoryTrackerManager fitManager;

	public InventoryFrameController(FriendlyInventoryTrackerManager fitManager, InventoryFrame inventoryFrame) {
		this.fitManager = fitManager;
		this.inventoryFrame = inventoryFrame;

		inventoryFrame.getAddAssetMenuItem().addActionListener(this);
		inventoryFrame.getLoadInventoryMenuItem().addActionListener(this);
		inventoryFrame.getSaveInventoryMenuItem().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(inventoryFrame.getAddAssetMenuItem())) {
			// open the add asset UI
			onAddAsset(e);
		} else if (e.getSource().equals(inventoryFrame.getLoadInventoryMenuItem())) {
			onLoadInventory(e);
		} else if (e.getSource().equals(inventoryFrame.getSaveInventoryMenuItem())) {
			onSaveInventory(e);
		}

	}

	private void onAddAsset(ActionEvent event) {
		// open add asset dialog....
		ModifyAssetDialog editDialog = new ModifyAssetDialog();
		editDialog.setModal(true);
		var asset = editDialog.showDialog();

		if (asset != null) {
			fitManager.addToInventory(asset);
			// Also need to update the inventory list with the new item..
			Object[] data = { asset.getInternalId(), asset.getCommonName(), asset.getDescription(), asset.getQuantity(),
					asset.getUnitOfMeasure().getUnit() };
			((DefaultTableModel) inventoryFrame.getInventoryTable().getModel()).addRow(data);
		}
	}

	private void onLoadInventory(ActionEvent event) {
		// open file explorer and allow selecting a file...
		JFileChooser fileChooser = new JFileChooser();
		var result = fileChooser.showOpenDialog(inventoryFrame);

		if (result != JFileChooser.APPROVE_OPTION) {
			return;
		}

		File inventoryFile = fileChooser.getSelectedFile();
		var loadResult = fitManager.loadInventory(inventoryFile);

		if (!loadResult.contains("Successfully")) {
			MessageDialog dlg = new MessageDialog(loadResult);
			dlg.setModal(true);
			dlg.setVisible(true);
			return;
		}

		// Otherwise, we can get the whole inventory from the manager and render it in
		// the list...
		var inventory = fitManager.getInventory();
		if (inventory == null) {
			MessageDialog dlg = new MessageDialog("Error loading inventory");
			dlg.setModal(true);
			dlg.setVisible(true);
		}

		//
		String[] columnNames = { "ID", "Name", "Description", "Quantity", "UoM" };
		DefaultTableModel newModel = new DefaultTableModel(columnNames, 0);

		for (var asset : inventory) {
			Object[] data = { asset.getInternalId(), asset.getCommonName(), asset.getDescription(), asset.getQuantity(),
					asset.getUnitOfMeasure().getUnit() };
			newModel.addRow(data);
		}

		inventoryFrame.getInventoryTable().setModel(newModel);
	}

	private void onSaveInventory(ActionEvent event) {
		JFileChooser saveFileChooser = new JFileChooser();
		saveFileChooser.setDialogTitle("Select save destination");
		int userSelection = saveFileChooser.showSaveDialog(inventoryFrame);
		if(userSelection == JFileChooser.APPROVE_OPTION) {
			File saveDestination = saveFileChooser.getSelectedFile();
			var result = fitManager.saveInventory(saveDestination);
			
			if(!result.isEmpty()) {
				MessageDialog dlg = new MessageDialog(result);
				dlg.setModal(true);
				dlg.setVisible(true);
			}
		}
	}

}
