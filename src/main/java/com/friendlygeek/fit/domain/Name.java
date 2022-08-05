package com.friendlygeek.fit.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Name implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4188043336297288470L;
	private UUID id;
	private String firstName;
	private String lastName;

	/**
	 * Default constructor
	 */
	public Name() {
		id = UUID.randomUUID();
	}

	/**
	 * Full Constructor
	 * 
	 * @param firstName - User's first name
	 * @param lastName  - User's last name
	 */
	public Name(String firstName, String lastName) {
		id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Copy Constructor
	 * 
	 * @param o - Name to copy
	 */
	public Name(Name o) {
		this.id = o.id;
		this.firstName = o.firstName;
		this.lastName = o.lastName;
	}

	public boolean validate() {
		if (this.id == null)
			return false;

		if (this.firstName == null || this.firstName.isBlank() || this.firstName.isEmpty())
			return false;

		if (this.lastName == null || this.lastName.isBlank() || this.lastName.isEmpty())
			return false;

		return true;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", lastName, firstName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}

}
