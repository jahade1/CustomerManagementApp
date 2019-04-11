package com.jahadenglish.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jahadenglish.springdemo.DAO.CustomerDAO;
import com.jahadenglish.springdemo.Entity.Customer;

//add service annotation to the service implementation
@Service
public class CustomerServiceImpl implements CustomerService {
	
	//injects the CustomerDAO object
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		//delegates call to the DAO so there no need to call the DAO directly
		
		return customerDAO.getCustomers();
	}

}
