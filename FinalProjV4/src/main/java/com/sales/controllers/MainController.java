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
import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class MainController {
	@Autowired
	@Qualifier("ProductService")
	private ProductService productService;
	
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
	public String getShowCustomers() {
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
			return "redirect:showCustomers";
		}
	}
}
