package com.jahadenglish.springdemo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jahadenglish.springdemo.Entity.Customer;
import com.jahadenglish.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the customer service since it delegates to the DAO
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from DAO
		List<Customer> customers = customerService.getCustomers();
		
		//add customers to spring MVC model to make it available 
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/ShowFormforAdd")
	public String showFormforAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer
		customerService.saveCustomer(theCustomer);
			
		return "redirect:/customer/list"; 
	}
	
	@GetMapping("/showFormforUpdate")
	public String showFormforUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get the customer from the service who delegates to the database
		Customer theCustomer = customerService.getCustomer(theId);
		
		//save customer as a model attribute to prepopulate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to our form to be displayed
		return "customer-form";
		}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
		
		}
	
}
