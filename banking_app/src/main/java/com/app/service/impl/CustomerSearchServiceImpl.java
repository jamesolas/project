package com.app.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerSearchDAO;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.Employee;
import com.app.model.TransactionRequests;
import com.app.model.Transactions;
import com.app.service.CustomerSearchService;


public class CustomerSearchServiceImpl implements CustomerSearchService {
	
	CustomerSearchDAOImpl dao = new CustomerSearchDAOImpl();
	private CustomerSearchDAO customerSearchDAO = new CustomerSearchDAOImpl();
	
	private static Logger log = Logger.getLogger(CustomerSearchServiceImpl.class);

	@Override
	public Customer customerLogin(String customerEmail, String customerPassword) throws BusinessException {
		Customer customer = null;
		if(customerEmail.length() > 0 && customerPassword.length() > 0) {
			//code here for DAO
			customer = customerSearchDAO.customerLogin(customerEmail, customerPassword);
		}else {
			throw new BusinessException ("Entered email and password are invalid.");
		}
		return customer;
	}

	@Override
	public CustomerAccount viewBalance(long customerId) throws BusinessException {
		CustomerAccount customerAccount = null;
		
		if(customerId > 0) {
			//code to DAO
			customerAccount = customerSearchDAO.viewBalance(customerId);
		}else {
			throw new BusinessException("Customer Id "+customerId+" is invalid.");
		}
		return customerAccount;
	}
	
	@Override
	public String findCustomerId(String customerEmail) throws BusinessException {
		String customerId2 = null;
		if(customerEmail.length() > 0) {
			//code to DAO
			customerId2 = Long.toString(customerSearchDAO.findCustomerId(customerEmail));
		}
		
		return customerId2;
	}

	@Override
	public long findAccountNumber(long longId) throws BusinessException {
		long longId2 = 0;
		if(longId > 0) {
			//code to DAO
			longId2 = customerSearchDAO.findAccountNumber(longId);
		}
		
		return longId2;
	}
	
	@Override
	public long findBalance(long customerId) throws BusinessException {
		long longId2 = 0;
		if(customerId > 0) {
			//code to DAO
			longId2 = customerSearchDAO.findBalance(customerId);
		}
		
		return longId2;
	}

	@Override
	public List<TransactionRequests> findReceiving(long receivingAccount) throws BusinessException {
		List<TransactionRequests> transactionRequests = null;
		if(receivingAccount > 0) {
			int receivingAccountInt= (int)receivingAccount;
			//code here for DAO
			transactionRequests = customerSearchDAO.findReceiving(receivingAccountInt);
		}else {
			throw new BusinessException("Entered account number " + receivingAccount + " is invalid.");
		}
		return transactionRequests;
	}

	@Override
	public Employee employeeLogin(String employeeEmail, String employeePassword) throws BusinessException {
		Employee employee = null;
		if(employeeEmail.length() > 0 && employeePassword.length() > 0) {
			//code here for DAO
			employee = customerSearchDAO.employeeLogin(employeeEmail, employeePassword);
		}else {
			throw new BusinessException ("Entered email and password are invalid.");
		}
		return employee;
	}

	@Override
	public List<Customer> viewCustomerBalances() throws BusinessException {
		List<Customer> customerBalances = null;
			//code here for DAO
			customerBalances = customerSearchDAO.viewCustomerBalances();
		return customerBalances;
	}

	@Override
	public List<Transactions> viewAllTransactions() throws BusinessException {
		List<Transactions> viewTransactions = null;
		//code here for DAO
		viewTransactions = customerSearchDAO.viewAllTransactions();
	return viewTransactions;
	}

	

	
	
	
}
