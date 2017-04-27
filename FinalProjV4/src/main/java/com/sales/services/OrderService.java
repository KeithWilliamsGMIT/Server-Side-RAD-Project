package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.repositories.OrderRepository;

@Service("OrderService")
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public void addOrder(Order order) {
		orderRepository.save(order);
	}
	
	public ArrayList<Order> getOrders() {
		return (ArrayList<Order>) orderRepository.findAll();
	}
}
