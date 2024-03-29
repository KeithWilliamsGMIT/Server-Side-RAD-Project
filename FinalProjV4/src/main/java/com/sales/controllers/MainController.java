package com.sales.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sales.exceptions.OrderException;
import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.ProductService;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;

@Controller
public class MainController {
	// Services
	@Autowired
	@Qualifier("ProductService")
	private ProductService productService;

	@Autowired
	@Qualifier("CustomerService")
	private CustomerService customerService;

	@Autowired
	@Qualifier("OrderService")
	private OrderService orderService;

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
	public String postAddCustomer(@Valid @ModelAttribute ("Customer") Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "addCustomer";
		} else {
			customerService.addCustomer(customer);
			return "redirect:showCustomers";
		}
	}

	// Orders
	@RequestMapping(value="/showOrders", method=RequestMethod.GET)
	public String getShowOrders(Model model) {
		model.addAttribute("Orders", orderService.getOrders());
		return "showOrders";
	}

	@RequestMapping(value="/addOrder", method=RequestMethod.GET)
	public String getAddOrder(@ModelAttribute ("Order") Order order) {
		return "addOrder";
	}

	@RequestMapping(value="/addOrder", method=RequestMethod.POST)
	public String postAddOrder(@Valid @ModelAttribute ("Order") Order order, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return "addOrder";
		} else {
			Product product = productService.getProduct(order.getProd().getpId());
			Customer customer = customerService.getCustomer(order.getCust().getcId());
			String errorMessage = "";
			
			if (product == null) {
				errorMessage += "No such product: " + order.getProd().getpId();
			} else if (order.getQty() > product.getQtyInStock()) {
				errorMessage += "Quantity too large: Product stock = " + product.getQtyInStock();
			}
			
			if (customer == null) {
				errorMessage += " No such customer: " + order.getCust().getcId();
			}
			
			// If there is no error message then add the order to the database
			if (errorMessage.isEmpty()) {
				// Update product stock and save to database
				int newQtyInStock = product.getQtyInStock() - order.getQty();
				product.setQtyInStock(newQtyInStock);
				productService.addProduct(product);
	
				// Set the order date and save to database
				order.setOrderDate(new java.sql.Date(new java.util.Date().getTime()).toString());
				orderService.addOrder(order);
	
				return "redirect:showOrders";
			} else {
				throw new OrderException(order, errorMessage);
			}
		}
	}

	@ExceptionHandler(OrderException.class)
	public ModelAndView handleCustomException(OrderException ex) {
		ModelAndView model = new ModelAndView("orderError");
		model.addObject("exception", ex);
		return model;
	}
}
