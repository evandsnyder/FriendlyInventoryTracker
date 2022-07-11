package com.friendlygeek.fit.domain;

import java.util.Objects;
import java.util.UUID;

public class User {
	private UUID id;
	private Name name;
	private Profile profile;

	/**
	 * Default Constructor
	 */
	public User() {
		this.id = UUID.randomUUID();
	}

	/**
	 * Full Constructor
	 * 
	 * @param name    - Name of the user
	 * @param profile - Profile information for the user
	 */
	public User(Name name, Profile profile) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.profile = profile;
	}

	/**
	 * Full Convenience Constructor
	 * 
	 * Will construct the Name and Profile objects for the User
	 * 
	 * @param fName    - User's first name
	 * @param lName    - User's last name
	 * @param username - Users's username
	 * @param email    - User's email
	 * @param password - User's password
	 */
	public User(String fName, String lName, String username, String email, String password) {
		this.id = UUID.randomUUID();
		this.name = new Name(fName, lName);
		this.profile = new Profile(username, email, password);
	}

	/**
	 * Copy Constructor
	 * 
	 * @param o - User to copy
	 */
	public User(User o) {
		this.id = o.id;
		this.name = o.name;
		this.profile = o.profile;
	}

	public boolean validate() {
		if (this.id == null) {
			return false;
		}
		if (this.name == null || !this.name.validate())
			return false;

		if (this.profile == null || !this.profile.validate()) {
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

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", profile=" + profile + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, profile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(profile, other.profile);
	}

}
