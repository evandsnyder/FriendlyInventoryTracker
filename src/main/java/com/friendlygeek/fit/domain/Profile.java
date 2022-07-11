package com.friendlygeek.fit.domain;

import java.util.Objects;
import java.util.UUID;

public class Profile {
	private UUID id;
	private String username;
	private String email;
	private String password;

	/**
	 * Default Constructor
	 */
	public Profile() {
		id = UUID.randomUUID();
	}

	/**
	 * Full Constructor
	 * 
	 * @param username - User's username
	 * @param email    - User's email
	 * @param password - User's password
	 */
	public Profile(String username, String email, String password) {
		id = UUID.randomUUID();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	/**
	 * Copy Constructor
	 * 
	 * @param o - Profile to copy
	 */
	public Profile(Profile o) {
		this.id = o.id;
		this.username = o.username;
		this.email = o.email;
		this.password = o.password;
	}

	public boolean validate() {
		if (this.id == null)
			return false;

		if (this.username == null || this.username.isEmpty() || this.username.isBlank()) {
			return false;
		}

		if (this.email == null || this.email.isBlank() || this.email.isEmpty()) {
			return false;
		}

		if (this.password == null || this.password.isEmpty() || this.password.isBlank()) {
			return false;
		}

		return true;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Profile [username=" + username + ", email=" + email + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

}
