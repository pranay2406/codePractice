package com.htc.orderProduct.entity;

import java.time.LocalDate;

public class Product {
    
    private String productId;
    private String productDescription;
    private int quantityOnHand;
    private float unitiPrice;
    private LocalDate manufacturedDate;
    private LocalDate expiryDate;
    
	public Product(String productId, String productDescription, int quantityOnHand, float unitiPrice,
			LocalDate manufacturedDate, LocalDate expiryDate) {
		super();
		this.productId = productId;
		this.productDescription = productDescription;
		this.quantityOnHand = quantityOnHand;
		this.unitiPrice = unitiPrice;
		this.manufacturedDate = manufacturedDate;
		this.expiryDate = expiryDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public float getUnitiPrice() {
		return unitiPrice;
	}

	public void setUnitiPrice(float unitiPrice) {
		this.unitiPrice = unitiPrice;
	}

	public LocalDate getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(LocalDate manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((manufacturedDate == null) ? 0 : manufacturedDate.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + quantityOnHand;
		result = prime * result + Float.floatToIntBits(unitiPrice);
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
		Product other = (Product) obj;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (manufacturedDate == null) {
			if (other.manufacturedDate != null)
				return false;
		} else if (!manufacturedDate.equals(other.manufacturedDate))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantityOnHand != other.quantityOnHand)
			return false;
		if (Float.floatToIntBits(unitiPrice) != Float.floatToIntBits(other.unitiPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productDescription=" + productDescription + ", quantityOnHand="
				+ quantityOnHand + ", unitiPrice=" + unitiPrice + ", manufacturedDate=" + manufacturedDate
				+ ", expiryDate=" + expiryDate + "]";
	}
	
    // define constructor, getter, setter, hashcode(), equals() and toString()

}