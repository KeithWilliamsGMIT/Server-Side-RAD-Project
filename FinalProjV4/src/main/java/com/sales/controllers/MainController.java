package com.sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class MainController {
	@Autowired
	@Qualifier("ProductService")
	private ProductService productService;
	
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
	public String postAddProduct(@ModelAttribute ("Product") Product product) {
		productService.addProduct(product);
		return "addProduct";
	}
}
