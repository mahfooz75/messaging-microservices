package com.example.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderLine {

	@JsonProperty("product_id")
	private int productId;

	@JsonProperty("quantity")
	private int quantity;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
