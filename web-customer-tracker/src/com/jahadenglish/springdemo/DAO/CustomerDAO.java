package com.jahadenglish.springdemo.DAO;

import java.util.List;

import com.jahadenglish.springdemo.Entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
}