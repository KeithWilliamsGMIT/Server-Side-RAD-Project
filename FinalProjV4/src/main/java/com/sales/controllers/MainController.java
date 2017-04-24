package com.sales.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Product;

@Controller
public class MainController {
	
	@RequestMapping(value="/showProducts", method=RequestMethod.GET)
	public String getShowProducts() {
		return "showProducts";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.GET)
	public String getAddProduct(@ModelAttribute ("Product") Product product) {
		return "addProduct";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String postAddProduct(@ModelAttribute ("Product") Product product) {
		System.out.println(product.getQtyInStock() + "," + product.getpDesc());
		return "addProduct";
	}
}
