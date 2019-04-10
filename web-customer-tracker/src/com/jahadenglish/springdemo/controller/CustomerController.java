package com.jahadenglish.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jahadenglish.springdemo.DAO.CustomerDAO;
import com.jahadenglish.springdemo.Entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the DAO into the controller
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from DAO
		List<Customer> customers = customerDAO.getCustomers();
		
		//add customers to spring MVC model to make it available 
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
