package com.friendlygeek.fit.view.inventoryframe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.friendlygeek.fit.domain.Asset;
import com.friendlygeek.fit.domain.UnitOfMeasure;
import com.friendlygeek.fit.view.MessageDialog;

import javax.swing.JLabel;

import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class ModifyAssetDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField nameTextField;
	private JTextField internalIdTextField;
	private JTextArea descriptionTextArea;
	private JSpinner quantitySpinner;
	private JComboBox<UnitOfMeasure> measurementComboBox;
	
	private JButton saveButton;
	private JButton cancelButton;
	
	private ArrayList<UnitOfMeasure> knownUoMs;
	
	private Asset asset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifyAssetDialog dialog = new ModifyAssetDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ModifyAssetDialog() {
		initializeDialogComponents();
	}
	public ModifyAssetDialog(Asset asset) {
		this.asset = asset;
		initializeDialogComponents();
	}
	
	
	private void initializeDialogComponents() {
		knownUoMs = new ArrayList<>();
		knownUoMs.add(new UnitOfMeasure("gram"));
		knownUoMs.add(new UnitOfMeasure("kilogram"));
		knownUoMs.add(new UnitOfMeasure("milligram"));
		knownUoMs.add(new UnitOfMeasure("meter"));
		knownUoMs.add(new UnitOfMeasure("kilometer"));
		knownUoMs.add(new UnitOfMeasure("millimeter"));
		knownUoMs.add(new UnitOfMeasure("liter"));
		knownUoMs.add(new UnitOfMeasure("milliliter"));
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{212, 212, 0};
		gbl_contentPanel.rowHeights = new int[]{43, 43, 43, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Edit Asset");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Common Name");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 1;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			nameTextField = new JTextField();
			GridBagConstraints gbc_nameTextField = new GridBagConstraints();
			gbc_nameTextField.insets = new Insets(0, 0, 5, 0);
			gbc_nameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_nameTextField.gridx = 1;
			gbc_nameTextField.gridy = 1;
			contentPanel.add(nameTextField, gbc_nameTextField);
			nameTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Internal ID");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			internalIdTextField = new JTextField();
			GridBagConstraints gbc_internalIdTextField = new GridBagConstraints();
			gbc_internalIdTextField.insets = new Insets(0, 0, 5, 0);
			gbc_internalIdTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_internalIdTextField.gridx = 1;
			gbc_internalIdTextField.gridy = 2;
			contentPanel.add(internalIdTextField, gbc_internalIdTextField);
			internalIdTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Quantity");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			contentPanel.add(panel, gbc_panel);
			panel.setLayout(new GridLayout(0, 2, 2, 0));
			{
				quantitySpinner = new JSpinner();
				panel.add(quantitySpinner);
			}
			{
				measurementComboBox = new JComboBox<>();
				for(var u : knownUoMs) {
					measurementComboBox.addItem(u);
				}
				panel.add(measurementComboBox);
			}
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Description");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHEAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 4;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			descriptionTextArea = new JTextArea();
			GridBagConstraints gbc_descriptionTextArea = new GridBagConstraints();
			gbc_descriptionTextArea.gridheight = 2;
			gbc_descriptionTextArea.insets = new Insets(0, 0, 5, 0);
			gbc_descriptionTextArea.fill = GridBagConstraints.BOTH;
			gbc_descriptionTextArea.gridx = 1;
			gbc_descriptionTextArea.gridy = 4;
			contentPanel.add(descriptionTextArea, gbc_descriptionTextArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				saveButton = new JButton("Save");
				saveButton.setActionCommand("Save");
				buttonPane.add(saveButton);
				getRootPane().setDefaultButton(saveButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == saveButton) {
			processResult();
		} else if (e.getSource() == cancelButton) {
			processCancel();
		}
		
	}
	
	private void processResult() {
		var uom = (UnitOfMeasure)measurementComboBox.getSelectedItem();
		if(asset == null) {
			asset = new Asset(nameTextField.getText(), internalIdTextField.getText(), Long.valueOf(quantitySpinner.getValue().toString()), uom, descriptionTextArea.getText());
		} else {
			// edit the existing one...
			asset.setCommonName(nameTextField.getText());
			asset.setInternalId(internalIdTextField.getText());
			asset.setQuantity(Long.valueOf(quantitySpinner.getValue().toString()));
			asset.setUnitOfMeasure(uom);
			asset.setDescription(descriptionTextArea.getText());
		}
		
		if(!asset.validate()) {
			// we've got a validation error!
			MessageDialog dlg = new MessageDialog("Invalid inputs supplied");
			dlg.setModal(true);
			dlg.setVisible(true);
			return;
		}
		
		setVisible(false);
		this.dispose();
	}
	
	private void processCancel() {
		System.out.println("Cancelling operations....");
		asset = null;
		setVisible(false);
		this.dispose();
	}
	
	public Asset showDialog() {
		setVisible(true);
		return asset;
	}
}
