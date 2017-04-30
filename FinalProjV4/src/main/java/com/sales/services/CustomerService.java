package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service("CustomerService")
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public Customer getCustomer(long cId) {
		return (Customer) customerRepository.findByCId(cId);
	}
	
	public ArrayList<Customer> getCustomers() {
		return (ArrayList<Customer>) customerRepository.findAll();
	}
}
