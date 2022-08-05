package com.friendlygeek.fit.view.inventoryframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class InventoryFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryFrame frame = new InventoryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InventoryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(640, 480, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		loadInventoryMenuItem = new JMenuItem("Load Inventory");
		loadInventoryMenuItem.setActionCommand("Load Inventory...");
		fileMenu.add(loadInventoryMenuItem);
		
		saveInventoryMenuItem = new JMenuItem("Save Inventory");
		fileMenu.add(saveInventoryMenuItem);
		
		JMenu inventoryMenu = new JMenu("Inventory");
		menuBar.add(inventoryMenu);
		
		addAssetMenuItem = new JMenuItem("Add Asset");
		inventoryMenu.add(addAssetMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		inventoryTable = new JTable();
		inventoryTable.setFillsViewportHeight(true);
		inventoryTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {"ID", "Name", "Description", "Quantity", "UoM"
			}
		));
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(inventoryTable);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
	
	private JMenuItem loadInventoryMenuItem;
	public JMenuItem getLoadInventoryMenuItem() {
		return loadInventoryMenuItem;
	}

	public void setLoadInventoryMenuItem(JMenuItem loadInventoryMenuItem) {
		this.loadInventoryMenuItem = loadInventoryMenuItem;
	}

	public JMenuItem getAddAssetMenuItem() {
		return addAssetMenuItem;
	}

	public void setAddAssetMenuItem(JMenuItem addAssetMenuItem) {
		this.addAssetMenuItem = addAssetMenuItem;
	}

	private JMenuItem addAssetMenuItem;
	
	private JMenuItem saveInventoryMenuItem;

	public JMenuItem getSaveInventoryMenuItem() {
		return saveInventoryMenuItem;
	}

	public void setSaveInventoryMenuItem(JMenuItem saveInventoryMenuItem) {
		this.saveInventoryMenuItem = saveInventoryMenuItem;
	}
	
	private JTable inventoryTable;
	private JScrollPane scrollPane;
	
	public JTable getInventoryTable() {
		return inventoryTable;
	}
}
