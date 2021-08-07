package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;

@RestController
@RequestMapping(value = "/v1/orderservice")
public class OrderServiceController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createOrder(@RequestBody Order order) {
		Order createOrder = orderService.createOrder(order);
		return "Order Status = " + createOrder.getStatus() + ". Total Order is: " + createOrder.getTotalOrder();
	}

}
