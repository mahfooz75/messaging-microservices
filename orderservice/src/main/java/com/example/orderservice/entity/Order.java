package com.example.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

	@JsonProperty("id")
	private int id;

	@JsonProperty("total_order")
	private double totalOrder;

	@JsonProperty("status")
	private String status;

	@JsonProperty("order_line_list")
	private OrderLine[] orderLineList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(double totalOrder) {
		this.totalOrder = totalOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderLine[] getOrderLineList() {
		return orderLineList;
	}

	public void setOrderLineList(OrderLine[] orderLineList) {
		this.orderLineList = orderLineList;
	}

}
