package com.friendlygeek.fit.domain;

import java.io.Serializable;
import java.util.UUID;

public class UnitOfMeasure implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8467861805308579952L;
	private UUID id;
	private String unit;

	/**
	 * Default Constructor
	 */
	public UnitOfMeasure() {
		this.id = UUID.randomUUID();
	}

	/**
	 * Full Constructor
	 * 
	 * @param unit - The unit of measure
	 */
	public UnitOfMeasure(String unit) {
		this.id = UUID.randomUUID();
		this.unit = unit;
	}

	/**
	 * Copy Constructor
	 * 
	 * @param o - UnitOfMeasure to copy
	 */
	public UnitOfMeasure(UnitOfMeasure o) {
		this.id = o.id;
		this.unit = o.unit;

	}

	public boolean validate() {
		if (this.id == null)
			return false;

		if (this.unit == null || this.unit.isEmpty() || this.unit.isBlank())
			return false;
		
		return true;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnitOfMeasure other = (UnitOfMeasure) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return unit;
	}

}
