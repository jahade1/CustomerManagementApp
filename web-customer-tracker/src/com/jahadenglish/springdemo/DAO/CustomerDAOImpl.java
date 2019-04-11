package com.jahadenglish.springdemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jahadenglish.springdemo.Entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	//no need for transactional because its being delegated by the service layer
	@Override
	public List<Customer> getCustomers() {
		
		//need to get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer ", Customer.class);
		
		//get list from query
		
		List<Customer> customers = theQuery.getResultList();
		
		//return list
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer..
		currentSession.save(theCustomer);
	}

}
