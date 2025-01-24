package com.htc.orderProduct.entity;

import java.util.List;

public class OrderProduct {

    private String orderId;
    private List<Product> productList; // Order has list of product
    
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public OrderProduct(String orderId, List<Product> productList) {
		super();
		this.orderId = orderId;
		this.productList = productList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
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
		OrderProduct other = (OrderProduct) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderProduct [orderId=" + orderId + ", productList=" + productList + "]";
	}
	
    
    // define constructor, getter, setter, hashcode(), equals() and toString()

}