package com.friendlygeek.fit.domain;

import java.util.Objects;
import java.util.UUID;

public class Asset {
	private UUID id;
	private String commonName;
	private String internalId;
	private Long quantity;
	private UnitOfMeasure unitOfMeasure;
	private String description;

	/**
	 * Default Constructor
	 */
	public Asset() {
		id = UUID.randomUUID();
	}

	/**
	 * Full Constructor
	 * 
	 * @param commonName - Name of asset
	 * @param internalId - Id for inter-organization use
	 * @param quantity   - how much
	 * @param uom        - the Unit of Measure describing the quantity
	 */
	public Asset(String commonName, String internalId, Long quantity, UnitOfMeasure uom) {
		id = UUID.randomUUID();
		this.commonName = commonName;
		this.internalId = internalId;
		this.quantity = quantity;
		this.unitOfMeasure = uom;
	}

	/**
	 * Copy Constructor
	 * 
	 * @param o - other Asset to copy
	 */
	public Asset(Asset o) {
		id = o.id;
		this.commonName = o.commonName;
		this.internalId = o.internalId;
		this.quantity = o.quantity;
		this.unitOfMeasure = o.unitOfMeasure;
	}

	public boolean validate() {
		if (this.commonName == null || this.commonName.isBlank() || this.commonName.isEmpty()) {
			return false;
		}

		if (this.id == null)
			return false;

		if (this.internalId == null || this.commonName.isBlank() || this.commonName.isEmpty()) {
			return false;
		}

		if (this.quantity == null || this.quantity < 0) {
			return false;
		}

		if (this.unitOfMeasure == null || !this.unitOfMeasure.validate()) {
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

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getInternalId() {
		return internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commonName, description, id, internalId, quantity, unitOfMeasure);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asset other = (Asset) obj;
		return Objects.equals(commonName, other.commonName) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(internalId, other.internalId)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(unitOfMeasure, other.unitOfMeasure);
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", commonName=" + commonName + ", internalId=" + internalId + ", quantity="
				+ quantity + ", unitOfMeasure=" + unitOfMeasure + ", description=" + description + "]";
	}

}
