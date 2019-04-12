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
		
		//create a query...sort by last name update sql
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
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
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
	
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//now retrieve from the database using the primary key
		Customer customer = currentSession.get(Customer.class, theId);
		
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete customer
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerID");
		theQuery.setParameter("customerID", theId);
		
		theQuery.executeUpdate();
	}


}
