package com.app.service.impl;

import org.apache.log4j.Logger;

import com.app.dao.CustomerSearchDAO;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
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
	public CustomerAccount deposit(long customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerAccount withdraw(long customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerAccount sendMoney(long customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerAccount receiveMoney(long customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerAccount viewIncoming(long custumerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
