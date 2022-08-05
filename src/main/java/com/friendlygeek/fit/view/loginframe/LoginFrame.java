package com.friendlygeek.fit.view.loginframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.friendlygeek.fit.domain.User;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Component;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel formPanel = new JPanel();
		contentPane.add(formPanel, BorderLayout.CENTER);
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		formPanel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		
		JPanel formLabelPanel = new JPanel();
		panel_1.add(formLabelPanel);
		formLabelPanel.setLayout(new BoxLayout(formLabelPanel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		formLabelPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		formLabelPanel.add(lblNewLabel_2);
		
		JPanel formInputPanel = new JPanel();
		panel_1.add(formInputPanel);
		formInputPanel.setLayout(new BoxLayout(formInputPanel, BoxLayout.Y_AXIS));
		
		usernameField = new JTextField();
		formInputPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		formInputPanel.add(passwordField);
		
		JPanel errroPanel = new JPanel();
		panel_2.add(errroPanel);
		errroPanel.setLayout(new BoxLayout(errroPanel, BoxLayout.X_AXIS));
		
		errorLabel = new JLabel("");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		errroPanel.add(errorLabel);
		
		JPanel actionPanel = new JPanel();
		contentPane.add(actionPanel, BorderLayout.SOUTH);
		
		loginButton = new JButton("Login");
		actionPanel.add(loginButton);
		
		cancelButton = new JButton("Cancel");
		actionPanel.add(cancelButton);
	}
	
	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JLabel getErrorLabel() {
		return errorLabel;
	}

	public void setErrorLabel(JLabel errorLabel) {
		this.errorLabel = errorLabel;
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	
	public User getProvidedCredentials() {
		return new User();
	}

	private JButton loginButton;
	private JButton cancelButton;
	private JLabel errorLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	
}
