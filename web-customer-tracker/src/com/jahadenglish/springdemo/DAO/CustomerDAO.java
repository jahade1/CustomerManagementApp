package com.jahadenglish.springdemo.DAO;

import java.util.List;

import com.jahadenglish.springdemo.Entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
}
