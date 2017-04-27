package com.sales.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.ProductService;
import com.sales.services.CustomerService;

@Controller
public class MainController {
	@Autowired
	@Qualifier("ProductService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("CustomerService")
	private CustomerService customerService;
	
	// Products
	@RequestMapping(value="/showProducts", method=RequestMethod.GET)
	public String getShowProducts(Model model) {
		model.addAttribute("Products", productService.getProducts());
		return "showProducts";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.GET)
	public String getAddProduct(@ModelAttribute ("Product") Product product) {
		return "addProduct";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String postAddProduct(@Valid @ModelAttribute ("Product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "addProduct";
		} else {
			productService.addProduct(product);
			return "redirect:showProducts";
		}
	}
	
	// Customers
	@RequestMapping(value="/showCustomers", method=RequestMethod.GET)
	public String getShowCustomers(Model model) {
		model.addAttribute("Customers", customerService.getCustomers());
		return "showCustomers";
	}
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.GET)
	public String getAddCustomer(@ModelAttribute ("Customer") Customer customer) {
		return "addCustomer";
	}
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
	public String postAddProduct(@Valid @ModelAttribute ("Customer") Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "addCustomer";
		} else {
			customerService.addCustomer(customer);
			return "redirect:showCustomers";
		}
	}
	
	// Orders
	@RequestMapping(value="/showOrders", method=RequestMethod.GET)
	public String getShowOrders() {
		return "showOrders";
	}
	
	@RequestMapping(value="/addOrder", method=RequestMethod.GET)
	public String getAddCustomer(@ModelAttribute ("Order") Order order) {
		return "addOrder";
	}
	
	@RequestMapping(value="/addOrder", method=RequestMethod.POST)
	public String postAddProduct(@Valid @ModelAttribute ("Order") Order order, BindingResult result) {
		if (result.hasErrors()) {
			return "addOrder";
		} else {
			return "redirect:showOrders";
		}
	}
}
