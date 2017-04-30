package com.sales.exceptions;

import com.sales.models.Order;

public class OrderException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Order order;
	private String message;
	
	public OrderException(Order order, String message) {
		super();
		this.order = order;
		this.message = message;
	}
	
	public Order getOrder() {
		return order;
	}

	public String getMessage() {
		return message;
	}
}
