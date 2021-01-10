package com.app.service.impl;

import com.app.dao.CustomerCrudDAO;
import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.exception.BusinessException;
import com.app.main.bankingMain;
import com.app.model.Customer;
import com.app.model.CustomerAccount;
import com.app.model.TransactionRequests;
import com.app.service.CustomerCrudService;

import java.time.LocalDateTime;
import java.util.Date;

import org.apache.log4j.Logger;

public class CustomerCrudServiceImpl implements CustomerCrudService {
	private static Logger log = Logger.getLogger(CustomerCrudServiceImpl.class); 
	
	CustomerCrudDAOImpl dao = new CustomerCrudDAOImpl(); 
	//CustomerCrudDAO customerCrudDAO = new CustomerCrudDAOImpl();

	@Override
	public Customer createCustomer(String customerFirstName, String customerLastName, String customerEmail,
			String customerPassword) throws BusinessException {
		Customer customer = null;
		//customer = customerCrudDAO.createCustomer(customerFirstName, customerLastName, customerEmail, customerPassword);
		
		//code to DAO
		Customer c = new Customer(customerFirstName, customerLastName, customerEmail, customerPassword);
		if(dao.createCustomer(c) != 0) {
			log.info("Customer created successfully.");
		}
		return customer;
	}
	
	@Override
	public CustomerAccount createBalance(long accountBalance) throws BusinessException {
		CustomerAccount customerAccount = null;
		//code to DAO
		CustomerAccount c = new CustomerAccount(accountBalance);
		try {
			if(dao.createBalance(c) != 0) {
				log.info("Balance created successfully.");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return customerAccount;
	}

	@Override
	public CustomerAccount deposit(long customerId, long amount) throws BusinessException {
		CustomerAccount customerAccount = null;
		//code to DAO
		CustomerAccount c = new CustomerAccount(customerId, amount);
		try {
			if(dao.deposit(c) != 0) {
				log.info("Deposit was successful.");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return customerAccount;
	}

	@Override
	public CustomerAccount withdraw(long customerId, long amount) throws BusinessException {
		CustomerAccount customerAccount = null;
		//code to DAO
		CustomerAccount c = new CustomerAccount(customerId, amount);
		try {
			if(dao.withdraw(c) != 0) {
				log.info("Withdrawal was successful.");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return customerAccount;
	}

	@Override
	public TransactionRequests sendMoney(long amount,long sendingAccountNumber, long receivingAccountNumber) throws BusinessException {
		TransactionRequests transactionRequests = null;
		//code to DAO
		TransactionRequests c = new TransactionRequests(amount, sendingAccountNumber, receivingAccountNumber);
		try {
			if(dao.sendMoney(c) != 0) {
				log.info("Sending money request was successful.");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return transactionRequests;
	}

	@Override
	public CustomerAccount receiveMoney(long accountNumber, long amount) throws BusinessException {
		CustomerAccount customerAccount = null;
		//code to DAO
		CustomerAccount c = new CustomerAccount(accountNumber, amount);
		try {
			if(dao.receiveMoney(c) != 0) {
				log.info("Withdrawal was successful.");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return customerAccount;
	}

	@Override
	public Customer deleteCustomer(long customerId) throws BusinessException {
		Customer customer = null;
		//code to DAO
		Customer c = new Customer(customerId);
		try {
			if(dao.deleteCustomer(c) != 0) {
				log.info("Delete was successful.");
			}
		} catch (BusinessException e) {
			log.info(e.getMessage());
		}		
		return customer;
	}
	


	
	
}
